package com.kakapo.gostrada.model.network

import com.kakapo.gostrada.model.entities.GoStrada
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface GoStradaService {

    companion object{
        fun create(): GoStradaService{
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(GoStradaApi.API)
                .client(client)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(GoStradaService::class.java)
        }
    }

    @GET(GoStradaApi.API)
    fun getUserAccount(): Single<GoStrada>

    @POST(GoStradaApi.API)
    @Headers("Content-Type:application/json")
    fun postUserData(userData: GoStrada): Observable<GoStrada>
}