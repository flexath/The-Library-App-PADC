package com.flexath.thelibrary.data.models

import androidx.lifecycle.LiveData
import com.flexath.thelibrary.data.vos.list.BookListResultVO
import com.flexath.thelibrary.data.vos.overview.CategoryVO

interface LibraryModel {

    fun getBookOverview(
        onFailure: (String) -> Unit
    ) : LiveData<List<CategoryVO>>?

    fun getBookList(
        listName:String,
        onFailure: (String) -> Unit
    ) : LiveData<List<BookListResultVO>>?
}