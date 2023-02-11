package com.guadalavila.basketscores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.guadalavila.basketscores.databinding.ActivityResumeBinding

class ResumeActivity : AppCompatActivity() {

    companion object {
        const val VISIT_KEY =  "visit_score";
        const val LOCAL_KEY =  "local_score";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResumeBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val extras = intent.extras;
        val visitScores: Int = extras?.getInt(VISIT_KEY) ?: 0 ;
        val localScores: Int = extras?.getInt(LOCAL_KEY) ?: 0 ;

        Log.d("el rdo", visitScores.toString())

        binding.resultEdit.text = "${localScores.toString()} - ${visitScores.toString()}"

        if(visitScores == localScores){
            binding.descriptionText.text = getString(R.string.it_was_a_tie);
        }else if( visitScores> localScores) {
            binding.descriptionText.text = getString(R.string.win_visit);
        }else {
            binding.descriptionText.text = getString(R.string.win_local);
        }

        binding.backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}