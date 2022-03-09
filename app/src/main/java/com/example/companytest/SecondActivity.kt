package com.example.companytest

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import com.example.companytest.database.ProductDatabase
import com.example.companytest.database.ProductDemo
import kotlinx.coroutines.GlobalScope

class SecondActivity : AppCompatActivity() {
    lateinit var chk1:CheckBox
    lateinit var chk2:CheckBox
    lateinit var chk3:CheckBox
    lateinit var btn: Button
    lateinit var txtAttention: TextView
    lateinit var db: ProductDatabase
    lateinit var productTable: ProductDemo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        chk1 = findViewById(R.id.checkBox)
        chk2 = findViewById(R.id.checkBox2)
        chk3 = findViewById(R.id.checkBox3)
        btn = findViewById(R.id.btnConfirm)
        txtAttention = findViewById(R.id.txtAttention)

        db = ProductDatabase.getInstance(this)
        productTable = db.productDemo()

        setupButton()
        check()
    }

    fun setupButton() {
        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                GlobalScope.let {
                    val products = productTable.getPersonList()
                    val product = products.get(1)
                    if(! product.enabled){
                        product.enabled = true
                        productTable.updateProduce(product)

                        finish()
                    }else{
                        product.enabled = false
                        productTable.updateProduce(product)

                        finish()
                    }
                }
            }
        })
    }

    public fun checkAll( v:View) {
        checkAndModifyButton()
    }

    fun check() {
        GlobalScope.let {
            val products = productTable.getPersonList()
            val product = products.get(1)
            if(! product.enabled){
                txtAttention.visibility = View.GONE
                btn.isEnabled = true
                btn.setBackgroundColor(resources.getColor(R.color.purple_500))

                chk1.isChecked = true
                chk2.isChecked = true
                chk3.isChecked = true

                chk1.isEnabled = false
                chk2.isEnabled = false
                chk3.isEnabled = false
            }else{
                txtAttention.visibility = View.VISIBLE
                btn.isEnabled = true
                btn.setBackgroundColor(Color.GRAY)

                chk1.isChecked = false
                chk2.isChecked = false
                chk3.isChecked = false

                chk1.isEnabled = true
                chk2.isEnabled = true
                chk3.isEnabled = true
            }
        }
    }

    private fun checkAndModifyButton() {
       if(chk1.isChecked && chk2.isChecked && chk3.isChecked)
       {
           btn.isEnabled = true
           btn.setBackgroundColor(resources.getColor(R.color.purple_500))
       }else{
           btn.isEnabled = false
           btn.setBackgroundColor(Color.GRAY)
       }
    }
}