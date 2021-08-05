package com.kakapo.gostrada.model.network

import com.kakapo.gostrada.model.entities.GoStrada
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface GoStradaService {

    @GET(GoStradaApi.BASE_URL)
    fun getUserAccount(): Single<GoStrada>

    @FormUrlEncoded
    @POST("user")
    fun postUserData(
        @Field("username") username: String?,
        @Field("password") password: String?
    ): Observable<GoStrada.msg>
}