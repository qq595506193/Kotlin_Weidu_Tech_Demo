package com.wd.tech.contract

import android.content.Context
import com.wd.tech.callback.IRequestCallback
import java.util.*

interface RegisterContract {
    abstract class RegisterPresenter {

        abstract fun getRegister(context: Context, params: java.util.HashMap<String, Any>?)

    }

    interface IRegisterModel {


        fun getRegister(context: Context, params: HashMap<String, Any>?, iRequestCallback: IRequestCallback)

    }

    interface IRegisterView {


        fun onRegisterSuccess(result: Any)

        fun onRegisterFailed(error: String)

    }
}
