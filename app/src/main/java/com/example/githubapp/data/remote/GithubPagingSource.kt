package com.example.githubapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.githubapp.other.Constant.REPOSITORIES_STARTING_PAGE_INDEX

class GithubPagingSource(
    val githubApi: Api
): PagingSource<Int,Item>(){

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        val position = params.key ?: REPOSITORIES_STARTING_PAGE_INDEX

        return try {
            val response = githubApi.searchRepositories(perPage = params.loadSize,page = position).body()
            val repositories = response!!.items

            LoadResult.Page(
                data = repositories,
                prevKey = if(position == REPOSITORIES_STARTING_PAGE_INDEX) null else position-1,
                nextKey = if(repositories.isEmpty()) null else position+1
            )
        }catch (exception: Exception){
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        TODO("Not yet implemented")
    }
}