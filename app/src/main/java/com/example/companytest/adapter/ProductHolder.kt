package com.example.roomtest.adapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.companytest.R

class ProductHolder(val v:View) : RecyclerView.ViewHolder(v) {

    lateinit var id:TextView
    lateinit var name:TextView
    lateinit var detail:TextView
    lateinit var button: Button

    init {
        id = v.findViewById(R.id.txtProductID)
        name = v.findViewById(R.id.txtProductName)
        detail = v.findViewById(R.id.txtProductDescription)
        button = v.findViewById(R.id.btnNextActivity)
    }
}