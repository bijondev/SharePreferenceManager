package com.bijondev.sharepreferencemanager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val TAG ="MainActivity"
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferenceHelper.setApiKey("367478899780890809")
        val api_key = preferenceHelper.getApiKey()
        Log.d(TAG, api_key)

        preferenceHelper.setUserId("111")
        val user_id = preferenceHelper.getUserId()
        Log.d(TAG, user_id)

        preferenceHelper.setStr("email", "bijon.bairagi@gmail.com")
        val email = preferenceHelper.getStr("email")
        Log.d(TAG, email)

        preferenceHelper.setInt("age", 35)
        val age = preferenceHelper.getInt("age")
        Log.d(TAG, age.toString())

        preferenceHelper.setBool("married", true)
        val married = preferenceHelper.getBool("married")
        Log.d(TAG, married.toString())


    }
}