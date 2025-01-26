package com.example.moviles_223251_proyecto.core.SharedPreference.UserPreference

import android.content.Context
import com.example.moviles_223251_proyecto.core.domain.constants.AppPrefs

class UserPreferences(context: Context) {
    private val sharedPreferences = context.getSharedPreferences(AppPrefs.PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun saveUserId(userId: Int) {
        sharedPreferences.edit().putString(AppPrefs.USER_ID_PREFERENCE, userId.toString()).apply()
    }

    fun getUserId(): String? {
        return sharedPreferences.getString(AppPrefs.USER_ID_PREFERENCE, null)
    }

    fun clearUserId() {
        sharedPreferences.edit().remove(AppPrefs.USER_ID_PREFERENCE).apply()
    }
}