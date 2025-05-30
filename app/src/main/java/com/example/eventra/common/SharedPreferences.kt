package com.example.eventra.common

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context) {
    private var preferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val SHARED_PREFERENCES_NAME = "Eventra"
    }
}