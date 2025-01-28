package com.example.moviles_223251_proyecto.createnote.ui.viewmodels

import android.app.Application
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviles_223251_proyecto.core.SharedPreference.UserPreference.UserPreferences
import com.example.moviles_223251_proyecto.core.data.local.appDatabase.AppDatabase
import com.example.moviles_223251_proyecto.core.domain.models.TextFieldConfig
import com.example.moviles_223251_proyecto.createnote.data.services.CreateNoteService
import com.example.moviles_223251_proyecto.createnote.domain.dtos.CreateNoteDto
import com.example.moviles_223251_proyecto.createnote.domain.models.CreateNoteState
import kotlinx.coroutines.launch

class CreateNoteViewModel(app : Application) : AndroidViewModel(app) {
    private val title = mutableStateOf("")
    private val description = mutableStateOf("")
    val username = mutableStateOf("")
    val createNoteState = mutableStateOf<CreateNoteState>(CreateNoteState.Idle)
    private val userPreferences = UserPreferences(app)
    private val userDao = AppDatabase.getDatabase(app).userDao()
    private var userId = mutableIntStateOf(0)
    private val createNoteService = CreateNoteService()

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

    private fun getCreateNoteDto() : CreateNoteDto {
        return CreateNoteDto(
            title = title.value,
            description = description.value,
            author = userId.intValue
        )
    }

    fun createNote(){
        val createNoteDto = getCreateNoteDto()
        if(createNoteDto.isValid()){
            viewModelScope.launch {
                createNoteState.value = CreateNoteState.Loading
                val result = createNoteService.createNote(createNoteDto)

                result.fold(
                    onSuccess = { createNoteResponse ->
                        createNoteState.value = CreateNoteState.Success(createNoteResponse)
                    },
                    onFailure = { exception ->
                        createNoteState.value = CreateNoteState.Error(exception.message ?:"Error desconocido")
                    }
                )
                title.value = ""
                description.value = ""
            }
        }else{
            createNoteState.value = CreateNoteState.Error("Todos los campos son requeridos")
        }
    }

    fun resetState(){
        createNoteState.value = CreateNoteState.Idle
    }
}