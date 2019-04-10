package com.wd.tech.model

import android.content.Context
import com.kotlinframework.net.network.ApiErrorModel
import com.kotlinframework.net.network.NetResponseObserver
import com.kotlinframework.net.network.NetScheduler
import com.kotlinframework.net.network.RetrofitManager
import com.wd.tech.api.Api
import com.wd.tech.callback.IRequestCallback
import com.wd.tech.contract.InformationHomeContract
import com.wd.tech.entity.InformationHomeBean
import com.wd.tech.service.IInformationHomeService
import io.reactivex.Observable
import java.util.*

class InformationHomeModel : InformationHomeContract.IInformationHomeModel {
    override fun getInformationHome(context: Context, params: HashMap<String, Any>?, iRequestCallback: IRequestCallback) {
        RetrofitManager.instance.createService(IInformationHomeService::class.java)
                .doInformationHome(Api.findInformationDetails_Api, params)
                .compose(NetScheduler.compose())
                .subscribe(object : NetResponseObserver<InformationHomeBean>(context) {
                    override fun success(data: InformationHomeBean) {
                        iRequestCallback?.onSuccess(data)
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        iRequestCallback?.onFailed(apiErrorModel.message)
                    }
                })
    }
}
