package co.idwall.iddog.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    fun retrofit(url: String) = Retrofit.Builder()
        .baseUrl(url)
        .client(buildOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun buildOkHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClientBuilder.addInterceptor(interceptor)

        return okHttpClientBuilder.build()
    }

    var call: AmaroEndpoints = retrofit("https://amaro-mobile.s3.amazonaws.com/pair-programing-mock/").create(AmaroEndpoints::class.java)
}