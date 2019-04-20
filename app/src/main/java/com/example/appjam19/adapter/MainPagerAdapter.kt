package com.example.appjam19.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.appjam19.fragment.LocationFragment
import com.example.appjam19.fragment.MainFragment

class MainPagerAdapter(fm: FragmentManager?, private val tabCount:Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        return when (position) {
            0 -> {
                MainFragment.newInstance()
            }
            1 ->{
                MainFragment.newInstance()
            }
            2 -> {
                LocationFragment.newInstance()
            }
            else -> null
        }

    }

    override fun getCount(): Int {
        return tabCount
    }

}