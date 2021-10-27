package com.example.headsupapp

import androidx.room.*
@Dao
interface CelebrityDoa {
    @Query("select * from Celebrity order by pk ASC")
    fun getAllData():List<Celebrity>
    @Insert
    fun addCelebrity(celebrity:Celebrity)
    @Update
    fun updateCelebrity(celebrity:Celebrity)
    @Delete
    fun deleteCelebrity(celebrity:Celebrity)

}