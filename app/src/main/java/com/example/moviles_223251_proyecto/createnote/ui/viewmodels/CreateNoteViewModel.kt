package com.example.moviles_223251_proyecto.createnote.ui.viewmodels

import android.app.Application
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviles_223251_proyecto.core.SharedPreference.UserPreference.UserPreferences
import com.example.moviles_223251_proyecto.core.data.local.appDatabase.AppDatabase
import com.example.moviles_223251_proyecto.core.domain.models.TextFieldConfig
import kotlinx.coroutines.launch

class CreateNoteViewModel(app : Application) : AndroidViewModel(app) {
    private val title = mutableStateOf<String>("")
    private val description = mutableStateOf<String>("")
    val username = mutableStateOf<String>("")
    private val userPreferences = UserPreferences(app)
    private val userDao = AppDatabase.getDatabase(app).userDao()
    private var userId = mutableIntStateOf(0)

    init {
        getUsername()
    }

    fun getTextFields() : List<TextFieldConfig> {
        return listOf(
            TextFieldConfig(
                value = title.value,
                onValueChange = {  title.value = it },
                label = "Titulo",
            ),
            TextFieldConfig(
                value = description.value,
                onValueChange = {description.value = it},
                label = "Descripción",
            )
        )
    }

    private fun getUsername () {
        viewModelScope.launch {
            userId.intValue = userPreferences.getUserId()?.toInt() ?: 0
            val user = userDao.getUserById(userId.intValue)
            username.value = user?.username ?: ""
        }
    }
}