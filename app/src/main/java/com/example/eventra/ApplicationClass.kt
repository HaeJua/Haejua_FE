package com.example.eventra

import android.app.Application
import com.example.eventra.common.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass : Application() {

    companion object {
        const val SERVER_URL = "http://15.164.103.242:8081/api/"
        lateinit var retrofit: Retrofit
        lateinit var sharedPreferencesUtil: SharedPreferences
    }

    override fun onCreate() {
        super.onCreate()
        sharedPreferencesUtil = SharedPreferences(applicationContext)

//        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//        val okHttpClient = OkHttpClient.Builder()
//            .readTimeout(5000, TimeUnit.MILLISECONDS)
//            .connectTimeout(5000, TimeUnit.MILLISECONDS)
//            .connectTimeout(30, TimeUnit.SECONDS)
//            .addInterceptor { chain ->
//                val originalRequest = chain.request()
//                val token = sharedPreferencesUtil.getAccessToken() // 저장된 JWT 토큰을 가져옵니다.
//
//                // JWT 토큰을 Authorization 헤더에 첨부합니다.
//                val requestBuilder = originalRequest.newBuilder()
//                    .header("Authorization", "Bearer $token")
//                    .method(originalRequest.method, originalRequest.body)
//
//                val request = requestBuilder.build()
//                chain.proceed(request)
//            }
//            .addInterceptor(loggingInterceptor)
//            .build()

//        retrofit = Retrofit.Builder()
//            .baseUrl(SERVER_URL)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .client(okHttpClient)
//            .build()
    }

    private val gson: Gson = GsonBuilder()
        .setLenient()
        .create()
}