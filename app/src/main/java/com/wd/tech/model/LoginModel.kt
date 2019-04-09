package com.wd.tech.model

import android.content.Context
import com.kotlinframework.net.network.ApiErrorModel
import com.kotlinframework.net.network.NetResponseObserver
import com.kotlinframework.net.network.NetScheduler
import com.kotlinframework.net.network.RetrofitManager
import com.wd.tech.api.Api
import com.wd.tech.callback.IRequestCallback
import com.wd.tech.contract.LoginContract
import com.wd.tech.entity.LoginBean
import com.wd.tech.service.ILoginService
import java.util.*

class LoginModel : LoginContract.ILoginModel {
    override fun getLogin(context: Context, params: HashMap<String, Any>?, iRequestCallback: IRequestCallback) {
        RetrofitManager.instance.createService(ILoginService::class.java)
                .doLogin(Api.login_Api, params)
                .compose(NetScheduler.compose())
                .subscribe(object : NetResponseObserver<LoginBean>(context) {
                    override fun success(data: LoginBean) {
                        iRequestCallback?.onSuccess(data)
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        iRequestCallback?.onFailed(apiErrorModel.message)
                    }
                })
    }


}
