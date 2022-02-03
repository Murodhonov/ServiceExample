package uz.umarxon.service5

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class MyJobService:JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        Log.d("Murodhonov", "onStartJob: MyJobService")
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("Murodhonov", "onStopJob: MyJobService")
        return true
    }


}

class MyFirebaseJobService:JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        Log.d("Murodhonov", "onStartJob: MyJobService")
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("Murodhonov", "onStopJob: MyJobService")
        return true
    }


}