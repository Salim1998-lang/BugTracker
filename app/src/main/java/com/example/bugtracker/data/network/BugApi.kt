package com.example.bugtracker.data.network

import com.example.bugtracker.data.models.BugTracker
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BugApi {
    @GET("bug_tracker/")
    suspend fun getBugs(@Query("page") currentPage: Int): Response<BugTracker>
}