package com.github.pacey.launchpal.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LaunchRepository @Inject constructor(
    private val launchLibraryClient: LaunchLibraryClient
) {

    fun getNextLaunches(): LiveData<LaunchPage> {
        val launchPageData = MutableLiveData<LaunchPage>()
        launchLibraryClient.getNextLaunches(20).enqueue(object : Callback<LaunchPage> {
            override fun onFailure(call: Call<LaunchPage>, t: Throwable) {
                launchPageData.value = null
            }

            override fun onResponse(call: Call<LaunchPage>, response: Response<LaunchPage>) {
                launchPageData.value = response.body()
            }
        })
        return launchPageData
    }

}
