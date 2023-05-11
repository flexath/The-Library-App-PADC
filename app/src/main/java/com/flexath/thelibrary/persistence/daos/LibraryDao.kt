package com.flexath.thelibrary.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.data.vos.google.GoogleBookVO
import com.flexath.thelibrary.data.vos.list.BookDetailVO
import com.flexath.thelibrary.data.vos.list.BookListResultVO
import com.flexath.thelibrary.data.vos.overview.BookVO
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShelf(shelf:ShelfVO)

    @Query("SELECT * FROM shelf_table")
    fun getShelfList():LiveData<List<ShelfVO>>

    @Query("SELECT * FROM shelf_table WHERE id = :shelfId")
    fun getShelfById(shelfId:Int):LiveData<ShelfVO>

    @Query("DELETE FROM shelf_table WHERE id = :shelfId")
    fun deleteShelfById(shelfId:Int)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateShelf(shelf:ShelfVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBookIntoLibrary(book:BookVO?)

    @Query("SELECT * FROM library_table")
    fun getAllBooksFromLibrary():LiveData<List<BookVO>>

    @Query("DELETE FROM library_table WHERE title = :title")
    fun deleteBookByTitle(title:String)

    @Query("SELECT * FROM library_table WHERE title = :title")
    fun getBookByTitle(title:String):LiveData<BookVO?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGoogleBookList(bookList:List<BookVO>)

    @Query("SELECT * FROM library_table")
    fun getGoogleBookList():LiveData<List<BookVO>>
}