package com.flexath.thelibrary.data.models

import androidx.lifecycle.LiveData
import com.flexath.thelibrary.data.vos.list.BookListResultVO
import com.flexath.thelibrary.data.vos.overview.CategoryVO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

object LibraryModelImpl : LibraryBaseModel(), LibraryModel {

    override fun getBookOverview(onFailure: (String) -> Unit): LiveData<List<CategoryVO>>? {

        mLibraryApi.getBookOverview()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mLibraryDatabase?.libraryDao()?.insertCategories(it.results?.lists ?: listOf())
            }, {
                onFailure(it.localizedMessage ?: "")
            })
        return mLibraryDatabase?.libraryDao()?.getCategories()
    }

    override fun getBookList(
        listName: String,
        onFailure: (String) -> Unit
    ): LiveData<List<BookListResultVO>>? {
        mLibraryApi.getBookList(list = listName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mLibraryDatabase?.libraryDao()?.insertBookList(it.results ?: listOf())
            }, {
                onFailure(it.localizedMessage ?: "")
            })
        return mLibraryDatabase?.libraryDao()?.getBookList()
    }

}