package com.wd.tech.presenter

import android.content.Context
import com.wd.tech.callback.IRequestCallback
import com.wd.tech.contract.RegisterContract
import com.wd.tech.model.RegisterModel
import java.util.*

class RegisterPresenter(internal var iRegisterView: RegisterContract.IRegisterView?) : RegisterContract.RegisterPresenter() {
    internal var registerModel: RegisterModel

    init {
        registerModel = RegisterModel()
    }

    override fun getRegister(context: Context, params: HashMap<String, Any>?) {
        registerModel.getRegister(context, params, object : IRequestCallback {
            override fun onSuccess(result: Any) {
                if (iRegisterView != null) {
                    iRegisterView!!.onRegisterSuccess(result)
                }
            }

            override fun onFailed(error: String) {
                if (iRegisterView != null) {
                    iRegisterView!!.onRegisterFailed(error)
                }
            }
        })
    }
}
