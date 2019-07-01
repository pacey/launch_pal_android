package com.github.pacey.launchpal.di.modules

import com.github.pacey.launchpal.ui.launches.LaunchesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeLaunchesFragment(): LaunchesFragment
}
