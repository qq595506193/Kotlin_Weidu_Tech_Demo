package com.wd.tech.service

import com.wd.tech.entity.LoginBean

import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url

interface ILoginService {

    @POST
    @FormUrlEncoded
    fun doLogin(@Url apiUrl: String, @FieldMap params: java.util.HashMap<String, Any>?): Observable<LoginBean>
}
