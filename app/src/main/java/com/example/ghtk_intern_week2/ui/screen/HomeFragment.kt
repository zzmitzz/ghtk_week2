package com.example.ghtk_intern_week2.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ghtk_intern_week2.MainViewModel
import com.example.ghtk_intern_week2.R
import com.example.ghtk_intern_week2.base.BaseFragment
import com.example.ghtk_intern_week2.databinding.Fragment1Binding
import com.example.ghtk_intern_week2.databinding.FragmentHomeBinding
import com.example.ghtk_intern_week2.viewmodel.ViewModelFactory

class HomeFragment : BaseFragment<MainViewModel>() {

    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initListener()
        return binding.root
    }
    override fun initListener() {
        binding.run {
            btn1.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_page1Fragment)
            }
            btn2.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_page2Fragment)
            }
        }
    }

    override fun observeLiveData() {
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory())[MainViewModel::class.java]
    }
}