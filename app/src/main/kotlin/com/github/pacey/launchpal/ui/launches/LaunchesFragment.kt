package com.github.pacey.launchpal.ui.launches

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.github.pacey.launchpal.ApplicationExecutors
import com.github.pacey.launchpal.R
import com.github.pacey.launchpal.data.LaunchPage
import com.github.pacey.launchpal.di.Injectable
import kotlinx.android.synthetic.main.launches_fragment.*
import javax.inject.Inject

class LaunchesFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var applicationExecutors: ApplicationExecutors

    private lateinit var launchesViewModel: LaunchesViewModel

    private var listAdapter = LaunchesAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.launches_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        launchesViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(LaunchesViewModel::class.java)
        launches_rv.adapter = listAdapter
        launchesViewModel.launches.observe(this, Observer<LaunchPage> { launchPage ->
            listAdapter.submitList(launchPage.launches)
            swipe_refresh_layout.isRefreshing = false
            progress_circular.visibility = GONE
        })
        swipe_refresh_layout.setOnRefreshListener {
            Log.i(this.javaClass.canonicalName, "Refresh!")
            launchesViewModel.launches.refresh()
        }
    }
}
