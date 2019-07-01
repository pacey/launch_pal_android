package com.github.pacey.launchpal

import android.app.Activity
import android.app.Application
import com.facebook.stetho.Stetho
import com.github.pacey.launchpal.di.ApplicationInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class LaunchPalApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        ApplicationInjector.init(this)
        initialiseStetho()
    }

    override fun activityInjector() = dispatchingAndroidInjector

    private fun initialiseStetho() {
        Stetho.initializeWithDefaults(this)
    }
}
