package com.example.ghtk_intern_week2.ui.screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.ghtk_intern_week2.MainViewModel
import com.example.ghtk_intern_week2.R
import com.example.ghtk_intern_week2.base.BaseFragment
import com.example.ghtk_intern_week2.databinding.Fragment1Binding
import com.example.ghtk_intern_week2.databinding.Fragment2Binding
import com.example.ghtk_intern_week2.model.Point
import com.example.ghtk_intern_week2.utils.convertToDouble
import com.example.ghtk_intern_week2.viewmodel.ViewModelFactory

class Fragment2 : BaseFragment<MainViewModel>() {

    private val binding by lazy {
        Fragment2Binding.inflate(layoutInflater)
    }
    private lateinit var point1: Point
    private lateinit var point2: Point
    private lateinit var point3: Point
    private lateinit var checkPoint: Point
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
    override fun initListener() {
        binding.check.setOnClickListener{
            if(checkAllPoint()){
                viewModel.apply {
                    // Not yet handle the case that these points is not distinct
                    pointInsideTriangle(checkPoint, point1, point2, point3)
                }
            }
            else{
                Toast.makeText(context, "Please input all points", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun observeLiveData() {

        viewModel.exercise2.observe(viewLifecycleOwner) {
            if(it){
                binding.imageView.setImageResource(R.drawable.yes)
            }else{
                binding.imageView.setImageResource(R.drawable.no)
            }
        }
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory())[MainViewModel::class.java]
    }
    private fun checkAllPoint(): Boolean{
        binding.run {
            var px1 = px1.text.convertToDouble()
            var py1 = py1.text.convertToDouble()
            var px2 = px2.text.convertToDouble()
            var py2 = py2.text.convertToDouble()
            var px3 = px3.text.convertToDouble()
            var py3 = py3.text.convertToDouble()
            var qx = px4.text.convertToDouble()
            var qy = py4.text.convertToDouble()
            Log.d("checkAllPoint", "$px1, $py1, $px2, $py2, $px3, $py3, $qx, $qy")
            if (listOf(px1, py1, px2, py2, px3, py3, qx, qy).all { it != null }) {
                this@Fragment2.point1 = Point(px1, py1)
                this@Fragment2.point2 = Point(px2,py2)
                this@Fragment2.point3 = Point(px3,py3)
                this@Fragment2.checkPoint = Point(qx,qy)

            } else {
                return false
            }


        }
        return true
    }

}