package com.example.eventra.ui.myprofile

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
import com.example.eventra.databinding.FragmentMyprofileBinding
import com.example.eventra.model.Post
import com.example.eventra.ui.adapter.CategorySpinnerAdapter
import com.example.eventra.ui.adapter.ClubPostsAdapter
import com.example.eventra.ui.adapter.DepartPostsAdapter
import com.example.eventra.ui.adapter.UnivPostsAdapter
import com.example.eventra.ui.setting.SettingActivity
import com.example.eventra.viewmodel.HomeViewModel

class MyprofileFragment : Fragment() {

    lateinit var binding: FragmentMyprofileBinding
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMyprofileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUi()
    }

    private fun setUi() {
        binding.apply {
            profileEditBtn.setOnClickListener {
                Toast.makeText(context, "프로필 편집 버튼", Toast.LENGTH_SHORT).show()
            }
            noticeBox.setOnClickListener {

            }
            favoriteBox.setOnClickListener {

            }
            sceduleBox.setOnClickListener {

            }
            reportBox.setOnClickListener {

            }
            license.setOnClickListener {

            }
            logoutBox.setOnClickListener {

            }
        }
    }
}