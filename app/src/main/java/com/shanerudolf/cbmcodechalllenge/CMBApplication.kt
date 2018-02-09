package com.shanerudolf.cbmcodechalllenge

import android.app.Application
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.util.Log
import com.shanerudolf.cbmcodechalllenge.services.PhotoPreloadService

/**
 * Created by shane1 on 2/9/18.
 */
class CMBApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        schedulePhotoFetchForBatteryAndWifi()
    }

    private fun schedulePhotoFetchForBatteryAndWifi(){
        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        val jobInfo = JobInfo
                .Builder(1, ComponentName(this, PhotoPreloadService::class.java))
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setRequiresCharging(false)
                .setMinimumLatency(10)
                .build()
        jobScheduler.schedule(jobInfo)
    }
}