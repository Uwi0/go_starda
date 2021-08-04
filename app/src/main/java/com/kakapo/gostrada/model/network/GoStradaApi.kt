package com.kakapo.gostrada.model.network

import com.kakapo.gostrada.utils.Constants
import retrofit2.http.GET

interface GoStradaApi {

    @GET(Constants.API)
    fun getUserAccount()
}