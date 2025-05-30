package com.example.eventra.ui.home

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.eventra.R
import com.example.eventra.databinding.ActivityDepartMorePostBinding
import com.example.eventra.databinding.ActivityUnivMorePostBinding
import com.example.eventra.model.Post
import com.example.eventra.ui.adapter.CategorySpinnerAdapter
import com.example.eventra.ui.adapter.DepartPostsAdapter
import com.example.eventra.viewmodel.DepartMorePostViewModel
import com.example.eventra.viewmodel.UnivMorePostViewModel

class DepartMorePostActivity : AppCompatActivity() {

    val tempPosts = listOf<Post>(
//        Post(1, "", "선배들이 쏜다! 샌드위치"),
//        Post(2, "", "2025학년도 1학기 중"),
//        Post(3, "", "벚꽃은 활짝, 우리는 찰칵!"),
//        Post(4, "", "경북대학교 웹진 280호 발간"),
//        Post(5, "", "호반우를 꾸며줘 당첨자 발표"),
//        Post(6, "", "2025학년도 하계 및 2학기 현장실습교육과정 학생 모집 안내"),
    )
    val categoryList = listOf(
        "행사",
        "제휴",
        "대여",
        "MT",
        "축제",
        "기타",
    )
    val ldepartList = listOf(
        "IT대학",
        "자연과학대학",
        "경상대학",
        "기타",
    )
    val sdepartList = listOf(
        "전자공학부",
        "컴퓨터공학부",
        "자율학부",
        "기타",
    )
    lateinit var binding: ActivityDepartMorePostBinding
    val departMorePostViewModel: DepartMorePostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDepartMorePostBinding.inflate(layoutInflater)
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
        // 단과대 정보 리스트
        val departPostsAdapter = DepartPostsAdapter()
        departPostsAdapter.detailPostListener =
            object : DepartPostsAdapter.DetailPostListener {
                override fun onClick(post: Post) {
                    TODO("Not yet implemented")
                }
            }
        binding.departPosts.adapter = departPostsAdapter
        if (tempPosts.isEmpty()) {
            binding.departPostEmptyBox.visibility = View.VISIBLE
            binding.departPosts.visibility = View.INVISIBLE
        } else {
            binding.departPostEmptyBox.visibility = View.INVISIBLE
            binding.departPosts.visibility = View.VISIBLE
            departPostsAdapter.submitList(tempPosts)
        }

        // 단과대 카테고리 리스트
        binding.ldepartCategory.run {
            adapter = CategorySpinnerAdapter(context, R.layout.item_category, ldepartList)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val value = getItemAtPosition(p2).toString()
                    Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    // 선택되지 않은 경우
                }
            }
        }
        // 과 카테고리 리스트
        binding.sdepartCategory.run {
            adapter = CategorySpinnerAdapter(context, R.layout.item_category, sdepartList)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val value = getItemAtPosition(p2).toString()
                    Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    // 선택되지 않은 경우
                }
            }
        }
        // 포스트 카테고리 리스트
        binding.postCategory.run {
            adapter = CategorySpinnerAdapter(context, R.layout.item_category, categoryList)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val value = getItemAtPosition(p2).toString()
                    Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    // 선택되지 않은 경우
                }
            }
        }
    }
}