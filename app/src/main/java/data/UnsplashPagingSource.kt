package com.example.mysunflower.data

import androidx.paging.PagingSource
import com.example.mysunflower.api.UnsplashService
import java.lang.Exception

private const val UNSPLASH_STARTING_PAGE_INDEX = 1
class UnsplashPagingSource(
    private val service: UnsplashService,
    private val query: String
): PagingSource<Int, UnsplashPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
        // todo why?
        val page = params.key ?: UNSPLASH_STARTING_PAGE_INDEX
        return try{
            val response = service.searchPhotos(query, page, params.loadSize)
            val photos = response.results
            LoadResult.Page(
                data = photos,
                prevKey = if (page == UNSPLASH_STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (page == response.totalPages) null else page + 1
            )
        }catch(e : Exception){
            LoadResult.Error(e)
        }
    }
}