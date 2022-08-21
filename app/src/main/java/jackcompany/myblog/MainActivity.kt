package jackcompany.myblog

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBarDrawerToggle
import jackcompany.myblog.Network.RequestViewModel
import jackcompany.myblog.databinding.ActivityMainBinding
import jackcompany.myblog.databinding.ActivitySplashBinding

class MainActivity : AppCompatActivity() {
    
    lateinit var binding: ActivityMainBinding

    var requestViewModel : RequestViewModel?=null
    
    companion object{
        fun openMainActivity(
        context : Context,
        ){
        context.startActivity(Intent(context,MainActivity::class.java))
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setUpToolbar()
        getViewmodel()
        setContentView(binding.root)
    }

    private fun getViewmodel() {

        requestViewModel?.getData()?.observe(this,{
            it.data.let {
                it.forEach {
                    Log.d("DATANEWS",it.title)
                }
            }
        })

        getViewmodelClassData()
    }

    private fun getViewmodelClassData() {
        requestViewModel!!.getAllPostfromBlog()
    }

    private fun setUpToolbar() {
        setSupportActionBar(binding.toolbar)
        val actionBarDrawerToggle = ActionBarDrawerToggle(this,binding.drawerlayout,binding.toolbar,R.string.app_name,R.string.app_name)
        binding.drawerlayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }
}