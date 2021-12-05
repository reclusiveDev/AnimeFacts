package com.reclusivedev.animefacts.interfaces

import com.reclusivedev.animefacts.models.Anime
import com.reclusivedev.animefacts.models.AnimeList
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/v1")
    fun getAnimeList():Call<AnimeList>
}