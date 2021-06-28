package com.example.mysunflower.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.mysunflower.data.UnsplashPhoto
import com.example.mysunflower.data.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class DisplayViewModel @Inject constructor(
    private val repository: UnsplashRepository
): ViewModel() {

    fun search(query: String): Flow<PagingData<UnsplashPhoto>>
        = repository.getSearchResultStream(query).cachedIn(viewModelScope)
}