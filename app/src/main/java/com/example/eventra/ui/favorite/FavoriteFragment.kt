package com.example.eventra.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.eventra.databinding.FragmentFavoriteBinding
import com.example.eventra.model.Post
import com.example.eventra.ui.adapter.FavoritePostsAdapter
import com.example.eventra.ui.home.PostDetailActivity

class FavoriteFragment : Fragment() {

    val eventTempPosts = listOf(
        Post(1, "", "선배들이 쏜다! 샌드위치"),
        Post(2, "", "2025학년도 1학기 중"),
        Post(3, "", "벚꽃은 활짝, 우리는 찰칵!"),
    )
    val partnershipTempPosts = listOf<Post>(
//        Post(1, "", "선배들이 쏜다! 샌드위치"),
//        Post(2, "", "2025학년도 1학기 중"),
//        Post(3, "", "벚꽃은 활짝, 우리는 찰칵!"),
    )
    val rentalTempPosts = listOf(
        Post(1, "", "선배들이 쏜다! 샌드위치"),
        Post(2, "", "2025학년도 1학기 중"),
        Post(3, "", "벚꽃은 활짝, 우리는 찰칵!"),
    )
    val mtTempPosts = listOf<Post>(
//        Post(1, "", "선배들이 쏜다! 샌드위치"),
//        Post(2, "", "2025학년도 1학기 중"),
//        Post(3, "", "벚꽃은 활짝, 우리는 찰칵!"),
    )
    val festivalTempPosts = listOf(
        Post(1, "", "선배들이 쏜다! 샌드위치"),
        Post(2, "", "2025학년도 1학기 중"),
        Post(3, "", "벚꽃은 활짝, 우리는 찰칵!"),
    )
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
        // 행사 정보 리스트
        val eventPostsAdapter = FavoritePostsAdapter()
        eventPostsAdapter.detailPostListener =
            object : FavoritePostsAdapter.DetailPostListener {
                override fun onClick(post: Post) {
                    startActivity(Intent(context, PostDetailActivity::class.java))
                }
            }
        binding.eventPosts.adapter = eventPostsAdapter
        if (eventTempPosts.isEmpty()) {
            binding.eventPostEmptyBox.visibility = View.VISIBLE
            binding.eventPosts.visibility = View.INVISIBLE
        } else {
            binding.eventPostEmptyBox.visibility = View.INVISIBLE
            binding.eventPosts.visibility = View.VISIBLE
            eventPostsAdapter.submitList(eventTempPosts)
        }

        // 제휴 정보 리스트
        val partnershipPostsAdapter = FavoritePostsAdapter()
        partnershipPostsAdapter.detailPostListener =
            object : FavoritePostsAdapter.DetailPostListener {
                override fun onClick(post: Post) {
                    startActivity(Intent(context, PostDetailActivity::class.java))
                }
            }
        binding.partnershipPosts.adapter = partnershipPostsAdapter
        if (partnershipTempPosts.isEmpty()) {
            binding.partnershipPostEmptyBox.visibility = View.VISIBLE
            binding.partnershipPosts.visibility = View.INVISIBLE
        } else {
            binding.partnershipPostEmptyBox.visibility = View.INVISIBLE
            binding.partnershipPosts.visibility = View.VISIBLE
            partnershipPostsAdapter.submitList(partnershipTempPosts)
        }

        // 대여 정보 리스트
        val rentalPostsAdapter = FavoritePostsAdapter()
        rentalPostsAdapter.detailPostListener =
            object : FavoritePostsAdapter.DetailPostListener {
                override fun onClick(post: Post) {
                    startActivity(Intent(context, PostDetailActivity::class.java))
                }
            }
        binding.rentalPosts.adapter = rentalPostsAdapter
        if (rentalTempPosts.isEmpty()) {
            binding.rentalPostEmptyBox.visibility = View.VISIBLE
            binding.rentalPosts.visibility = View.INVISIBLE
        } else {
            binding.rentalPostEmptyBox.visibility = View.INVISIBLE
            binding.rentalPosts.visibility = View.VISIBLE
            rentalPostsAdapter.submitList(rentalTempPosts)
        }

        // MT 정보 리스트
        val mtPostsAdapter = FavoritePostsAdapter()
        mtPostsAdapter.detailPostListener =
            object : FavoritePostsAdapter.DetailPostListener {
                override fun onClick(post: Post) {
                    startActivity(Intent(context, PostDetailActivity::class.java))
                }
            }
        binding.mtPosts.adapter = mtPostsAdapter
        if (mtTempPosts.isEmpty()) {
            binding.mtPostEmptyBox.visibility = View.VISIBLE
            binding.mtPosts.visibility = View.INVISIBLE
        } else {
            binding.mtPostEmptyBox.visibility = View.INVISIBLE
            binding.mtPosts.visibility = View.VISIBLE
            mtPostsAdapter.submitList(mtTempPosts)
        }

        // 축제 정보 리스트
        val festivalPostsAdapter = FavoritePostsAdapter()
        festivalPostsAdapter.detailPostListener =
            object : FavoritePostsAdapter.DetailPostListener {
                override fun onClick(post: Post) {
                    startActivity(Intent(context, PostDetailActivity::class.java))
                }
            }
        binding.festivalPosts.adapter = festivalPostsAdapter
        if (festivalTempPosts.isEmpty()) {
            binding.festivalPostEmptyBox.visibility = View.VISIBLE
            binding.festivalPosts.visibility = View.INVISIBLE
        } else {
            binding.festivalPostEmptyBox.visibility = View.INVISIBLE
            binding.festivalPosts.visibility = View.VISIBLE
            festivalPostsAdapter.submitList(festivalTempPosts)
        }
    }

    private fun setUi() {

    }

}
