package com.example.appjam19.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter

class ABCPagerAdapter(fm: FragmentManager?, private val tabCount:Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        return when (position) {
            0 -> {
                TimeTableH1Fragment.newInstance()
            }
            1 -> {
                TimeTableH2Fragment.newInstance()
            }
            else -> null
        }

    }

    override fun getCount(): Int {
        return tabCount
    }

}