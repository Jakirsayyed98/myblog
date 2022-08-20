package jackcompany.myblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import jackcompany.myblog.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

        lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            MainActivity.openMainActivity(this)
            finish()
        },2500)

        setContentView(binding.root)
    }
}