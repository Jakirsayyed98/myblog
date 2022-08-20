package jackcompany.myblog

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jackcompany.myblog.databinding.ActivityMainBinding
import jackcompany.myblog.databinding.ActivitySplashBinding

class MainActivity : AppCompatActivity() {
    
    lateinit var binding: ActivityMainBinding
    
    companion object{
        fun openMainActivity(
        context : Context,
        ){
        context.startActivity(Intent(context,MainActivity::class.java))
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        
        
        setContentView(binding.root)
    }
}