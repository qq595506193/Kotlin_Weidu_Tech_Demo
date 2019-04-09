package com.wd.tech.activity

import android.content.Context
import android.view.View
import com.wd.tech.R
import com.wd.tech.activity.base.BaseActivity
import com.wd.tech.contract.RegisterContract
import com.wd.tech.entity.RegisterBean
import com.wd.tech.presenter.RegisterPresenter
import com.wd.tech.utils.RegularUtil
import com.wd.tech.utils.RsaCoder
import kotlinx.android.synthetic.main.activity_register.*
import java.util.*

class RegisterActivity : BaseActivity(), RegisterContract.IRegisterView {


    private var registerPresenter: RegisterPresenter? = null
    private var params: HashMap<String, Any>? = null
    val context: Context? = this


    override fun initData() {
        btn_register!!.setOnClickListener(object : View.OnClickListener {

            private var s: String = null.toString()

            override fun onClick(v: View) {
                val name = ed_name!!.text.toString().trim { it <= ' ' }
                val phone = ed_phone!!.text.toString().trim { it <= ' ' }
                val password = ed_password!!.text.toString().trim { it <= ' ' }
                initRegular(phone)
                try {
                    s = RsaCoder.encryptByPublicKey(password)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                params = HashMap()
                params!!["nickName"] = name
                params!!["phone"] = phone
                params!!["pwd"] = s
                registerPresenter!!.getRegister(context!!, params)

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
        registerPresenter = RegisterPresenter(this)
    }

    override fun bindLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun onRegisterSuccess(result: Any) {
        if (result is RegisterBean) {
            if (result.status == "0000") {
                showToast(result.message!!)
                finish()
            } else {
                showToast(result.message!!)
            }
        }
    }

    override fun onRegisterFailed(error: String) {
        showToast(error)
    }
}
