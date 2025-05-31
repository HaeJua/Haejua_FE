package com.example.eventra.ui.adapter

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eventra.R
import com.example.eventra.databinding.ItemFavoriteCardBinding
import com.example.eventra.databinding.ItemPostBinding
import com.example.eventra.model.FavoritePost
import com.example.eventra.model.Post

class FavoritePostsAdapter : ListAdapter<FavoritePost, FavoritePostsAdapter.FavoritePostsViewHolder>(
    PostAllDiffCallback()
) {
    private lateinit var binding: ItemFavoriteCardBinding

    inner class FavoritePostsViewHolder(private val binding: ItemFavoriteCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.Q)
        fun setBind(favoritePost: FavoritePost) {
            binding.apply {
                if (favoritePost.image != null && favoritePost.image != "") {
                    Glide.with(this.root)
                        .load(favoritePost.image)
                        .into(postImg)
                } else {
                    postImg.setImageResource(R.drawable.post_ex_1)
                }
                postTitle.text = favoritePost.title
                // 즐겨찾기 토글
                if (favoritePost.isFavorite) {
                    favoriteBtn.setImageResource(R.drawable.star_filled)
                } else {
                    favoriteBtn.setImageResource(R.drawable.star_outline)
                }
                favoriteBtn.setOnClickListener {
                    if (favoritePost.isFavorite) {
                        favoriteBtn.setImageResource(R.drawable.star_outline)
                    } else {
                        favoriteBtn.setImageResource(R.drawable.star_filled)
                    }
                }
                root.setOnClickListener {
                    detailPostListener.onClick(favoritePost = favoritePost)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritePostsViewHolder {
        binding = ItemFavoriteCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoritePostsViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: FavoritePostsViewHolder, position: Int) {
        holder.setBind(getItem(position))
    }

    interface DetailPostListener {
        fun onClick(favoritePost: FavoritePost)
    }

    lateinit var detailPostListener: DetailPostListener

    class PostAllDiffCallback : DiffUtil.ItemCallback<FavoritePost>() {
        override fun areItemsTheSame(oldItem: FavoritePost, newItem: FavoritePost): Boolean {
            return oldItem.postId == newItem.postId
        }

        override fun areContentsTheSame(oldItem: FavoritePost, newItem: FavoritePost): Boolean {
            return oldItem == newItem
        }
    }
}