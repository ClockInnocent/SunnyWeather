package com.sunnyweather.android.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.sunnyweather.android.logic.model.Place
import com.sunnyweather.android.ui.SunnyWeatherApplication

object PlaceDao {

    fun savePlace(place: Place) {
        sharedPreferences().edit {
            /*
                通过GSON将Place对象转换成一个JSON字符串
                就可以用字符串存储的方式来保存数据了
             */
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavedPlace(): Place {
        val placeJson = sharedPreferences().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java) //通过GSON将JSON字符串解析成Place对象
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")

    /*
        第一个参数用于指定SharedPreferences文件的名称
        第二个参数用于指定操作模式，这里指定为MODE_PRIVATE (与传入0的效果相同)
        表示只有当前的应用程序才可以对这个SharedPreferences文件进行读写
     */
    private fun sharedPreferences() = SunnyWeatherApplication.context
        .getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
}