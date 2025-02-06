package com.example.moviles_223251_proyecto.shared.helpers

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.Locale

class TextToSpeechHelper(ctx : Context) : TextToSpeech.OnInitListener{
    companion object {
        private const val LANGUAGE_CODE = "es"
        private const val COUNTRY_CODE = "MX"
        private const val SPEECH_RATE = 0.7f
        private const val PITCH = 0.9f
    }
    private var textToSpeech : TextToSpeech? = TextToSpeech(ctx, this)

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val languageConfig  = Locale(LANGUAGE_CODE, COUNTRY_CODE)
            val result = textToSpeech?.setLanguage(languageConfig)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS_TAG", "Language not supported")
            } else {
                textToSpeech?.setSpeechRate(SPEECH_RATE)
                textToSpeech?.setPitch(PITCH)
            }
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