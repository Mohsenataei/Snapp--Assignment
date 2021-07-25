package io.github.maa96.data.source.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.maa96.data.model.poi.PointOfInterestDto
import io.github.maa96.data.source.db.dao.PointOfInterestDao

@Database(entities = [PointOfInterestDto::class], version = AppDataBase.VERSION)
abstract class AppDataBase : RoomDatabase() {

    abstract fun pointOfInterestDao(): PointOfInterestDao

    companion object {
        const val DB_NAME = "snapAssignment.db"
        const val VERSION = 1

        @Volatile
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDataBase(context).also {
                    instance = it
                }
            }
        }

        fun buildDataBase(context: Context): AppDataBase {
            return Room
                .databaseBuilder(context, AppDataBase::class.java, AppDataBase.DB_NAME)
                .build()
        }
    }
}
