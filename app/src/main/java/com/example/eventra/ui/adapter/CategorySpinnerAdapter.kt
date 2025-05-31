package com.example.eventra.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.LayoutRes
import com.example.eventra.databinding.ItemCategoryBinding

class CategorySpinnerAdapter(context: Context, @LayoutRes private val resId:Int, private val categoryList : List<String>):
    ArrayAdapter<String>(context,resId,categoryList){
    // 드롭다운하지 않은 상태의 Spinner 항목 뷰
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemCategoryBinding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        itemCategoryBinding.categoryItem.text = categoryList[position]
        return itemCategoryBinding.root
    }

    // 드롭다운된 항목들 리스트의 뷰
    @SuppressLint("ViewHolder")
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemCategoryBinding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        itemCategoryBinding.categoryItem.text = categoryList[position]
        return itemCategoryBinding.root
    }

    override fun getCount() = categoryList.size

}