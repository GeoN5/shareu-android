package com.example.appjam19.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appjam19.R

class BlankFragment : Fragment() {

    lateinit var fragmentView : View

    companion object {

        @JvmStatic
        fun newInstance() = UserFragment()
        val TAG : String = UserFragment::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fragmentView =  inflater.inflate(R.layout.fragment_blank, container, false)

        return fragmentView
    }


}
