package com.bijondev.sharepreferencemanager

import android.content.Context
import android.content.SharedPreferences

open class PreferenceManager constructor(context: Context) : IPreferenceHelper {
    private val PREFS_NAME = "app_data"
    private var preferences: SharedPreferences

    init {
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }


    override fun setStr(key: String, value: String?) {
        preferences[key] = value
    }
    override fun getStr(key: String): String {
        return preferences[key] ?: ""
    }

    override fun setInt(key: String, value: Int?) {
        preferences[key] = value
    }
    override fun getInt(key: String): Int {
        return preferences[key] ?: 0
    }

    override fun setBool(key: String, value: Boolean?) {
        preferences[key] = value
    }
    override fun getBool(key: String): Boolean {
        return preferences[key] ?: false
    }


    override fun setApiKey(apiKey: String) {
        preferences[API_KEY] = apiKey
    }
    override fun getApiKey(): String {
        return preferences[API_KEY] ?: ""
    }

    override fun setUserId(userId: String) {
        preferences[USER_ID] = userId
    }

    override fun getUserId(): String {
        return preferences[USER_ID] ?: ""
    }

    override fun clearPrefs() {
        preferences.edit().clear().apply()
    }

    companion object {
        const val API_KEY = "api_key"
        const val USER_ID = "user_id"
    }
}


/**
 * SharedPreferences extension function, to listen the edit() and apply() fun calls
 * on every SharedPreferences operation.
 */
private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = this.edit()
    operation(editor)
    editor.apply()
}

/**
 * puts a key value pair in shared prefs if doesn't exists, otherwise updates value on given [key]
 */
private operator fun SharedPreferences.set(key: String, value: Any?) {
    when (value) {
        is String? -> edit { it.putString(key, value) }
        is Int -> edit { it.putInt(key, value) }
        is Boolean -> edit { it.putBoolean(key, value) }
        is Float -> edit { it.putFloat(key, value) }
        is Long -> edit { it.putLong(key, value) }
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}

/**
 * finds value on given key.
 * [T] is the type of value
 * @param defaultValue optional default value - will take null for strings, false for bool and -1 for numeric values if [defaultValue] is not specified
 */
private inline operator fun <reified T : Any> SharedPreferences.get(
    key: String,
    defaultValue: T? = null
): T? {
    return when (T::class) {
        String::class -> getString(key, defaultValue as? String) as T?
        Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
        Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
        Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
        Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}