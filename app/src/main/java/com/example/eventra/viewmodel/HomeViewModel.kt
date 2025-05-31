package com.example.eventra.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventra.model.HomePostsResponse
import com.example.eventra.network.RetrofitUtil
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel : ViewModel() {
    private val _posts = MutableLiveData<HomePostsResponse>()
    val posts: LiveData<HomePostsResponse>
        get() = _posts

    fun getHomePosts() {
        viewModelScope.launch {
            try {
                val data = RetrofitUtil.homeApi.getHomePosts()
                _posts.value = data
            } catch (e: Exception) {
                Log.d("ServerError",e.toString())
            }
        }
    }
}