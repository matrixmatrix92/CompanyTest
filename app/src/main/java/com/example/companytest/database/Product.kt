package com.example.companytest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Product")
class Product{

    @PrimaryKey(autoGenerate = true)
    public var id:Int = 0

    @ColumnInfo(name = "name")
    public  var name:String

    @ColumnInfo(name = "detail")
    public  var detail: String

    @ColumnInfo(name="enabled")
    public var enabled: Boolean = false



    constructor(name: String, detail: String, enabled: Boolean) {
        this.name = name
        this.detail = detail
        this.enabled = enabled
    }

}