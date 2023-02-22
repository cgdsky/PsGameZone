package com.uraniumcode.psgamezone.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.example.GameDetail
import com.uraniumcode.e_cuzdanplus.viewModels.BaseViewModel
import com.uraniumcode.psgamezone.service.PsApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class GameDetailViewModel(application: Application) : BaseViewModel(application) {
    var gameLiveData = MutableLiveData<GameDetail>()
    private val psApiService = PsApiService()
    private val disposable = CompositeDisposable()

    fun getGameDetail(url: String) {
        disposable.add(
            psApiService.getGameDetailsData(url)
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<GameDetail>() {
                    override fun onSuccess(t: GameDetail) {
                        gameLiveData.value = t
                    }

                    override fun onError(e: Throwable) {
                        Log.e("TAG", "onError: $e")
                        e.printStackTrace()
                    }

                })
        )
    }


}