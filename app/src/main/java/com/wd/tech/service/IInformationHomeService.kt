package com.wd.tech.service

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url
import java.util.*

interface IInformationHomeService {
    @GET
    fun doInformationHome(@Url apiUrl: String, @QueryMap params: HashMap<String, Any>?): Observable<InformationHomeBean>
}
