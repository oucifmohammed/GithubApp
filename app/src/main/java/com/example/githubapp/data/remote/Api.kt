package com.example.githubapp.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String = "created:>2021-04-27",
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc",
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): Response<GithubResponse>
}