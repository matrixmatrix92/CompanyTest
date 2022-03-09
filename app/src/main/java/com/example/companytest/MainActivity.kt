package com.example.companytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.companytest.database.ProductDatabase
import com.example.roomtest.adapter.ProductsRecyclerAdapter
import kotlinx.coroutines.GlobalScope

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        setupListView()
    }

    fun setupListView() {
        val db = ProductDatabase.getInstance(this)
        val productTable = db.productDemo()

        GlobalScope.let {
            val products = productTable.getPersonList()

            val adapter = ProductsRecyclerAdapter(this, products)

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProducts)
            val layoutManager= LinearLayoutManager(this)

            recyclerView.layoutManager=layoutManager
            recyclerView.itemAnimator= DefaultItemAnimator()
            recyclerView.adapter=adapter
        }


    }
}