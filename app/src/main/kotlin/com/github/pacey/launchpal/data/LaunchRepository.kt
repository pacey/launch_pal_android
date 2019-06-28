package com.github.pacey.launchpal.data

class LaunchRepository constructor(private val launchLibraryClient: LaunchLibraryClient) {

    fun getNextLaunches(): LaunchPage {
        val response = launchLibraryClient.getNextLaunches(20).execute()
        if (response.isSuccessful) {
            return response.body() ?: throw Exception("Body was empty")
        } else {
            throw Exception(response.errorBody()?.toString())
        }
    }

}
