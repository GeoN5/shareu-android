package com.example.appjam19.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object DateUtil{
    @SuppressLint("SimpleDateFormat")
    fun formatDate(dateData : String):String{
        //JS 고유 날짜 포맷 형식객체를 만듬.
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX")
        //인자를 형변환해서 Date 타입 객체로 받음.
        val date : Date = inputFormat.parse(dateData)
        //바꿀 포맷 형식으로 객체 생성.
        val simpleDataFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        //format 메소드를 통해 바꿔서 리턴.
        return simpleDataFormat.format(date)
    }
}