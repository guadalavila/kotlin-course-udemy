package com.guadalavila.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guadalavila.superheroes.databinding.ActivityDemoBinding
import com.guadalavila.superheroes.databinding.ActivityDetailBinding

class DemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDemoBinding.inflate(layoutInflater);
        setContentView(binding.root)
        setContentView(R.layout.activity_demo)
    }
}