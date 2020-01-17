package com.example.koinsample.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.koinsample.R
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.dsl.module

/**
 * A simple [Fragment] subclass.
 */
val mainFragmentModule = module {
    factory { MainFragment() }
}

class MainFragment : Fragment() {
    val mainViewModel: MainViewModel by viewModel()

    private val observer= Observer<String>{
        Log.d("MainFragment","Data: $it")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState)
        mainViewModel.fragmentContent.observe(viewLifecycleOwner,observer)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


}
