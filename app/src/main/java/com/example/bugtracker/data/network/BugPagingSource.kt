package com.example.bugtracker.data.network

import androidx.paging.PagingSource
import com.example.bugtracker.data.models.Bug
import com.example.bugtracker.repository.BugTrackerRepository

class BugPagingSource(private val repository: BugTrackerRepository): PagingSource<Int, Bug>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Bug> {
        return try {
            val nextPage = params.key ?: 1
            val response = repository.getBugs(nextPage)

            LoadResult.Page(
                data = response.body()!!.bugs,
                prevKey = if (nextPage == 1) null else nextPage.minus(1),
                nextKey = if (nextPage > response.body()!!.totalPages) null else nextPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}