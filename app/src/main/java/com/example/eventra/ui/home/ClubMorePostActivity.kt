package com.example.eventra.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.eventra.R
import com.example.eventra.databinding.ActivityClubMorePostBinding
import com.example.eventra.databinding.ActivityDepartMorePostBinding
import com.example.eventra.databinding.ActivityUnivMorePostBinding
import com.example.eventra.model.Post
import com.example.eventra.ui.adapter.CategorySpinnerAdapter
import com.example.eventra.ui.adapter.ClubPostsAdapter
import com.example.eventra.ui.adapter.DepartPostsAdapter
import com.example.eventra.viewmodel.ClubMorePostViewModel

class ClubMorePostActivity : AppCompatActivity() {

    val tempPosts = listOf(
        Post(1, "", "선배들이 쏜다! 샌드위치"),
        Post(2, "", "2025학년도 1학기 중"),
        Post(3, "", "벚꽃은 활짝, 우리는 찰칵!"),
        Post(4, "", "경북대학교 웹진 280호 발간"),
        Post(5, "", "호반우를 꾸며줘 당첨자 발표"),
        Post(6, "", "2025학년도 하계 및 2학기 현장실습교육과정 학생 모집 안내"),
    )
    val categoryList = listOf(
        "행사",
        "제휴",
        "대여",
        "MT",
        "축제",
        "기타",
    )
    lateinit var binding: ActivityClubMorePostBinding
    val clubMorePostViewModel: ClubMorePostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClubMorePostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUi()
        setAdapter()
    }

    private fun setUi() {
        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }
        }
    }

    private fun setAdapter() {
        // 총동아리 정보 리스트
        val clubPostsAdapter = ClubPostsAdapter()
        clubPostsAdapter.detailPostListener =
            object : ClubPostsAdapter.DetailPostListener {
                override fun onClick(post: Post) {
                    startActivity(Intent(this@ClubMorePostActivity, PostDetailActivity::class.java))
                }
            }
        binding.clubPosts.adapter = clubPostsAdapter
        if (tempPosts.isEmpty()) {
            binding.clubPostEmptyBox.visibility = View.VISIBLE
            binding.clubPosts.visibility = View.INVISIBLE
        } else {
            binding.clubPostEmptyBox.visibility = View.INVISIBLE
            binding.clubPosts.visibility = View.VISIBLE
            clubPostsAdapter.submitList(tempPosts)
        }

        // 포스트 카테고리 리스트
        binding.postCategory.run {
            adapter = CategorySpinnerAdapter(context, R.layout.item_category, categoryList)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val value = getItemAtPosition(p2).toString()
//                    Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    // 선택되지 않은 경우
                }
            }
        }
    }
}