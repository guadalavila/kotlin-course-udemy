package com.guadalavila.superheroes

import android.content.ClipDescription
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.guadalavila.superheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveButton.setOnClickListener {
            Log.d("MainActivity", "you tap save")
            val name: String = binding.heroNameEdit.text.toString();
            val alterEgo: String = binding.heroAlterEgoEdit.text.toString();
            val description: String = binding.descriptionEdit.text.toString();
            val power = binding.ratingBar.rating
            val hero = SuperHero(name, alterEgo, description, power)
            openDetailActivity(hero);
        }
    }

    private fun openDetailActivity (hero: SuperHero) {
        //Un Intent es como un sobre que lleva contenido a otras activities
        val intent =  Intent(this, DetailActivity::class.java) //explicit Intent
        intent.putExtra(DetailActivity.HERO_KEY, hero)
        startActivity(intent)
    }
}