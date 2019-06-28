package com.github.pacey.launchpal.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LaunchLibraryClient {
    @GET("launch?mode=verbose")
    fun getNextLaunches(@Query("next") next: Int = 20): Call<LaunchPage>
}
