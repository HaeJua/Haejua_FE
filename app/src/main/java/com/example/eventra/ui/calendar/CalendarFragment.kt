package com.example.eventra.ui.calendar

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.eventra.databinding.FragmentCalendarBinding
import com.example.eventra.databinding.FragmentFavoriteBinding
import com.example.eventra.model.Post
import com.example.eventra.ui.adapter.FavoritePostsAdapter
import com.example.eventra.ui.home.PostDetailActivity

class CalendarFragment : Fragment() {

    lateinit var binding: FragmentCalendarBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalendarBinding.inflate(inflater, container, false)
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

    }

}
