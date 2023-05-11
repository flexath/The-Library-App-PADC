package com.flexath.thelibrary.data.models

import androidx.lifecycle.LiveData
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.data.vos.list.BookListResultVO
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.data.vos.overview.CategoryVO
import io.reactivex.rxjava3.core.Observable

interface LibraryModel {

    fun getBookOverview(
        onFailure: (String) -> Unit
    ) : LiveData<List<CategoryVO>>?

    fun getBookList(
        listName:String,
        onFailure: (String) -> Unit
    ) : LiveData<List<BookListResultVO>>?

    fun getCategoryByListId(listId:Int) : LiveData<CategoryVO?>?

    fun getBookFromBookListById(bookListId:Int) : LiveData<BookListResultVO>?

    fun deleteTheWholeBookList()

    fun insertShelf(shelf: ShelfVO)

    fun getShelfList():LiveData<List<ShelfVO>>?

    fun getShelfById(shelfId:Int):LiveData<ShelfVO>?

    fun deleteShelf(shelfId:Int)

    fun updateShelf(shelf: ShelfVO)

    fun insertBookIntoLibrary(bookVO: BookVO?)

    fun getAllBooksFromLibrary() : LiveData<List<BookVO>>?

    fun deleteBookByTitle(title:String)

    fun getBookByTitle(title:String) : LiveData<BookVO?>?

    fun searchBookFromGoogle(
        query:String
    ) : Observable<List<BookVO>>
}