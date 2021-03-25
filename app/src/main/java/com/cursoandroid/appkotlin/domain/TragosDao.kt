package com.cursoandroid.appkotlin.domain

import androidx.room.*
import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.data.model.DrinkEntity

/**
 * Created by Tomás Guzmán on 24/03/2021.
 */
@Dao
interface TragosDao {

    @Query("SELECT * FROM DrinkEntity")
    suspend fun getAllFavoriteDrinks():List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(trago:DrinkEntity)

    @Delete
    suspend fun deleteDrink(trago: DrinkEntity)
}