package com.kakapo.gostrada.model.network

import com.kakapo.gostrada.model.entities.GoStrada
import com.kakapo.gostrada.utils.Constants
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class GoStradaApiService {
    private val api = Retrofit.Builder().baseUrl(GoStradaApi.API)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(GoStradaService::class.java)

    fun getUserData(): Single<GoStrada>{
        return api.getUserAccount()
    }

    fun postUserData(userData: GoStrada): Observable<GoStrada>{
        return api.postUserData(userData)
    }
}