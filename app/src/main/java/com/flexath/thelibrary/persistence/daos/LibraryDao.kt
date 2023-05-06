package com.flexath.thelibrary.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.flexath.thelibrary.data.vos.list.BookDetailVO
import com.flexath.thelibrary.data.vos.list.BookListResultVO
import com.flexath.thelibrary.data.vos.overview.CategoryVO

@Dao
interface LibraryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategories(categoryList:List<CategoryVO>)

    @Query("SELECT * FROM category_table")
    fun getCategories():LiveData<List<CategoryVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBookList(bookList:List<BookListResultVO>)

    @Query("SELECT * FROM book_list_table")
    fun getBookList():LiveData<List<BookListResultVO>>

    @Query("SELECT * FROM category_table WHERE listId = :listId")
    fun getCategoryByListId(listId:Int):LiveData<CategoryVO?>

    @Query("SELECT * FROM book_list_table WHERE id = :bookListId")
    fun getBookFromBookListById(bookListId:Int):LiveData<BookListResultVO>

    @Query("DELETE FROM book_list_table")
    fun deleteTheWholeBookList()
}