package com.example.appjam19.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appjam19.R
import com.example.appjam19.activity.ClassDetailActivity
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {

    lateinit var fragmentView : View

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fragmentView =  inflater.inflate(R.layout.fragment_main, container, false)
        setListener()
        return fragmentView
    }

    private fun setListener(){
        fragmentView.main1.setOnClickListener {
            activity?.startActivity(Intent(context,ClassDetailActivity::class.java))
        }
    }

}
