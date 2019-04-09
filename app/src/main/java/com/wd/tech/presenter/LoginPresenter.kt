package com.wd.tech.presenter

import android.content.Context
import com.wd.tech.callback.IRequestCallback
import com.wd.tech.contract.LoginContract
import com.wd.tech.model.LoginModel

class LoginPresenter(internal var iLoginView: LoginContract.ILoginView?) : LoginContract.LoginPresenter() {
    internal var loginModel: LoginModel

    init {
        loginModel = LoginModel()
    }

    override fun getLogin(context: Context, params: HashMap<String, Any>?) {
        loginModel.getLogin(context, params, object : IRequestCallback {
            override fun onSuccess(result: Any) {
                if (iLoginView != null) {
                    iLoginView!!.onLoginSuccess(result)
                }
            }

            override fun onFailed(error: String) {
                if (iLoginView != null) {
                    iLoginView!!.onLoginFailed(error)
                }
            }
        })
    }
}
