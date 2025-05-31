package com.example.eventra.ui.setting

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.eventra.R
import com.example.eventra.databinding.ActivityClubMorePostBinding
import com.example.eventra.databinding.ActivityDepartMorePostBinding
import com.example.eventra.databinding.ActivitySettingBinding
import com.example.eventra.databinding.ActivityUnivMorePostBinding
import com.example.eventra.model.Post
import com.example.eventra.ui.adapter.CategorySpinnerAdapter
import com.example.eventra.ui.adapter.ClubPostsAdapter
import com.example.eventra.ui.adapter.DepartPostsAdapter
import com.example.eventra.viewmodel.ClubMorePostViewModel
import com.example.eventra.viewmodel.DepartMorePostViewModel
import com.example.eventra.viewmodel.UnivMorePostViewModel

class SettingActivity : AppCompatActivity() {

    lateinit var binding: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUi()
    }

    private fun setUi() {
        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }
            profileEditBtn.setOnClickListener {
                Toast.makeText(this@SettingActivity, "프로필 편집 버튼", Toast.LENGTH_SHORT).show()
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