package com.example.bugtracker.ui.list_bugs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.bugtracker.data.models.Bug
import com.example.bugtracker.data.network.BugPagingSource
import com.example.bugtracker.repository.BugTrackerRepository
import kotlinx.coroutines.flow.Flow

class BugsViewModel : ViewModel() {

    private val repository: BugTrackerRepository = BugTrackerRepository()

    val bugs: Flow<PagingData<Bug>> = Pager(PagingConfig(pageSize = 1)) {
        BugPagingSource(repository)
    }.flow
        .cachedIn(viewModelScope)
}
