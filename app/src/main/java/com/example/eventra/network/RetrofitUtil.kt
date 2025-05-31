package com.example.eventra.network

import com.example.eventra.ApplicationClass

class RetrofitUtil {
    companion object {
        val homeApi: HomeApi = ApplicationClass.retrofit.create(HomeApi::class.java)
        val postApi: PostApi = ApplicationClass.retrofit.create(PostApi::class.java)
    }
}