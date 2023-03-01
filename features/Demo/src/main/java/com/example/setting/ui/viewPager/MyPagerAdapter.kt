package com.example.setting.ui.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_ITEM = 4

class MyPagerAdapter1(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount() = NUM_ITEM

    override fun getItem(position: Int) = DemoFragment.getInstance(position + 1)

    override fun getPageTitle(position: Int) = "Page " + (position + 1).toString()

}

class MyPagerAdapter(
    private val listFragment: List<Fragment>,
    fm: FragmentManager
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount() = listFragment.size

    override fun getItem(position: Int) = listFragment[position]

    override fun getPageTitle(position: Int) = "Page " + (position + 1).toString()

}

class MyStatePagerAdapter(
    private val listFragment: List<Fragment>,
    fm: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount() = listFragment.size

    override fun createFragment(position: Int) = listFragment[position]
}