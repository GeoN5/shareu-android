package com.example.appjam19.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.example.appjam19.R
import com.example.appjam19.adapter.MainPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTabLayout()
        setViewpager()

        profile.setOnClickListener {
            startActivity(Intent(this,ProfileActivity::class.java))
        }

    }

    private fun setTabLayout(){
        tab.addTab(tab.newTab().setText("추천순"))
        tab.addTab(tab.newTab().setText("하트순"))
        tab.addTab(tab.newTab().setText("내주변"))
    }

    private fun setViewpager(){
        val pagerAdapter = MainPagerAdapter(supportFragmentManager, tab.tabCount)
        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab))

        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

        })

    }

}
