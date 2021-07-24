package com.example.bugtracker.ui.list_bugs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bugtracker.data.models.BugTracker
import com.example.bugtracker.repository.BugTrackerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class BugsViewModel() : ViewModel() {

    private val repository: BugTrackerRepository

    init {
        repository = BugTrackerRepository()
    }
    val myResponse: MutableLiveData<Response<BugTracker>> = MutableLiveData()

    fun getBugs() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getBugs()
            myResponse.postValue(response)
        }
    }
}