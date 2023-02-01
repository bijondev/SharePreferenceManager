# SharePreferenceManager
android sharedpreferences using kotlin singleton class


SharedPreferences is a data storage mechanism in Android that allows you to save key-value pairs of primitive data types (such as int, boolean, float, and String) in a simple file-based persistence. It's used to store user preferences, configuration settings, or any small amounts of data that need to be persisted across multiple app launches.

SharedPreferences is stored in an XML file and can be accessed by any component in the same application. You can choose between private (MODE_PRIVATE) or world-readable (MODE_WORLD_READABLE) and world-writeable (MODE_WORLD_WRITEABLE) preferences, depending on your needs.

Here's an example of how to save and retrieve a String value in SharedPreferences:


```
// usages
val TAG ="MainActivity"
 private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(applicationContext) }
    

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
```
