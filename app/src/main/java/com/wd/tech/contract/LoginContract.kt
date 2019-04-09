package com.wd.tech.contract

import android.content.Context
import com.wd.tech.callback.IRequestCallback
import java.util.*

interface LoginContract {
    abstract class LoginPresenter {
        abstract fun getLogin(context: Context, params: java.util.HashMap<String, Any>?)


    }

    interface ILoginModel {

        fun getLogin(context: Context, params: HashMap<String, Any>?, iRequestCallback: IRequestCallback)


    }

    interface ILoginView {

        fun onLoginSuccess(result: Any)

        fun onLoginFailed(error: String)
    }
}
