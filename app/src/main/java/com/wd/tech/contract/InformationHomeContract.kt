package com.wd.tech.contract

import android.content.Context
import com.wd.tech.callback.IRequestCallback

interface InformationHomeContract {
    abstract class InformationHomePresenter {
        abstract fun getInformationHome(context: Context, params: java.util.HashMap<String, Any>?)
    }

    interface IInformationHomeModel {
        fun getInformationHome(context: Context, params: java.util.HashMap<String, Any>?, iRequestCallback: IRequestCallback)
    }

    interface IInformationHomeView {
        fun onInformationHomeSuccess(result: Any)

        fun onInformationHomeFailed(error: String)
    }
}
