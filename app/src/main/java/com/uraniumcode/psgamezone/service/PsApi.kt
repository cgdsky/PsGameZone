package com.uraniumcode.psgamezone.service

import com.example.example.GameDetail
import com.example.example.PsGames
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface PsApi {
    @GET
    fun getNewGames(@Url url: String): Single<PsGames>

    @GET
    fun getGameDetails(@Url url: String): Single<GameDetail>
}