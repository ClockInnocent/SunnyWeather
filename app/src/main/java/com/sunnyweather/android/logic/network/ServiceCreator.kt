package com.sunnyweather.android.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {

    private const val BASE_URL = "https://api.caiyunapp.com/"

    //构建Retrofit对象
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL) //指定所有Retrofit请求的根路径
        .addConverterFactory(GsonConverterFactory.create()) //指定Retrofit在解析数据时所使用数据库
        .build()

    //retrofit.create()方法会创建一个动态代理对象，有了动态代理对象之后，就可以随意调用接口中定义的所有方法
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun <reified T> create(): T = create(T::class.java)
}