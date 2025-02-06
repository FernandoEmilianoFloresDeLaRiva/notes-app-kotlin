package com.example.moviles_223251_proyecto.shared.helpers

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.Locale

class TextToSpeechHelper(ctx : Context) : TextToSpeech.OnInitListener{
    private var textToSpeech : TextToSpeech? = TextToSpeech(ctx, this)

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            textToSpeech?.language = Locale.getDefault()
        } else {
            Log.e("TTS_TAG", "Error al inicializar TextToSpeech")
        }
    }

    fun speak(text: String) {
        textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    fun stop() {
        textToSpeech?.stop()
    }

    fun release() {
        textToSpeech?.shutdown()
    }
}