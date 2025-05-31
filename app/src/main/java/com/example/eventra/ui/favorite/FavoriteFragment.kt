package com.example.eventra.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.eventra.R
import com.example.eventra.databinding.FragmentFavoriteBinding
import com.example.eventra.ui.PostDetailActivity

class FavoriteFragment : Fragment() {

    // 즐겨찾기 상태 저장
    private val favoriteStates = mutableMapOf<Int, Boolean>()
    lateinit var binding: FragmentFavoriteBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        setUi()
    }

    private fun setAdapter() {

    }

    private fun setUi() {
        // 각 이미지 및 즐겨찾기 버튼 처리
        setupCard(R.id.image1, R.id.star1, 1)
        setupCard(R.id.image2, R.id.star2, 2)
        setupCard(R.id.image3, R.id.star3, 3)
        setupCard(R.id.image4, R.id.star4, 4)
        setupCard(R.id.image5, R.id.star5, 5)
        setupCard(R.id.image6, R.id.star6, 6)
    }

    private fun setupCard(imageId: Int, starId: Int, index: Int) {
//        val imageView = findViewById<ImageView>(imageId)
//        val starView = findViewById<ImageView>(starId)
//
//        // 초기 상태 설정 (기본 true: 즐겨찾기 되어 있음)
//        favoriteStates[index] = true
//
//        // 이미지 클릭 시 상세 화면으로 이동
//        imageView.setOnClickListener {
//            val intent = Intent(this, PostDetailActivity::class.java)
//            startActivity(intent)
//        }
//
//        // 즐겨찾기 아이콘 클릭 시 토글
//        starView.setOnClickListener {
//            val isFavorite = favoriteStates[index] ?: true
//            if (isFavorite) {
//                starView.setImageResource(R.drawable.star_outline)
//            } else {
//                starView.setImageResource(R.drawable.star_filled)
//            }
//            favoriteStates[index] = !isFavorite
//        }
    }

}
