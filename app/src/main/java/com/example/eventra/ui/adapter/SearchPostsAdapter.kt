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
import com.example.eventra.databinding.ItemPostBinding
import com.example.eventra.model.Post

class SearchPostsAdapter : ListAdapter<Post, SearchPostsAdapter.SearchPostsViewHolder>(
    PostAllDiffCallback()
) {
    private lateinit var binding: ItemPostBinding

    inner class SearchPostsViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.Q)
        fun setBind(post: Post) {
            binding.apply {
                if (post.image != null && post.image != "") {
                    Glide.with(this.root)
                        .load(post.image)
                        .into(postImg)
                } else {
                    postImg.setImageResource(R.drawable.post_ex_1)
                }
                postTitle.text = post.title
                root.setOnClickListener {
                    detailPostListener.onClick(post = post)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchPostsViewHolder {
        binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchPostsViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: SearchPostsViewHolder, position: Int) {
        holder.setBind(getItem(position))
    }

    interface DetailPostListener {
        fun onClick(post: Post)
    }

    lateinit var detailPostListener: DetailPostListener

    class PostAllDiffCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.postId == newItem.postId
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }
}