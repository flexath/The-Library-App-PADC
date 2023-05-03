package com.flexath.thelibrary.network

import com.flexath.thelibrary.network.responses.BookListResponse
import com.flexath.thelibrary.network.responses.BookOverviewResponse
import com.flexath.thelibrary.utils.*
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TheLibraryApi {

    @GET(API_GET_BOOK_OVERVIEW)
    fun getBookOverview(
        @Query(PARAM_API_KEY) api_key:String = LIBRARY_API_KEY,
    ) : Observable<BookOverviewResponse>

    @GET(API_GET_BOOK_LIST)
    fun getBookList(
        @Query(PARAM_API_KEY) api_key:String = LIBRARY_API_KEY,
        @Query(PARAM_LIST) list:String
    ) : Observable<BookListResponse>
}