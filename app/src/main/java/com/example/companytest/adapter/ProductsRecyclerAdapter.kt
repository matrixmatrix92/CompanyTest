package com.example.roomtest.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.companytest.R
import com.example.companytest.SecondActivity
import com.example.companytest.database.Product

class ProductsRecyclerAdapter(val context: Context, val products: List<Product>) : RecyclerView.Adapter<ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val v=LayoutInflater.from(context).inflate(R.layout.item_product,parent,false)
        return ProductHolder(v)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val product = products.get(position)

        holder.button.isClickable = product.enabled
        holder.detail.text = product.detail
        holder.name.text= product.name
        holder.id.text = product.id.toString()

        if(product.enabled){

            holder.button.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    val i = Intent(context, SecondActivity::class.java)
                    context.startActivity(i)
                }
            })
        }else{
            holder.button.setBackgroundColor(Color.GRAY)
        }

    }

    override fun getItemCount(): Int {
        return products.size
    }
}