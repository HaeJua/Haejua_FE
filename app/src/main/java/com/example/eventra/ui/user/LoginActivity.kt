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
import com.example.eventra.databinding.ActivityLoginBinding
import com.example.eventra.viewmodel.LogInViewModel
import com.example.eventra.ui.utils.Util.hideKeyboard

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private val logInViewModel: LogInViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        Log.e("싸피",sharedPreferencesUtil.getAccessToken())
//        if (sharedPreferencesUtil.getAccessToken() != "") {
//            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
//            finish()
//        }
        setUi()
    }

    private fun setUi() {
//        logInViewModel.token.observe(this){
//            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
//            finish()
//        }
        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }
            loginBtn.setOnClickListener {
//                logInViewModel.logIn(loginId.text.toString(), loginPassword.text.toString(), this@LoginActivity)
                hideKeyboard(this@LoginActivity)
            }
            loginSignUp.setOnClickListener {
                startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
            }
        }
    }
}