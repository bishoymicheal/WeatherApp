package com.example.usecases.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface FavoritsDao{
    @Query("select * from FavoriteCityId")
    fun queryAll() : List<Long>
}