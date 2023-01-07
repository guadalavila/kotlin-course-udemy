package com.guadalavila.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.*;
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var name = "Guada";
        var age = 29;
        Log.d("Main", "Hola soy $name, tengo $age años ");
        var strFormat: String = String.format("Hola soy %s y tengo %d añitos", name, age);
        Log.d("Main", strFormat);
        var lastName="Alavila";
        lastName = "asdas";

        val constant = "Soy una constante"

        abs(-100)
        val nmb1 =20;
        val nmb2 = 90;
        val result = nmb1 +nmb2;

        Log.d("Main", "El rdo de sumar $nmb1 y $nmb2 es $result")
        Log.d("Main", "Pi vale ${Math.PI}")

        val duration = 6;
        for (i in 0 .. duration){
            Log.d("Main", "Hola $i");
        }
        for (i in  0 until duration){
            Log.d("Main", "Hola until $i");
        }

        for (i in  0 until duration step 2){
            Log.d("Main", "Hola until $i");
        }

        var minutes = 0;

        while(minutes <= 6){
            minutes ++;
            Log.d("Main", "Se incrementa en 1 y el valor actual es $minutes");
        }


        var numbers = intArrayOf(2,3,5);

        for (i in 0 .. numbers.size-1){
            Log.d("Main", "Recorriendo el array de numeros ${numbers[i]}")
        }

        var accepts = booleanArrayOf(true, false, false)
        var numbs = IntArray(3);

        var playlists = arrayOf("a", "b", "c");
        for(movie in playlists){
            Log.d("Main", movie)
        }


        var ages = intArrayOf(2,3,4,5,6,7);
        var multipl = 1;
        for(age in ages){
            multipl *= age;
        }

        Log.d("Main", "La multiplicación de todos los numeros es: $multipl")
        Log.d("Main", "La suma de todos los numeros es: ${ages.sum()}")
        Log.d("Main", "El numero 32423 existe?: ${ages.contains(32423)}")

        playMovie("Avatar")

        val movie = Movie("Avatar", 123);
        movie.playTrailer()
        Log.d("Main", "${movie.toString()}")

        val totalFrames = Movie.getTotalFrames(movie.duration);
        Log.d("Main", "La cantidad de frames es : $totalFrames")

        setContentView(R.layout.activity_main)
    }

    private fun playMovie(movie: String){
        for(i in 0..4){
            Log.d("Main", "Now Playing $movie");

        }
    }

    private fun isc(value: Boolean = true): Boolean {
       return false;
    }

    private fun iscsad(): Unit {
    }



}