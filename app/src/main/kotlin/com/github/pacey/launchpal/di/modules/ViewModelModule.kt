package com.github.pacey.launchpal.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.pacey.launchpal.di.ViewModelFactory
import com.github.pacey.launchpal.di.ViewModelKey
import com.github.pacey.launchpal.ui.launches.LaunchesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LaunchesViewModel::class)
    abstract fun bindLaunchesViewModel(launchesViewModel: LaunchesViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
