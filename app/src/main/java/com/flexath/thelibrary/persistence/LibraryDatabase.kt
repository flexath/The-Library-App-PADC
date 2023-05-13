package com.flexath.thelibrary.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.flexath.thelibrary.data.vos.SearchBookVO
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.data.vos.google.GoogleBookVO
import com.flexath.thelibrary.data.vos.list.BookListResultVO
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.data.vos.overview.CategoryVO
import com.flexath.thelibrary.persistence.daos.LibraryDao

@Database([CategoryVO::class,BookListResultVO::class,ShelfVO::class,BookVO::class,GoogleBookVO::class,SearchBookVO::class], version = 3 , exportSchema = false)
abstract class LibraryDatabase : RoomDatabase() {

    abstract fun libraryDao():LibraryDao

    companion object {
        private var libraryDatabase:LibraryDatabase? = null
        private const val DB_NAME = "TheLibraryDatabase"

        fun getDbInstance(context:Context) : LibraryDatabase? {
            when(libraryDatabase) {
                null -> {
                    libraryDatabase = Room.databaseBuilder(context,LibraryDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return libraryDatabase
        }
    }
}