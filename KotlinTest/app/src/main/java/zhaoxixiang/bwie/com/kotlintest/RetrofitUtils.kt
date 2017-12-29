package zhaoxixiang.bwie.com.kotlintest

import android.util.Log

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitUtils private constructor() {
    fun <T> getApiService(url: String, cl: Class<T>): T {
        val retrofit = getRetrofit(url)//得到retrofit

        return retrofit.create(cl)//返回的就是网络接口对象

    }

    companion object {
        private var retrofitUtils: RetrofitUtils? = null
        val instance: RetrofitUtils
            get() {
                if (retrofitUtils == null) {
                    synchronized(RetrofitUtils::class.java) {
                        if (retrofitUtils == null) {
                            retrofitUtils = RetrofitUtils()
                        }
                    }
                }
                return retrofitUtils!!
            }

        private var retrofit: Retrofit? = null
        @Synchronized
        fun getRetrofit(url: String): Retrofit {
            val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.i("xxx", message) })
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .connectTimeout(500, TimeUnit.SECONDS)
                    .readTimeout(500, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(false)
                    .build()
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(url)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
            }
            return retrofit!!
        }
    }


}

