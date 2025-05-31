package com.example.eventra.network

import com.example.eventra.ApplicationClass

class RetrofitUtil {
    companion object {
        val postApi: PostApi = ApplicationClass.retrofit.create(PostApi::class.java)
    }
}