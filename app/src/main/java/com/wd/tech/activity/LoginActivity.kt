package com.wd.tech.activity

import android.content.Context
import android.content.Intent
import android.view.View
import com.wd.tech.R
import com.wd.tech.activity.base.BaseActivity
import com.wd.tech.contract.LoginContract
import com.wd.tech.entity.LoginBean
import com.wd.tech.presenter.LoginPresenter
import com.wd.tech.utils.RegularUtil
import com.wd.tech.utils.RsaCoder
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

class LoginActivity : BaseActivity(), LoginContract.ILoginView {


    private var loginPresenter: LoginPresenter? = null
    private var params: HashMap<String, Any>? = null
    val context: Context? = this

    override fun initData() {
        btn_login!!.setOnClickListener(object : View.OnClickListener {

            private var s: String = null.toString()

            override fun onClick(v: View) {
                val phone = ed_phone!!.text.toString().trim { it <= ' ' }
                val password = ed_password!!.text.toString().trim { it <= ' ' }
                initRegular(phone)
                try {
                    s = RsaCoder.encryptByPublicKey(password)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                params = HashMap()
                params!!["phone"] = phone
                params!!["pwd"] = s
                loginPresenter!!.getLogin(context!!, params)

            }
        })
    }

    private fun initRegular(phone: String) {
        if (!RegularUtil.isMobileExact(phone)) {
            showToast("请输入合法手机号")
            return
        }
    }

    override fun initView() {
        loginPresenter = LoginPresenter(this)
        initClick()
    }

    private fun initClick() {
        tv_quick_registration!!.setOnClickListener { startActivity(Intent(this@LoginActivity, RegisterActivity::class.java)) }
    }

    override fun bindLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun onLoginSuccess(result: Any) {

        if (result is LoginBean) {
            if (result.status == "0000") {
                showToast(result.message!!)
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            } else {
                showToast(result.message!!)
            }
        }
    }

    override fun onLoginFailed(error: String) {
        showToast(error)
    }
}
