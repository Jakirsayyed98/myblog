package jackcompany.myblog.Network

import jackcompany.myblog.BuildConfig
import jackcompany.myblog.modelclass.RetrivePost.RetriveAllPostRes
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface MyApiClass {

    @GET("posts?key=AIzaSyD3TT_KUoaK4AF79pvkJYmszroAzMOnrEo")
    suspend fun getAllPost(): Response<RetriveAllPostRes>

    companion object {

        operator fun invoke(): MyApiClass {
            val loggin = HttpLoggingInterceptor()
            loggin.setLevel(HttpLoggingInterceptor.Level.BODY)

            var client = OkHttpClient.Builder().apply {
                callTimeout(30, TimeUnit.MILLISECONDS)
                if (BuildConfig.DEBUG) {
                    addInterceptor(loggin)
                }
            }.build()


            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.googleapis.com/blogger/v3/blogs/5039934551850610359")
                .client(client)
                .build()
                .create(MyApiClass::class.java)
        }

    }
}