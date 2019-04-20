package com.example.appjam19.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.example.appjam19.R
import com.example.appjam19.util.loadImage
import kotlinx.android.synthetic.main.activity_register_tallent.*
import pub.devrel.easypermissions.EasyPermissions


class RegisterTallentActivity : AppCompatActivity(),EasyPermissions.PermissionCallbacks {

    private val cateList: ArrayList<String> = ArrayList()
    private val firstList: ArrayList<String> = ArrayList()
    private val secondList: ArrayList<String> = ArrayList()
    lateinit var cateAdapter: ArrayAdapter<String>
    lateinit var firstAdapter: ArrayAdapter<String>
    lateinit var secondAdapter: ArrayAdapter<String>

    private val REQUEST_GALLERY_CODE =200
    private val READ_REQUEST_CODE = 300
    private var uri : Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_tallent)

        listSet()
        adapterSet()
        insertSpinner()

        talentButton.setOnClickListener {
            startActivity(Intent(this, CompleteActivity::class.java))
        }

        pictureImage.setOnClickListener {
            if(EasyPermissions.hasPermissions(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
                image()
            } else {
                EasyPermissions.requestPermissions(this, "이미지를 가져오기 위해서 권한이 필요합니다",
                    READ_REQUEST_CODE, android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        Snackbar.make(window.decorView.rootView,"권한이 없습니다",Snackbar.LENGTH_SHORT).show()
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        image()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults, this)
    }


    private fun image(){
        val openGalleryIntent = Intent(Intent.ACTION_PICK)
        openGalleryIntent.type="image/*"
        startActivityForResult(openGalleryIntent,REQUEST_GALLERY_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_GALLERY_CODE && resultCode == Activity.RESULT_OK){
            uri = data!!.data//사진 data를 가져옴.
            if(EasyPermissions.hasPermissions(applicationContext,android.Manifest.permission.READ_EXTERNAL_STORAGE)){
                pictureImage.loadImage(uri!!,applicationContext)//glide
            }else{
                EasyPermissions.requestPermissions(this,"파일을 읽기 위해서는 권한이 필요합니다!",READ_REQUEST_CODE, android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
    }

        fun listSet() {
            cateList.add("예술")
            cateList.add("운동")
            cateList.add("음악")
            cateList.add("공예")
            cateList.add("기타")

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

            secondList.add("종로구")
            secondList.add("중구")
            secondList.add("용산구")
            secondList.add("성동구")
            secondList.add("광진구")
            secondList.add("동대문구")
            secondList.add("중랑구")
            secondList.add("성북구")
            secondList.add("강북구")
            secondList.add("도봉구")
            secondList.add("노원구")
            secondList.add("은평구")
            secondList.add("서대문구")
            secondList.add("마포구")
            secondList.add("양천구")
            secondList.add("강서구")
            secondList.add("구로구")
            secondList.add("금천구")
            secondList.add("영등포구")
            secondList.add("동작구")
            secondList.add("관악구")
            secondList.add("서초구")
            secondList.add("강남구")
            secondList.add("송파구")
            secondList.add("강동구")
        }

        fun adapterSet() {
            cateAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, cateList)
            firstAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, firstList)
            secondAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, secondList)
        }

        fun insertSpinner() {
            catespinner.adapter = cateAdapter
            spinner1.adapter = firstAdapter
            spinner2.adapter = secondAdapter
        }

    }

