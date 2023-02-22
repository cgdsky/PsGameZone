package com.uraniumcode.psgamezone.service

import com.example.example.GameDetail
import com.example.example.PsGames
import com.uraniumcode.psgamezone.utils.Constants
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PsApiService {
    private val api = Retrofit.Builder()
        .baseUrl(Constants().PS_STORE_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(PsApi::class.java)


    fun getNewGamesData(url: String): Single<PsGames> {
        return api.getNewGames(url)
    }
    fun getGameDetailsData(url: String): Single<GameDetail> {
        return api.getGameDetails(url)
    }
}