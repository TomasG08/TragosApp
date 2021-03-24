package com.cursoandroid.appkotlin

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cursoandroid.appkotlin.data.model.DrinkEntity
import com.cursoandroid.appkotlin.domain.TragosDao

/**
 * Created by Tomás Guzmán on 24/03/2021.
 */
@Database(entities = [DrinkEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tragoDao(): TragosDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "tabla_tragos"
            ).build()
            return INSTANCE!!
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}