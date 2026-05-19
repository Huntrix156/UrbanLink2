package com.example.urbanlink2.data.viewmodel


import androidx.lifecycle.ViewModel
import com.example.urbanlink2.data.model.JobModel.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SavedJobsViewModel : ViewModel() {

    private val _savedJobs = MutableStateFlow<List<Job>>(emptyList())
    val savedJobs: StateFlow<List<Job>> = _savedJobs.asStateFlow()

    fun saveJob(job: Job) {
        // Prevent duplicates — match by title + company
        val alreadySaved = _savedJobs.value.any {
            it.title == job.title && it.company == job.company
        }
        if (!alreadySaved) {
            _savedJobs.value = _savedJobs.value + job
        }
    }

    fun removeJob(job: Job) {
        _savedJobs.value = _savedJobs.value.filter {
            !(it.title == job.title && it.company == job.company)
        }
    }

    fun isJobSaved(job: Job): Boolean {
        return _savedJobs.value.any {
            it.title == job.title && it.company == job.company
        }
    }
}