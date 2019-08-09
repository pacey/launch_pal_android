package com.github.pacey.launchpal.data

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LaunchRepository @Inject constructor(private val launchLibraryClient: LaunchLibraryClient) {

    fun getNextLaunches(): RefreshLiveData<LaunchPage> {
        return RefreshLiveData(object : RefreshLiveData.RefreshAction<LaunchPage> {
            override fun loadData(callback: RefreshLiveData.RefreshAction.Callback<LaunchPage>) {
                launchLibraryClient.getNextLaunches(20).enqueue(object : Callback<LaunchPage> {
                    override fun onFailure(call: Call<LaunchPage>, t: Throwable) {
                        Log.e(LaunchRepository::class.qualifiedName, "Failed to load next launches", t)
                    }

                    override fun onResponse(call: Call<LaunchPage>, response: Response<LaunchPage>) {
                        callback.onDataLoaded(response.body() ?: throw Exception("Failed to load a page of launches"))
                    }
                })
            }
        })
    }
}
