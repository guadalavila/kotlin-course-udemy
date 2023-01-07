package com.guadalavila.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guadalavila.superheroes.databinding.ActivityDetailBinding
import com.guadalavila.superheroes.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    companion object {

        const val NAME_KEY = "name";
        const val EGO_KEY = "alter_ego";
        const val BIO_KEY = "bio";
        const val POWER_KEY = "power";
        const val HERO_KEY = "hero";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater);
        setContentView(binding.root)
        val bundle = intent.extras!!;

        val hero = bundle.getParcelable<SuperHero>(HERO_KEY)!!

    /*
        val name = bundle.getString(NAME_KEY) ?: "";
        val alterEgo = bundle.getString(EGO_KEY)?: "";
        val desc = bundle.getString(BIO_KEY)?: "";
        val power = bundle.getFloat(POWER_KEY)?: 0.0f;
    */
        binding.egoEdit.text = hero.alterEgo;
        binding.bioText.text = hero.bio;
        binding.heroName.text =  hero.name;
        binding.ratingBar.rating = hero.rating;
    }
}