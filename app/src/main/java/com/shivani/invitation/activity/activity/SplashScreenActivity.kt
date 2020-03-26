package com.shivani.invitation.activity.activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.shivani.invitation.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        proceed()

    }

    private fun proceed() {
        val background: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(2 * 700.toLong())
                    val intent = Intent(this@SplashScreenActivity, Main2Activity::class.java)
                    startActivity(intent)
                    finish()

                } catch (e: Exception) {
                    print(e.message)
                }
            }
        }
        background.start()
    }
}
