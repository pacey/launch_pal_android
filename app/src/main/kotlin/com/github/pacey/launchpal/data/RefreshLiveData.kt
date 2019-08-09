package com.github.pacey.launchpal.data

import androidx.lifecycle.MutableLiveData

class RefreshLiveData<T> constructor(private val refreshAction: RefreshAction<T>) : MutableLiveData<T>() {

    private val callback = object : RefreshAction.Callback<T> {
        override fun onDataLoaded(t: T) {
            postValue(t)
        }
    }

    init {
        refresh()
    }

    interface RefreshAction<T> {
        interface Callback<T> {
            fun onDataLoaded(t: T)
        }

        fun loadData(callback: Callback<T>)
    }

    fun refresh() {
        refreshAction.loadData(callback)
    }

}
