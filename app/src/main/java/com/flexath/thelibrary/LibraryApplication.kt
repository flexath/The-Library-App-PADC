package com.flexath.thelibrary

import android.app.Application
import com.flexath.thelibrary.data.models.LibraryModelImpl

class LibraryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LibraryModelImpl.initDatabase(applicationContext)
    }
}