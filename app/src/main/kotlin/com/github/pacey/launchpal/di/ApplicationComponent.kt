package com.github.pacey.launchpal.di

import android.app.Application
import com.github.pacey.launchpal.LaunchPalApplication
import com.github.pacey.launchpal.di.modules.ApplicationModule
import com.github.pacey.launchpal.di.modules.LaunchModule
import com.github.pacey.launchpal.di.modules.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        MainActivityModule::class,
        LaunchModule::class]
)
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(launchPalApplication: LaunchPalApplication)
}
