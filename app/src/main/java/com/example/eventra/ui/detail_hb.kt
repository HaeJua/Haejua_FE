package com.example.eventra.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.eventra.R

class detail_hb : AppCompatActivity() {

    private lateinit var backArrow: ImageView
    private lateinit var titleText: TextView
    private lateinit var storeName: TextView
    private lateinit var calendarIcon: ImageView
    private lateinit var notificationsIcon: ImageView
    private lateinit var favoriteIcon: ImageView
    private lateinit var imageSlider: ImageView
    private lateinit var leftArrow: ImageView
    private lateinit var rightArrow: ImageView

    private val images = listOf(
        R.drawable.img01,
        R.drawable.img02,
        R.drawable.img03,
        R.drawable.img04
    )
    private var currentIndex = 0
    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail)

        // View 연결
        backArrow = findViewById(R.id.backArrow)
        titleText = findViewById(R.id.titleText)
        storeName = findViewById(R.id.storeName)
        calendarIcon = findViewById(R.id.calendarIcon)
        notificationsIcon = findViewById(R.id.notificationsIcon)
        favoriteIcon = findViewById(R.id.favoriteIcon)
        imageSlider = findViewById(R.id.imageSlider)
        leftArrow = findViewById(R.id.leftArrow)
        rightArrow = findViewById(R.id.rightArrow)

        // 뒤로가기 기능
        backArrow.setOnClickListener {
            finish()
        }

        // 푸시 알림 (Toast 예시)
        notificationsIcon.setOnClickListener {
            Toast.makeText(this, "푸시 알림이 전송되었습니다", Toast.LENGTH_SHORT).show()
        }

        // 즐겨찾기 토글
        favoriteIcon.setOnClickListener {
            isFavorite = !isFavorite
            if (isFavorite) {
                favoriteIcon.setImageResource(R.drawable.star_filled)
            } else {
                favoriteIcon.setImageResource(R.drawable.star_outline)
            }
        }

        // 이미지 넘기기
        leftArrow.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateImage()
            }
        }

        rightArrow.setOnClickListener {
            if (currentIndex < images.size - 1) {
                currentIndex++
                updateImage()
            }
        }


        // 초기 이미지 세팅
        updateImage()
    }

    private fun updateImage() {
        imageSlider.setImageResource(images[currentIndex])

        // 첫 번째 이미지면 왼쪽 화살표 숨김
        leftArrow.visibility = if (currentIndex == 0) View.INVISIBLE else View.VISIBLE

        // 마지막 이미지면 오른쪽 화살표 숨김
        rightArrow.visibility = if (currentIndex == images.size - 1) View.INVISIBLE else View.VISIBLE
    }
}
