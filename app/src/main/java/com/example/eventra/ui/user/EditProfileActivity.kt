package com.example.eventra.ui.user

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.eventra.ApplicationClass.Companion.sharedPreferencesUtil
import com.example.eventra.databinding.ActivityEditProfileBinding
import com.example.eventra.databinding.ActivityLoginBinding
import com.example.eventra.viewmodel.LogInViewModel
import com.example.eventra.ui.utils.Util.hideKeyboard

class EditProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUi()
    }

    private fun setUi() {
        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }
            editImgBtn.setOnClickListener {

            }
            nicknameEditBtn.setOnClickListener {

            }
            passwordEditBtn.setOnClickListener {

            }
            emailEditBtn.setOnClickListener {

            }
            stateEditBtn.setOnClickListener {

            }
        }
    }
}