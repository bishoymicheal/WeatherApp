package com.example.usecases.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.entities.FavoriteCityId

@Dao
interface FavoritsDao {
    @Query("select * from FavoriteCityId")
    fun queryAll(): List<FavoriteCityId>

    @Insert
    fun addFavoritCityById(id: FavoriteCityId)

    @Delete
    fun removeFavoritCityById(id: FavoriteCityId)
}