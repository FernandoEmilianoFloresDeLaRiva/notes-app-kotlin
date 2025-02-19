package com.example.moviles_223251_proyecto.createnote.domain.dtos

data class CreateNoteDto(var title : String, var description : String, var author : Int){
    fun isValid() : Boolean {
        return title.isNotEmpty() && description.isNotEmpty() && author != 0
    }
}