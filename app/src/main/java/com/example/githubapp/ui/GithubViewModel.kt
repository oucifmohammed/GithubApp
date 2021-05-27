package com.example.githubapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.githubapp.data.remote.Api
import com.example.githubapp.data.repositories.GithubPagingSource
import com.example.githubapp.data.remote.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(
    private val githubApi: Api
): ViewModel(){

//    private var _githubRepositories = MutableLiveData<PagingData<Item>>()
    lateinit var githubRepositories: LiveData<PagingData<Item>>

//    fun searchRepositories(perPage: Int,page: Int) = viewModelScope.launch {
//        _githubRepositories.value = Resource.loading(null)
//        val response = repository.searchRepositories(per_page = perPage,page = page)
//        _githubRepositories.value = response
//    }

    fun searchRepositories(){
        githubRepositories = Pager(
            PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false)
        ) {
            GithubPagingSource(githubApi)
        }.liveData
            .cachedIn(viewModelScope)
    }
}