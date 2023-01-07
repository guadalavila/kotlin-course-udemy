package com.guadalavila.superheroes

import android.app.Activity
import android.content.ClipDescription
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.drawable.toBitmap
import com.guadalavila.superheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var heroImage: ImageView
    private var heroBitmap: Bitmap ? = null
    //lateinit se le asegura a kotlin que va a tener un valor, antes de ser usada

    private val getContent = registerForActivityResult(ActivityResultContracts.TakePicturePreview()){
        bitmap ->
        heroBitmap = bitmap
        heroImage.setImageBitmap(heroBitmap)

    }

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

        heroImage = binding.heroImage

        binding.heroImage.setOnClickListener{
            openCamera()
        }
    }

    private fun openCamera() {
        //create intent implicito para abrir la camara //Deprecado
  /*      val camaraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camaraIntent, 1000) //deprecated*/
        getContent.launch(null)
    }

    private fun openDetailActivity (hero: SuperHero) {
        //Un Intent es como un sobre que lleva contenido a otras activities
        val intent =  Intent(this, DetailActivity::class.java) //explicit Intent
        intent.putExtra(DetailActivity.HERO_KEY, hero)
        intent.putExtra(DetailActivity.BITMAP_KEY, heroImage.drawable.toBitmap())
        startActivity(intent)
    }

    //se llama automaticamente, luego de tomar la foto...esta deprecado
    /*    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data) //deprecated
            if(resultCode == Activity.RESULT_OK && requestCode == 1000) {
                val extras= data?.extras
                val heroBitmap = extras?.getParcelable<Bitmap>("data")
                heroImage.setImageBitmap(heroBitmap)
            }
        }*/
}