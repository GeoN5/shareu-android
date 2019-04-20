package com.example.appjam19.fragment

import android.R
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_location.view.*


class LocationFragment : Fragment() {

    lateinit var fragmentView: View

    private val firstList: ArrayList<String> = ArrayList()
    private val secondList: ArrayList<String> = ArrayList()
    lateinit var firstAdapter: ArrayAdapter<String>
    lateinit var secondAdapter: ArrayAdapter<String>

    companion object {
        @JvmStatic
        fun newInstance() = LocationFragment()

        val TAG: String = LocationFragment::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        fragmentView = inflater.inflate(com.example.appjam19.R.layout.fragment_location, container, false)
        listSet()
        adapterSet()
        insertSpinner()
        setListener()
        return fragmentView
    }

    fun listSet() {
        firstList.add("서울특별시")
        firstList.add("부산광역시")
        firstList.add("인천광역시")
        firstList.add("대구광역시")
        firstList.add("광주광역시")
        firstList.add("대전광역시")
        firstList.add("울산광역시")
        firstList.add("경기도")
        firstList.add("강원도")
        firstList.add("충청북도")
        firstList.add("충청남도")
        firstList.add("경상북도")
        firstList.add("경상남도")
        firstList.add("전라북도")
        firstList.add("전라남도")
        firstList.add("제주특별자치도")

        secondList.add("가평군")
        secondList.add("고양시")
        secondList.add("과천시")
        secondList.add("광명시")
        secondList.add("광주시")
        secondList.add("구리시")
        secondList.add("군포시")
        secondList.add("김포시")
        secondList.add("남양주시")
        secondList.add("동두천시")
        secondList.add("부천시")
        secondList.add("성남시")
        secondList.add("수원시")
        secondList.add("시흥시")
        secondList.add("안산시")
        secondList.add("안양시")
        secondList.add("양주시")
        secondList.add("양평군")
        secondList.add("여주시")
        secondList.add("연천군")
        secondList.add("오산시")
        secondList.add("용인시")
        secondList.add("의왕시")
        secondList.add("의정부시")
        secondList.add("이천시")
        secondList.add("파주시")
        secondList.add("평택시")
        secondList.add("포천시")
        secondList.add("하남시")
        secondList.add("화성시")
    }

    fun adapterSet() {
        firstAdapter = ArrayAdapter(context!!, R.layout.simple_spinner_dropdown_item, firstList)
        secondAdapter = ArrayAdapter(context!!, R.layout.simple_spinner_dropdown_item, secondList)
    }

    fun insertSpinner() {
        fragmentView.spinner1.adapter = firstAdapter
        fragmentView.spinner2.adapter = secondAdapter
    }


    fun setListener() {
        fragmentView.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                if (secondList[i] == "의정부시") {
                    fragmentView.sample2.visibility = View.GONE
                    fragmentView.sample3.visibility = View.GONE
                    fragmentView.sample4.visibility = View.GONE
                    fragmentView.sample5.visibility = View.GONE
                }
            }

        }
    }
}
