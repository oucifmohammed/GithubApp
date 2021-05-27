package com.example.githubapp.data.remote

data class GithubResponse(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)