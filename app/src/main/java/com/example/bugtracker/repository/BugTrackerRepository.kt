package com.example.bugtracker.repository

import com.example.bugtracker.data.network.RetrofitInstance
import com.example.bugtracker.data.models.BugTracker
import retrofit2.Response

class BugTrackerRepository {

    suspend fun getBugs(): Response<BugTracker> {
        return RetrofitInstance.api.getBugs()
    }

}