package com.example.moviles_223251_proyecto.home.domain.adapters

import com.example.moviles_223251_proyecto.shared.domain.adapters.NoteCategoryResponseAdapter
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

data class NoteResponseAdapter(
    val id : Int,
    val title : String,
    val description : String,
    val active : Int,
    val archive : Int,
    var author : Int,
    var created_at : String,
    var id_category : List<NoteCategoryResponseAdapter>? = emptyList()
){

    fun getFormattedDate(): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        inputFormat.timeZone = TimeZone.getTimeZone("UTC")
        val date = inputFormat.parse(created_at)
        val outputFormat = SimpleDateFormat("dd/MM/yy", Locale.getDefault())
        return outputFormat.format(date ?: created_at)
    }
}