package com.github.pacey.launchpal

import android.app.Application
import com.facebook.stetho.Stetho
import com.github.pacey.launchpal.di.ApplicationComponent
import com.github.pacey.launchpal.di.DaggerApplicationComponent
import com.github.pacey.launchpal.di.modules.ApplicationModule
import com.github.pacey.launchpal.di.modules.LaunchModule


class LaunchPalApplication : Application() {
    lateinit var component: ApplicationComponent
    private lateinit var application: LaunchPalApplication

    override fun onCreate() {
        super.onCreate()
        this.application = this

        initialiseDagger()
        initialiseStetho()
    }

    private fun initialiseDagger() {
        this.component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(applicationContext))
            .launchModule(LaunchModule())
            .build()
    }

    private fun initialiseStetho() {
        Stetho.initializeWithDefaults(this)
    }
}
