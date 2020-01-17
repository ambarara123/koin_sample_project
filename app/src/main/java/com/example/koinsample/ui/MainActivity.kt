package com.example.koinsample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.koinsample.R
import com.example.koinsample.utils.PreferenceHelper
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val preferences: PreferenceHelper by inject()
    private val mainFragment: MainFragment by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferences.storeShouldShowFragment(true)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        if (preferences.getShouldShowFragment()){
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,mainFragment,MainFragment::class.simpleName).commit()
        }
    }
}
