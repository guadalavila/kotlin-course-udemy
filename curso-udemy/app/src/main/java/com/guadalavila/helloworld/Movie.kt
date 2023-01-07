package com.guadalavila.helloworld

import android.util.Log

class Movie(var name: String, var duration: Int, var trailer: Trailer? = null) {

    companion object {
        const val FRAME_RATE = 60;
        const val SECOND_IN_A_MINUTE = 60;
        const val FRAME_RATE_SD = 60;


        fun getTotalFrames(duration: Int): Int {
            return FRAME_RATE * SECOND_IN_A_MINUTE * duration;
        }
    }

    fun playTrailer() {
        //? si no es null ejecuta play() y si no imprime el msj
        trailer?.play(name) ?: Log.d("Main", "No tiene trailer")
    }

    fun tes():Int {
        var a = 10;
        var b: Int? = null;
        return a + b!!;
    }

    override fun toString(): String {
        return "Nombre: $name y la duración es $duration"
    }
}