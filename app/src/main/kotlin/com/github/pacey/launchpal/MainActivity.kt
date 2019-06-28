package com.github.pacey.launchpal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.pacey.launchpal.di.ApplicationComponent

class MainActivity : AppCompatActivity() {

    private val applicationComponent: ApplicationComponent
        get() = (application as LaunchPalApplication).component

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        applicationComponent.inject(this)
    }
}
