package com.example.setting.ui.viewPager

import android.os.Bundle
import com.example.core.base.BaseFragmentNotRequireViewModel
import com.example.core.utils.setOnSafeClickListener
import com.example.setting.R
import com.example.setting.databinding.FragmentDemoBinding
import kotlin.random.Random

class DemoFragment : BaseFragmentNotRequireViewModel<FragmentDemoBinding>(R.layout.fragment_demo) {

    var number: Int = 0
    var numberRandom: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState?.let {
            number = savedInstanceState.getInt("Ahihi")
            numberRandom = savedInstanceState.getInt("AhihiRandom")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("Ahihi",number)
        outState.putInt("AhihiRandom",numberRandom)
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)

        binding.tv.text = (arguments?.getInt(FRAGMENT_ID) ?: 0).toString()
        binding.number.text = number.toString()
        binding.tvAhihi.text = "ahihi = $numberRandom"

    }

    fun updateText(){
        numberRandom = (0..100).random()
        binding.tvAhihi.text = "ahihi = $numberRandom"
    }

    override fun setOnClick() {
        super.setOnClick()

        binding.btnCong.setOnClickListener {
            number++
            binding.number.text = number.toString()
        }

        binding.btnTru.setOnClickListener {
            number--
            binding.number.text = number.toString()
        }
    }

    companion object {
        private const val FRAGMENT_ID = "FRAGMENT_ID"
        fun getInstance(id: Int): DemoFragment {
            val fragment = DemoFragment()
            val args = Bundle()
            args.putInt(FRAGMENT_ID, id)
            fragment.arguments = args
            return fragment
        }
    }
}