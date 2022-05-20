package aqper.side_project.aop_part5_chapter02.data.preference

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(
    private val context: Context
) {
    companion object {
        const val PREFERENCES_NAME = "aop-part5-chapter02-pref "
        private const val DEFAULT_VALUE_STRING = ""
        private const val DEFAULT_VALUE_BOOLEAN = false
        private const val DEFAULT_VALUE_INT = -1
        private const val DEFAULT_VALUE_LONG = -1L
        private const val DEFAULT_VALUE_FLOAT = -1f

        const val KEY_ID_TOKEN = "ID_TOKEN"
    }

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    private val prefs by lazy { getPreferences(context) }
    private val editor by lazy { prefs.edit() }

    /*
    * String 값 저장
    * @param context
    * @param key
    * @param value*/
    fun setString(key: String?, value: String?) {
        editor.putString(key, value)
        editor.apply()
    }
    /*
    * boolean값 저장
    * @param context
    * @param key
    * @param value*/
    fun setBoolean(key: String?, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    /*
    * Int값 저장
    * @param context
    * @param key
    * @param value*/
    fun set(key: String?, value: Int) {
        editor.putInt(key, value)
        editor.apply()
    }

    /*
    * long값 저장
    * @param context
    * @param key
    * @param value*/
    fun setLong(key: String?, value: Long) {
        editor.putLong(key, value)
        editor.apply()
    }
    /*
    * float값 저장
    * @param context
    * @param key
    * @param value*/
    fun setFloat(key: String?, value: Float) {
        editor.putFloat(key, value)
        editor.apply()
    }

    /*
    * String 값 로드
    * @param context
    * @param key
    * @return*/
    fun getString(key: String?) {
        prefs.getString(key, DEFAULT_VALUE_STRING)
    }

    /*
    * boolean 값 로드
    * @param context
    * @param key
    * @return*/
    fun getBoolean(key: String?) {
        prefs.getBoolean(key, DEFAULT_VALUE_BOOLEAN)
    }

    /*
    * Int 값 로드
    * @param context
    * @param key
    * @return*/
    fun getInt(key: String?) {
        prefs.getInt(key, DEFAULT_VALUE_INT)
    }

    /*
    * Long 값 로드
    * @param context
    * @param key
    * @return*/
    fun getLong(key: String?) {
        prefs.getLong(key, DEFAULT_VALUE_LONG)
    }

    /*
    * Float 값 로드
    * @param context
    * @param key
    * @return*/
    fun getFloat(key: String?) {
        prefs.getFloat(key, DEFAULT_VALUE_FLOAT)
    }

    /*
    * 키값 삭제
    * @param context
    * @param key
    * */
    fun removeKey(key: String?) {
        editor.remove(key)
        editor.apply()
    }

    /*
    * 모든 저장 데이터 삭제
    * @param context
    * */
    fun clear() {
        editor.clear()
        editor.apply()
    }

    fun putIdToken(idToken: String) {
        editor.putString(KEY_ID_TOKEN, idToken)
        editor.apply()
    }

    fun getIdToken(): String? {
        return prefs.getString(KEY_ID_TOKEN, null)
    }

    fun removedToken() {
        editor.putString(KEY_ID_TOKEN, null)
        editor.apply()
    }
}