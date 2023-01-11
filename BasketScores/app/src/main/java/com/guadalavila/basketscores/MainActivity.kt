package com.guadalavila.basketscores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.guadalavila.basketscores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var localScore : Int = 0
        var visitScore : Int = 0


        binding.localScores.text = localScore.toString();
        binding.visitScores.text = localScore.toString();

        binding.navigateBtn.setOnClickListener {
            val intent =  Intent(this, ResumeActivity::class.java);
            startActivity(intent);
        }

        binding.addOneLocalBtn.setOnClickListener {
            localScore += 1;
            binding.localScores.text = localScore.toString();
        }
        binding.addTwoLocalBtn.setOnClickListener {
            localScore += 2;
            binding.localScores.text = localScore.toString();
        }
        binding.restLocalBtn.setOnClickListener {
            if(localScore != 0 ){
                localScore -= 1;
                binding.localScores.text = localScore.toString();
            }else{
              Toast.makeText(this, "No puedes disminuir al local", Toast.LENGTH_LONG).show()
            }
        }

        binding.addOneVisitBtn.setOnClickListener {
            visitScore += 1;
            binding.visitScores.text = visitScore.toString();
        }
        binding.addTwoVisitBtn.setOnClickListener {
            visitScore += 2;
            binding.visitScores.text = visitScore.toString();
        }
        binding.restVisitBtn.setOnClickListener {
            if(visitScore != 0 ){
                visitScore -= 1;
                binding.visitScores.text = visitScore.toString();
            }else{
                Toast.makeText(this, "No puedes disminuir al visitante", Toast.LENGTH_LONG).show()
            }
        }
        binding.restartBtn.setOnClickListener {
            localScore = 0;
            visitScore = 0;
            binding.visitScores.text= visitScore.toString()
            binding.localScores.text= localScore.toString()
            Toast.makeText(this, "Vuelve a empezar", Toast.LENGTH_SHORT).show();
        }
    }
}