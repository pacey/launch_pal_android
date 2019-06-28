package com.github.pacey.launchpal.di

import android.content.Context
import com.github.pacey.launchpal.MainActivity
import com.github.pacey.launchpal.di.modules.ApplicationModule
import com.github.pacey.launchpal.di.modules.LaunchModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, LaunchModule::class])
interface ApplicationComponent {

    @AppContext
    fun appContext(): Context

    fun inject(mainActivity: MainActivity)
}
