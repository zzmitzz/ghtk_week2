package com.example.ghtk_intern_week2.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VM: ViewModel>: Fragment() {
    lateinit var viewModel : VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initListener()
        observeLiveData()
    }
    abstract fun initListener() : Unit
    abstract fun observeLiveData()

    abstract fun initViewModel()
}