package com.example.funnyquiz

import android.icu.text.AlphabeticIndex
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {
    private val questions = listOf(
        Question("Qual é a capital do Brasil?", listOf("Brasília", "Rio de Janeiro", "São Paulo", "Salvador"), 0),
        Question("Qual é o maior planeta do Sistema Solar?", listOf("Terra", "Marte", "Júpiter", "Vênus"), 2),
        Question("Quem escreveu 'Dom Quixote'?", listOf("Miguel de Cervantes", "William Shakespeare", "Machado de Assis", "Dante Alighieri"), 0)
    )

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        val questionTextView: TextView = findViewById(R.id.questionTextView)
        val optionButtons = listOf(
            findViewById<Button>(R.id.option1Button)
            findViewById<Button>(R.id.option2Button)
            findViewById<Button>(R.id.option3Button)
            findViewById<Button>(R.id.option4Button)
        )

        showQuestion(questionTextView, optionButtons)

        optionButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                checkAnswer(index)
                loadNextQuestion(questionTextView, optionButtons)
            }

        }


        }
    }

    private fun showQuestion(questioTextView: TextView, optionButtons: List<Button>) {
        val question = questions[currentQuestionIndex]
        val questionTextView
        questionTextView.text = question.text
        question.options.forEachIndexed { index, option ->
            optionButtons[index].text = option
        }


        }
    private fun checkAnswer(selectedIndex: Int) {
        val correctIndex = questions[currentQuestionIndex].correctAnswerIndex
        if (selectedIndex == correctIndex){
            score++
            Toast.makeText(this, "Correto!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Errado!", Toast.LENGTH_SHORT).show()
        }
    }
    private fun loadNextQuestion(questioTextView: TextView, optionButtons: List<Button>){
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size){
            showQuestion(questioTextView, optionButtons)
        } else {
            Toast.makeText(this, "Quiz Finalizado! Pontuação: $score/${questions.size} ", Toast.LENGTH_SHORT).show()

        }
    }
}

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswer: Int
)
