package com.example.breakingbad.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.breakingbad.database.getDatabase
import com.example.breakingbad.repository.Repository
import retrofit2.HttpException

class RefreshDataWork(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {
    companion object {
        const val WORK_HOME = "RefreshDataWork"
    }

    override suspend fun doWork(): Result {
        val breakingDatabase = getDatabase(applicationContext)
        val breakingRepository = Repository(breakingDatabase)
        return try {
            breakingRepository.refreshCharacters()
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }

}