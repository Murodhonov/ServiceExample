package uz.umarxon.service5

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.umarxon.service5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            /*start.setOnClickListener {
                val intent = Intent(binding.root.context,MediaService::class.java)
                startService(intent)
            }
            stop.setOnClickListener {
                val intent = Intent(binding.root.context,MediaService::class.java)
                stopService(intent)
            }*/


            val jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val jobInfo = JobInfo.Builder(1, ComponentName(this@MainActivity,MyJobService::class.java))
            val job = jobInfo.setMinimumLatency(1)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setOverrideDeadline(60000)
                .build()

            start.setOnClickListener{
                jobScheduler.schedule(job)
            }
            stop.setOnClickListener {
                jobScheduler.cancel(1)
            }

            }
        }

    }
