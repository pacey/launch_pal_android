package com.github.pacey.launchpal.di.modules

import com.github.pacey.launchpal.data.LaunchLibraryClient
import com.github.pacey.launchpal.data.LaunchRepository
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

    @Provides
    @Singleton
    internal fun providesLaunchRepository(launchLibraryClient: LaunchLibraryClient): LaunchRepository {
        return LaunchRepository(launchLibraryClient);
    }
}
