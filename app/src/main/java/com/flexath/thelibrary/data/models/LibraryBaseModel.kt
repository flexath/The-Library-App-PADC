package com.flexath.thelibrary.data.models

import android.content.Context
import com.flexath.thelibrary.network.TheLibraryApi
import com.flexath.thelibrary.persistence.LibraryDatabase
import com.flexath.thelibrary.utils.BASE_URL
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class LibraryBaseModel {

    protected var mLibraryApi: TheLibraryApi
    protected var mLibraryDatabase: LibraryDatabase? = null

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        mLibraryApi = retrofit.create(TheLibraryApi::class.java)
    }

    fun initDatabase(context: Context) {
        mLibraryDatabase = LibraryDatabase.getDbInstance(context)
    }
}