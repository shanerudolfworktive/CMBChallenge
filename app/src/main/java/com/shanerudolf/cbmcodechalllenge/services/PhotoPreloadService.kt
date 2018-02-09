package com.shanerudolf.cbmcodechalllenge.services

import android.app.IntentService
import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.Context
import android.content.Intent
import android.util.Log
import com.shanerudolf.cbmcodechalllenge.models.TeamModel
import com.shanerudolf.cbmcodechalllenge.utils.Const
import com.shanerudolf.cbmcodechalllenge.utils.FileUtil
import com.squareup.picasso.Picasso

/**
 * Created by shane1 on 2/9/18.
 */
class PhotoPreloadService : JobService() {
    override fun onStartJob(p0: JobParameters?): Boolean {
        val teamModels = FileUtil.readJSONFromAssets<Array<TeamModel>>(this, Const.teamJsonFilePath)
        if (teamModels != null) {
            val picasso = Picasso.with(this)
            for (teamModel in teamModels) {
                picasso.load(teamModel.avatar).fetch()
            }
        }
        Log.e("shaneTest", "preloading")
        return false
    }


    override fun onStopJob(p0: JobParameters?): Boolean {
        return false
    }
}