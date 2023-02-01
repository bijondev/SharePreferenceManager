package com.bijondev.sharepreferencemanager

interface IPreferenceHelper {
    fun setStr(key: String, value: String?)
    fun getStr(key: String): String

    fun setInt(key: String, value: Int?)
    fun getInt(key: String): Int

    fun setBool(key: String, value: Boolean?)
    fun getBool(key: String): Boolean

    fun setApiKey(apiKey: String)
    fun getApiKey(): String



    fun setUserId(userId: String)
    fun getUserId(): String
    fun clearPrefs()
}