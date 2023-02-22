package com.uraniumcode.e_cuzdanplus.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.example.PsGames
import com.uraniumcode.psgamezone.service.PsApiService
import com.uraniumcode.psgamezone.utils.CreatePsGameUrl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class HomeViewModel(application: Application) : BaseViewModel(application) {
    var gamesLiveData = MutableLiveData<PsGames>()
    private val psApiService = PsApiService()
    private val disposable = CompositeDisposable()

    fun getNewGames() {
        disposable.add(
            psApiService.getNewGamesData(CreatePsGameUrl().newGameUrl(0))
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PsGames>() {
                    override fun onSuccess(t: PsGames) {
                        gamesLiveData.value = t
                    }

                    override fun onError(e: Throwable) {
                        Log.e("TAG", "onError: $e")
                        e.printStackTrace()
                    }

                })
        )
    }


}



