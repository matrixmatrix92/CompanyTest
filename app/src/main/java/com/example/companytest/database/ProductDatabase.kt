package com.example.companytest.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Product::class), exportSchema = false, version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDemo(): ProductDemo
    companion object {
        private val BD_NAME = "product_db"

        private var instance: ProductDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): ProductDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(
                    ctx.applicationContext, ProductDatabase::class.java,
                    "product_database"
                ).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()

            return instance!!
        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDatabase(instance!!)
            }
        }

        private fun populateDatabase(db: ProductDatabase) {
            val prdDemo = db.productDemo()
            GlobalScope.launch {
                prdDemo.insertProudct(Product("product1", "Details1",true))
                prdDemo.insertProudct(Product("product2", "Details2",false))
                prdDemo.insertProudct(Product("product3", "Details3",false))
                prdDemo.insertProudct(Product("product4", "Details4",false))
            }



        }

    }
}