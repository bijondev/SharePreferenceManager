# SharePreferenceManager
android sharedpreferences using kotlin singleton class


SharedPreferences is a data storage mechanism in Android that allows you to save key-value pairs of primitive data types (such as int, boolean, float, and String) in a simple file-based persistence. It's used to store user preferences, configuration settings, or any small amounts of data that need to be persisted across multiple app launches.

SharedPreferences is stored in an XML file and can be accessed by any component in the same application. You can choose between private (MODE_PRIVATE) or world-readable (MODE_WORLD_READABLE) and world-writeable (MODE_WORLD_WRITEABLE) preferences, depending on your needs.

Here's an example of how to save and retrieve a String value in SharedPreferences:

val sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE)
```
// Save data
val editor = sharedPreferences.edit()
editor.putString("key", "value")
editor.apply()

// Retrieve data
val value = sharedPreferences.getString("key", null)
```
