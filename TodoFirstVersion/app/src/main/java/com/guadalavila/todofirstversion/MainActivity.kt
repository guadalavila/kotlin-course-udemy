package com.guadalavila.todofirstversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.guadalavila.todofirstversion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        var listTasks = mutableListOf<String>();

        binding.totalTasksText.text = "Total de Tareas: ${listTasks.size}";

        binding.btnAddTask.setOnClickListener {
            listTasks.add(binding.taskEdit.toString());
            binding.totalTasksText.text = "Total de Tareas: ${listTasks.size}";
            binding.taskEdit.setText("")
            Log.d("Main", "Se agrego!")
        }
    }
}