package uz.umarxon.service5

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import android.widget.Toast

class MediaService :Service(){
    private val TAG = "MediaService"
    private var mediaPlayer : MediaPlayer? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()
        Toast.makeText(this, "Service started mediPlayer", Toast.LENGTH_SHORT).show()
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onBind(p0: Intent?): IBinder? {

        Log.d(TAG, "onBind: OnBind ishlamoqda....")
        return null
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnbind: onUnbind ishlamoqda....")
        return super.onUnbind(intent)
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: onCreate ishlamoqda")
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        Toast.makeText(this, "Service stopped mediaPLayer", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onDestroy: ")
    }

}