package com.example.eventra.ui

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.eventra.R

class FavoriteActivity : AppCompatActivity() {

    private val favoriteStates = mutableMapOf<Int, Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.favorite)

        // 카드 이미지 세팅 및 클릭 처리
        val container = findViewById<FrameLayout>(R.id.favoriteLayout)

        for (i in 0 until container.childCount) {
            val view = container.getChildAt(i)
            if (view is FrameLayout) {
                val image = view.findViewById<ImageView>(R.id.image)
                val star = view.findViewById<ImageView>(R.id.favoriteToggle)
                val desc = view.findViewById<TextView>(R.id.description)

                // 샘플 이미지 및 설명 세팅
                image.setImageResource(R.drawable.img01) // 실제 분기 처리 필요
                desc.text = "2025학년도 1학기 중간고사기간 이천원의 저녁밥" // 샘플

                // 즐겨찾기 토글
                star.setOnClickListener {
                    val isFavorite = favoriteStates.getOrDefault(i, true)
                    star.setImageResource(
                        if (isFavorite) R.drawable.star_outline else R.drawable.star_filled
                    )
                    favoriteStates[i] = !isFavorite
                }

                // 상세 화면 전환
                image.setOnClickListener {
                    val intent = Intent(this, detail_hb::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
