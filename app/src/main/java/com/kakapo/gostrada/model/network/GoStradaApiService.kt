package com.kakapo.gostrada.model.network

import com.kakapo.gostrada.model.entities.GoStrada
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GoStradaApiService {
    private val api = Retrofit.Builder().baseUrl(GoStradaApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(GoStradaService::class.java)

    fun getUserData(): Single<GoStrada>{
        return api.getUserAccount()
    }

    fun postUserData(username: String, password: String): Observable<GoStrada.msg>{
        return api.postUserData(username, password)
    }
}