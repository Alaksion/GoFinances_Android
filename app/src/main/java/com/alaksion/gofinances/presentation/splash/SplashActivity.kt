package com.alaksion.gofinances.presentation.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.alaksion.gofinances.R
import com.alaksion.gofinances.presentation.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        overridePendingTransition(R.anim.act_enter, R.anim.act_exit)
    }

    override fun onResume() {
        super.onResume()
        handleRedirect()
    }

    private fun handleRedirect() {
        Handler().postDelayed({
            Runnable {
                MainActivity.start(this)
            }.run()
        }, 3000)
    }
}