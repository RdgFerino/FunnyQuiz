package com.example.funnyquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Botão para iniciar o quiz
        val startQuizButton: Button = findViewById(R.id.startQuizButton)

        startQuizButton.setOnClickListener {
            // Navegar para a próxima Activity (Tela do Quiz)
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}


