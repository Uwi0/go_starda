package com.kakapo.gostrada.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kakapo.gostrada.model.entities.GoStrada
import com.kakapo.gostrada.model.network.GoStradaApiService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

class LoginViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val goStradaApiService = GoStradaApiService()
    val loadUserData = MutableLiveData<Boolean>()
    val userDataResponse = MutableLiveData<GoStrada>()
    val updateUserDataResponse = MutableLiveData<GoStrada>()
    val userDataLoadingError = MutableLiveData<Boolean>()


    fun getUserDataFromAPI() {
        loadUserData.value = true
        compositeDisposable.add(
            goStradaApiService
                .getUserData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<GoStrada>(){
                    override fun onSuccess(value: GoStrada?) {
                        loadUserData.value = true
                        userDataResponse.value = value!!
                        Log.i("user data", value.toString())
                        userDataLoadingError.value = false
                    }

                    override fun onError(e: Throwable?) {
                        loadUserData.value = false
                        userDataLoadingError.value = true
                        Log.e("Error Load From API", "cannot get Data, $e",)
                    }

                })
        )
    }

    fun postUserDataToAPi(username: String, password: String){
        loadUserData.value = true
        compositeDisposable.add(
            goStradaApiService
                .postUserData(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<GoStrada>() {
                    override fun onNext(value: GoStrada?) {
                        loadUserData.value = true
                        updateUserDataResponse.value = value!!
                        Log.i("user data", value.toString())
                        userDataLoadingError.value = false
                    }

                    override fun onError(e: Throwable?) {
                        loadUserData.value = false
                        userDataLoadingError.value = true
                        Log.e("Error Load From API", "cannot get Data, $e",)
                    }

                    override fun onComplete() {

                    }

                })
        )
    }


}