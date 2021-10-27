package com.example.headsupapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Celebrity")
data class Celebrity(
    @ColumnInfo(name="name") val name:String,
    @ColumnInfo(name="taboo1") val taboo1:String,
    @ColumnInfo(name="taboo2") val taboo2:String,
    @ColumnInfo(name="taboo3")val taboo3:String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="pk") val pk:Int=0
)