package com.example.bugtracker.repository

import com.example.bugtracker.data.models.BugTracker
import com.example.bugtracker.data.network.RetrofitInstance
import retrofit2.Response

class BugTrackerRepository {

    suspend fun getBugs(currentPage: Int): Response<BugTracker> {
        return RetrofitInstance.api.getBugs(currentPage)
    }
}
