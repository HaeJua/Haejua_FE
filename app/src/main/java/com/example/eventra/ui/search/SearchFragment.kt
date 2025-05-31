package com.example.eventra.ui.search

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.eventra.databinding.FragmentSearchBinding
import com.example.eventra.model.Post
import com.example.eventra.ui.adapter.SearchPostsAdapter
import com.example.eventra.ui.adapter.SoaPostsAdapter
import com.example.eventra.ui.home.PostDetailActivity
import com.example.eventra.viewmodel.SearchViewModel

class SearchFragment : Fragment() {

    val tempPosts = listOf(
        Post(1, "", "선배들이 쏜다! 샌드위치"),
        Post(2, "", "2025학년도 1학기 중"),
        Post(3, "", "벚꽃은 활짝, 우리는 찰칵!"),
    )
    val tempSearchPosts = listOf(
        Post(1, "", "선배들이 쏜다! 샌드위치"),
        Post(2, "", "2025학년도 1학기 중"),
        Post(3, "", "벚꽃은 활짝, 우리는 찰칵!"),
        Post(4, "", "경북대학교 웹진 280호 발간"),
        Post(5, "", "호반우를 꾸며줘 당첨자 발표"),
        Post(6, "", "2025학년도 하계 및 2학기 현장실습교육과정 학생 모집 안내"),
        Post(7, "", "경북대학교 웹진 280호 발간"),
        Post(8, "", "호반우를 꾸며줘 당첨자 발표"),
        Post(9, "", "2025학년도 하계 및 2학기 현장실습교육과정 학생 모집 안내"),
    )
    lateinit var binding: FragmentSearchBinding
    private val searchViewModel: SearchViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        setUi()
    }

    private fun setUi() {
        // 검색 내용 입력
        binding.apply {
            searchBtn.setOnClickListener {
                if (searchContent.text.toString() == "") {
                    // searchViewModel.getBoards()
                } else {
//                    searchViewModel.getSearchBoards(searchContent.text.toString())
                    searchContent.text.clear()
                    hideKeyboard(this@SearchFragment)
                }
            }
        }
    }

    private fun setAdapter() {
        // 최신 이벤트 리스트
        val soaPostsAdapter = SoaPostsAdapter()
        soaPostsAdapter.detailPostListener =
            object : SoaPostsAdapter.DetailPostListener {
                override fun onClick(post: Post) {
                    startActivity(Intent(context, PostDetailActivity::class.java))
                }
            }
        binding.stateOfArtPosts.adapter = soaPostsAdapter
        soaPostsAdapter.submitList(tempPosts)

        // 검색 게시글 리스트
        val searchPostsAdapter = SearchPostsAdapter()
        searchPostsAdapter.detailPostListener =
            object : SearchPostsAdapter.DetailPostListener {
                override fun onClick(post: Post) {
                    startActivity(Intent(context, PostDetailActivity::class.java))
                }
            }
        binding.searchPosts.run {
            layoutManager = GridLayoutManager(context, 3)
            adapter = searchPostsAdapter
        }
        searchPostsAdapter.submitList(tempSearchPosts)
    }

    private fun hideKeyboard(fragment: Fragment) {
        val ims = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        ims.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}