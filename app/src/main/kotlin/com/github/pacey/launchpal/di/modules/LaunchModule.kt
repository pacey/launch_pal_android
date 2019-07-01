package com.github.pacey.launchpal.di.modules

import com.github.pacey.launchpal.data.LaunchLibraryClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class LaunchModule {

    @Provides
    @Singleton
    internal fun providesLaunchLibraryClient(retrofit: Retrofit): LaunchLibraryClient {
        return retrofit.create(LaunchLibraryClient::class.java)
    }
}
