package com.example.espresso_tau

import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import javax.inject.Inject

class SessionCacheImp @Inject constructor(
    private val sharedPreferences: SharedPreferences
):SessionCache {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val adaptor = moshi.adapter(Data::class.java)


    override fun saveSession(data: Data) {
        sharedPreferences.edit()
            .putString("data",adaptor.toJson(data))
            .apply()
    }

    override fun getActiveSession(): Data? {
        val json =sharedPreferences.getString("data",null)?: return null
        return adaptor.fromJson(json)
    }

    override fun clearSession() {
        sharedPreferences.edit().remove("data").apply()
    }
}