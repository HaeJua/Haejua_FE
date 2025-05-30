package com.example.eventra.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.eventra.R
import com.example.eventra.databinding.ActivityMainBinding
import com.example.eventra.ui.calendar.CalendarFragment
import com.example.eventra.ui.favorite.FavoriteFragment
import com.example.eventra.ui.home.HomeFragment
import com.example.eventra.ui.myprofile.MyprofileFragment
import com.example.eventra.ui.search.SearchFragment
import com.example.eventra.viewmodel.MainViewModel
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUi()

        // 앱 초기 실행 시, 홈 화면으로 설정
        if (savedInstanceState == null) {
            binding.naviMenu.selectedItemId = R.id.home
        }
    }

    private fun setUi() {
        binding.naviMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, HomeFragment()).commit()
                    true
                }
                R.id.search -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, SearchFragment()).commit()
                    true
                }
                R.id.favorite -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, FavoriteFragment()).commit()
                    true
                }
                R.id.scedule -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, CalendarFragment()).commit()
                    true
                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, MyprofileFragment()).commit()
                    true
                }
                else -> false
            }
        }
    }
}
