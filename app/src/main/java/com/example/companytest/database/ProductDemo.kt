package com.example.companytest.database

import androidx.room.*

@Dao
interface ProductDemo {

    @Query("Select * from product")
    fun getPersonList(): List<Product>

    @Insert
    fun insertProudct(product: Product)

    @Update
    fun updateProduce(product: Product)

    @Delete
    fun deleteProduct(product: Product)
}