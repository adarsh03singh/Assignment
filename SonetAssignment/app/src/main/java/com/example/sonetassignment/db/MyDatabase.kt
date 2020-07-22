package com.example.sonetassignment.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sonetassignment.model.countryModelList.CountryModel
import com.example.sonetassignment.model.regionModelList.RegionModel

@Database(entities = [CountryModel::class,RegionModel::class], version = 2, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract val countryListDao: CountryListDao
    abstract val regionDao: RegionDao

    companion object{
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "SonetAssignment"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}