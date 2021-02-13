package com.example.jobscheduler

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.getSystemService

class MainActivity : AppCompatActivity() {
    public var Job_Id=123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
public fun scheduleJob(view: View) {
    var js=  getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
    var ji=JobInfo.Builder(Job_Id, ComponentName(this,JobDemo::class.java))
            .setPeriodic(20000)
            .setPersisted(true)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
            .setRequiresCharging(true)
            .build()
    js.schedule(ji)
}
    }
