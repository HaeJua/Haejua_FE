package com.example.eventra.ui.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.widget.ImageView

class Base64ImageExtractor {

    /**
     * Base64 문자열에서 이미지 데이터를 Bitmap으로 변환
     */
    fun extractImageFromBase64(base64String: String): Bitmap? {
        return try {
            // 직접 Base64 디코딩 (접두사 제거 불필요)
            val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
     * 추출된 이미지를 ImageView에 표시
     */
    fun displayExtractedImage(base64String: String, imageView: ImageView): Boolean {
        val bitmap = extractImageFromBase64(base64String)
        return if (bitmap != null) {
            imageView.setImageBitmap(bitmap)
            true
        } else {
            false
        }
    }
}
