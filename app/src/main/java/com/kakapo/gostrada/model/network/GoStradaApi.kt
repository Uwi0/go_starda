package com.kakapo.gostrada.model.network

import com.kakapo.gostrada.model.entities.GoStrada
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

object GoStradaApi {
    const val BASE_URL: String = "http://mhs.demes.id/login/do_login/"

//
//    private val strada by lazy {
//        GoStradaService.create()
//    }
//
//    fun getUserData(): Single<NetworkResult>{
//        return strada.getUserAccount().map(this::goStradaResponse)
//    }
//
//    private fun goStradaResponse(response: Response<GoStrada>): NetworkResult{
//        return when(response.code()){
//            in 200..300 ->{
//                val body = response.body()
//                if (body != null){
//                    NetworkResult.Success(body.copy())
//                }else{
//                    NetworkResult.Failure(NetworkError.ServerFailure)
//                }
//            }
//            else -> NetworkResult.Failure(NetworkError.ServerFailure)
//        }
//    }
//
//    sealed class NetworkResult{
//        class Success(val strada: GoStrada): NetworkResult()
//        class Failure(val error: NetworkError): NetworkResult()
//    }
//
//    sealed class NetworkError{
//        object ServerFailure : NetworkError()
//    }
}