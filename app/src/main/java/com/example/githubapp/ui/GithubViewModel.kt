package com.example.githubapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapp.data.remote.GithubResponse
import com.example.githubapp.other.Resource
import com.example.githubapp.repositories.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(
    private val repository: GithubRepository
): ViewModel(){

    private val _githubRepositories = MutableLiveData<Resource<GithubResponse>>()
    val githubRepositories: LiveData<Resource<GithubResponse>> = _githubRepositories

    fun searchRepositories(perPage: Int,page: Int) = viewModelScope.launch {
        _githubRepositories.value = Resource.loading(null)
        val response = repository.searchRepositories(per_page = perPage,page = page)
        _githubRepositories.value = response
    }
}