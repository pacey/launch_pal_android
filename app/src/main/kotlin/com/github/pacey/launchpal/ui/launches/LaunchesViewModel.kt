package com.github.pacey.launchpal.ui.launches

import androidx.lifecycle.ViewModel
import com.github.pacey.launchpal.data.LaunchPage
import com.github.pacey.launchpal.data.LaunchRepository
import com.github.pacey.launchpal.data.RefreshLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LaunchesViewModel @Inject constructor(launchRepository: LaunchRepository) : ViewModel() {
    val launches: RefreshLiveData<LaunchPage> = launchRepository.getNextLaunches()
}
