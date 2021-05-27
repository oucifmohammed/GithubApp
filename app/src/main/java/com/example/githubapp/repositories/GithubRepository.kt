package com.example.githubapp.repositories

import com.example.githubapp.data.remote.Api
import com.example.githubapp.data.remote.GithubResponse
import com.example.githubapp.other.Resource
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val githubApi: Api
){

    suspend fun searchRepositories(per_page: Int, page: Int): Resource<GithubResponse> {

        return try {
            val response = githubApi.searchRepositories(perPage = per_page,page = page)

            if(response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Unknown error occurred", null)
            }else {
                Resource.error("Unknown error occurred", null)
            }
        }catch (exception: Exception){
            Resource.error("Could not reach the server,check your internet connection", null)
        }
    }
}