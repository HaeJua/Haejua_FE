package com.example.eventra.ui.home

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.eventra.R
import com.example.eventra.databinding.ActivityPostDetailBinding

class PostDetailActivity : AppCompatActivity() {

    private val images = listOf(
        R.drawable.img01,
        R.drawable.img02,
        R.drawable.img03,
        R.drawable.img04
    )
    private var currentIndex = 0
    private var isFavorite = false
    lateinit var binding: ActivityPostDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUi()
    }

    private fun setUi() {
        // 초기 이미지 세팅
        updateImage()

        binding.apply {
            // 뒤로가기 기능
            backBtn.setOnClickListener {
                finish()
            }

            // 푸시 알림 (Toast 예시)
            notiBtn.setOnClickListener {
                Toast.makeText(this@PostDetailActivity, "푸시 알림이 전송되었습니다", Toast.LENGTH_SHORT).show()
            }

            // 즐겨찾기 토글
            favoriteBtn.setOnClickListener {
                isFavorite = !isFavorite
                if (isFavorite) {
                    favoriteBtn.setImageResource(R.drawable.star_filled)
                } else {
                    favoriteBtn.setImageResource(R.drawable.star_outline)
                }
            }

            // 이미지 넘기기
            leftBtn.setOnClickListener {
                if (currentIndex > 0) {
                    currentIndex--
                    updateImage()
                }
            }

            rightBtn.setOnClickListener {
                if (currentIndex < images.size - 1) {
                    currentIndex++
                    updateImage()
                }
            }
        }
    }

    private fun updateImage() {
        binding.apply {
            postImg.setImageResource(images[currentIndex])
            // 첫 번째 이미지면 왼쪽 화살표 숨김
            leftBtn.visibility = if (currentIndex == 0) View.INVISIBLE else View.VISIBLE

            // 마지막 이미지면 오른쪽 화살표 숨김
            rightBtn.visibility = if (currentIndex == images.size - 1) View.INVISIBLE else View.VISIBLE
        }
    }
}
