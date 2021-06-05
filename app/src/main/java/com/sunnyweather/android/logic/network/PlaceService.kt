package com.sunnyweather.android.logic.network

import com.sunnyweather.android.logic.model.PlaceResponse
import com.sunnyweather.android.ui.SunnyWeatherApplication
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    //返回值必须声明成Call类型，并通过泛型来指定服务器响应的数据应该转化成什么对象
    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}