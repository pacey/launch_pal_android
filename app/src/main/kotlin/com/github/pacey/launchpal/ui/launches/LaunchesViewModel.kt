package com.github.pacey.launchpal.ui.launches

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.github.pacey.launchpal.data.LaunchPage
import com.github.pacey.launchpal.data.LaunchRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LaunchesViewModel @Inject constructor(launchRepository: LaunchRepository) : ViewModel() {
    val launches: LiveData<LaunchPage> = launchRepository.getNextLaunches()
}
