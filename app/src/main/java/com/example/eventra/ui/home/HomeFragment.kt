package com.example.eventra.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.eventra.R
import com.example.eventra.databinding.FragmentHomeBinding
import com.example.eventra.model.Post
import com.example.eventra.ui.adapter.CategorySpinnerAdapter
import com.example.eventra.ui.adapter.ClubPostsAdapter
import com.example.eventra.ui.adapter.DepartPostsAdapter
import com.example.eventra.ui.adapter.UnivPostsAdapter
import com.example.eventra.ui.setting.SettingActivity
import com.example.eventra.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    val univTempPosts = listOf(
        Post(1, "", "선배들이 쏜다! 샌드위치"),
        Post(2, "", "2025학년도 1학기 중"),
        Post(3, "", "벚꽃은 활짝, 우리는 찰칵!"),
    )
    val departTempPosts = listOf<Post>()
    val clubTempPosts = listOf(
        Post(1, "", "선배들이 쏜다! 샌드위치"),
        Post(2, "", "2025학년도 1학기 중"),
        Post(3, "", "벚꽃은 활짝, 우리는 찰칵!"),
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
    lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        setUi()
    }

    private fun setUi() {
        binding.apply {
            settingBtn.setOnClickListener {
                startActivity(
                    Intent(
                        context,
                        SettingActivity::class.java
                    )
                )
            }
            // 대학 정보 더보기 박스 클릭 이벤트
            univMoreBox.setOnClickListener {
                startActivity(
                    Intent(
                        context,
                        UnivMorePostActivity::class.java
                    )
                )
            }
            univMoreBtn.setOnClickListener {
                startActivity(
                    Intent(
                        context,
                        UnivMorePostActivity::class.java
                    )
                )
            }
            // 단과대 정보 더보기 박스 클릭 이벤트
            departMoreBox.setOnClickListener {
                startActivity(
                    Intent(
                        context,
                        DepartMorePostActivity::class.java
                    )
                )
            }
            departMoreBtn.setOnClickListener {
                startActivity(
                    Intent(
                        context,
                        DepartMorePostActivity::class.java
                    )
                )
            }
            // 총동아리 정보 더보기 박스 클릭 이벤트
            clubMoreBox.setOnClickListener {
                startActivity(
                    Intent(
                        context,
                        ClubMorePostActivity::class.java
                    )
                )
            }
            clubMoreBtn.setOnClickListener {
                startActivity(
                    Intent(
                        context,
                        ClubMorePostActivity::class.java
                    )
                )
            }
        }
    }

    private fun setAdapter() {
        // 대학 정보 리스트
        val univPostsAdapter = UnivPostsAdapter()
        univPostsAdapter.detailPostListener =
            object : UnivPostsAdapter.DetailPostListener {
                override fun onClick(post: Post) {
                    TODO("Not yet implemented")
                }
            }
        binding.univPosts.adapter = univPostsAdapter
        if (univTempPosts.isEmpty()) {
            binding.univPostEmptyBox.visibility = View.VISIBLE
            binding.univPosts.visibility = View.INVISIBLE
        } else {
            binding.univPostEmptyBox.visibility = View.INVISIBLE
            binding.univPosts.visibility = View.VISIBLE
            univPostsAdapter.submitList(univTempPosts)
        }

        // 포스트 카테고리 리스트
        binding.univPostCategory.run {
            adapter = CategorySpinnerAdapter(requireContext(), R.layout.item_category, categoryList)
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

        // 단과대 정보 리스트
        val departPostsAdapter = DepartPostsAdapter()
        departPostsAdapter.detailPostListener =
            object : DepartPostsAdapter.DetailPostListener {
                override fun onClick(post: Post) {
                    TODO("Not yet implemented")
                }
            }
        binding.departPosts.adapter = departPostsAdapter
        if (departTempPosts.isEmpty()) {
            binding.departPostEmptyBox.visibility = View.VISIBLE
            binding.departPosts.visibility = View.INVISIBLE
        } else {
            binding.departPostEmptyBox.visibility = View.INVISIBLE
            binding.departPosts.visibility = View.VISIBLE
            departPostsAdapter.submitList(departTempPosts)
        }


        // 단과대 카테고리 리스트
        binding.ldepartCategory.run {
            adapter = CategorySpinnerAdapter(requireContext(), R.layout.item_category, ldepartList)
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
            adapter = CategorySpinnerAdapter(requireContext(), R.layout.item_category, sdepartList)
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
        binding.departPostCategory.run {
            adapter = CategorySpinnerAdapter(requireContext(), R.layout.item_category, categoryList)
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

        // 총동아리 정보 리스트
        val clubPostsAdapter = ClubPostsAdapter()
        clubPostsAdapter.detailPostListener =
            object : ClubPostsAdapter.DetailPostListener {
                override fun onClick(post: Post) {
                    TODO("Not yet implemented")
                }
            }
        binding.clubPosts.adapter = clubPostsAdapter
        if (clubTempPosts.isEmpty()) {
            binding.clubPostEmptyBox.visibility = View.VISIBLE
            binding.clubPosts.visibility = View.INVISIBLE
        } else {
            binding.clubPostEmptyBox.visibility = View.INVISIBLE
            binding.clubPosts.visibility = View.VISIBLE
            clubPostsAdapter.submitList(clubTempPosts)
        }

        // 포스트 카테고리 리스트
        binding.clubPostCategory.run {
            adapter = CategorySpinnerAdapter(requireContext(), R.layout.item_category, categoryList)
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