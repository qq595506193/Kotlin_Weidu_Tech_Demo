package com.wd.tech.model

import android.content.Context
import com.kotlinframework.net.network.ApiErrorModel
import com.kotlinframework.net.network.NetResponseObserver
import com.kotlinframework.net.network.NetScheduler
import com.kotlinframework.net.network.RetrofitManager
import com.wd.tech.api.Api
import com.wd.tech.callback.IRequestCallback
import com.wd.tech.contract.RegisterContract
import com.wd.tech.entity.RegisterBean
import com.wd.tech.service.IRegisterService
import java.util.*

class RegisterModel : RegisterContract.IRegisterModel {

    override fun getRegister(context: Context, params: HashMap<String, Any>?, iRequestCallback: IRequestCallback) {
        RetrofitManager.instance.createService(IRegisterService::class.java)
                .doRegister(Api.register_Api, params)
                .compose(NetScheduler.compose())
                .subscribe(object : NetResponseObserver<RegisterBean>(context) {
                    override fun success(data: RegisterBean) {
                        iRequestCallback?.onSuccess(data)
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        iRequestCallback?.onFailed(apiErrorModel.message)
                    }
                })
    }


}
