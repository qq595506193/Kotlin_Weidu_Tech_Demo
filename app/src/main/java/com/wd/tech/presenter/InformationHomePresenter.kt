package com.wd.tech.presenter

import android.content.Context
import com.wd.tech.callback.IRequestCallback
import com.wd.tech.contract.InformationHomeContract
import com.wd.tech.model.InformationHomeModel
import java.util.*

class InformationHomePresenter(internal var iInformationHomeView: InformationHomeContract.IInformationHomeView?) : InformationHomeContract.InformationHomePresenter() {
    internal var informationHomeModel: InformationHomeModel

    init {
        informationHomeModel = InformationHomeModel()
    }

    override fun getInformationHome(context: Context, params: HashMap<String, Any>?) {
        informationHomeModel.getInformationHome(context, params, object : IRequestCallback {
            override fun onSuccess(result: Any) {
                if (iInformationHomeView != null) {
                    iInformationHomeView!!.onInformationHomeSuccess(result)
                }
            }

            override fun onFailed(error: String) {
                if (iInformationHomeView != null) {
                    iInformationHomeView!!.onInformationHomeFailed(error)
                }
            }
        })
    }
}
