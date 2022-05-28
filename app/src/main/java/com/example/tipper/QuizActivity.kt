package com.example.tipper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipper.R
import android.view.animation.Animation
import android.content.Intent
import com.example.tipper.MenuActivity
import com.example.tipper.BmiCalculatorActivity
import com.example.tipper.CaloriesCalculatorActivity
import com.example.tipper.ReceipActivity
import com.example.tipper.QuizActivity
import com.example.tipper.Question
import android.annotation.SuppressLint
import android.os.Handler
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import android.text.TextWatcher
import android.text.Editable
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputLayout
import java.lang.Exception
import java.util.ArrayList

class QuizActivity : AppCompatActivity() {
    private var currentQuestionIndex = 1
    private var questionCount = 0
    private var currentScore = 0
    private var main: Button? = null
    private var buttonAnswer1: Button? = null
    private var buttonAnswer2: Button? = null
    private var buttonAnswer3: Button? = null
    private var buttonAnswer4: Button? = null
    private var buttonRestartQuiz: Button? = null
    private var textViewCurrentQuestion: TextView? = null
    private var textViewResult: TextView? = null
    private var textViewCurrentScoreValue: TextView? = null
    private var textViewQuestionCounterValue: TextView? = null
    private var questions: ArrayList<Question>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        buttonAnswer1 = findViewById(R.id.buttonAnswer1)
        buttonAnswer2 = findViewById(R.id.buttonAnswer2)
        buttonAnswer3 = findViewById(R.id.buttonAnswer3)
        buttonAnswer4 = findViewById(R.id.buttonAnswer4)
        buttonRestartQuiz = findViewById(R.id.buttonRestartQuiz)
        textViewCurrentQuestion = findViewById(R.id.textViewCurrentQuestion)
        textViewResult = findViewById(R.id.textViewResult)
        textViewCurrentScoreValue = findViewById(R.id.textViewCurrentScoreValue)
        textViewQuestionCounterValue = findViewById(R.id.textViewQuestionCounterValue)
        main = findViewById(R.id.backToMainMenu)
        buttonAnswer1.setOnClickListener(answerButtonListener)
        buttonAnswer2.setOnClickListener(answerButtonListener)
        buttonAnswer3.setOnClickListener(answerButtonListener)
        buttonAnswer4.setOnClickListener(answerButtonListener)
        buttonRestartQuiz.setOnClickListener(restartButtonListener)
        generateView()
        main.setOnClickListener(View.OnClickListener { finish() })
    }

    fun generateView() {
        loadQuestions()
        questionCount = questions!!.size
        restartQuiz()
    }

    private val answerButtonListener = View.OnClickListener { view ->
        try {
            if (currentQuestionIndex > questionCount) {
                return@OnClickListener
            }
            var choosenAnswer = -1
            when (view.id) {
                R.id.buttonAnswer1 -> choosenAnswer = 1
                R.id.buttonAnswer2 -> choosenAnswer = 2
                R.id.buttonAnswer3 -> choosenAnswer = 3
                R.id.buttonAnswer4 -> choosenAnswer = 4
            }

            // check answer is correct
            checkAnswer(choosenAnswer)
            updateScore()
            currentQuestionIndex++

            // display next question
            if (currentQuestionIndex > questionCount) {
                textViewCurrentQuestion!!.text = getString(R.string.end)
                buttonAnswer1!!.visibility = View.INVISIBLE
                buttonAnswer2!!.visibility = View.INVISIBLE
                buttonAnswer3!!.visibility = View.INVISIBLE
                buttonAnswer4!!.visibility = View.INVISIBLE
                return@OnClickListener
            }
            updateQuestion()
        } catch (e: Exception) {
            textViewCurrentQuestion!!.text = "#ERROR"
        }
    }

    private fun checkAnswer(answer: Int) {
        val currentQuestion = questions!![currentQuestionIndex - 1]
        val correctAnswer = currentQuestion.answers[currentQuestion.correctAnswer - 1]
        if (answer == currentQuestion.correctAnswer) {
            currentScore++
            textViewResult!!.text = getString(R.string.good_answer)
        } else {
            textViewResult!!.text = getString(R.string.correct_answer) + " " + correctAnswer
        }
        val handler = Handler()
        handler.postDelayed({ textViewResult!!.text = "" }, 2000)
    }

    private val restartButtonListener = View.OnClickListener {
        try {
            restartQuiz()
        } catch (e: Exception) {
            textViewCurrentQuestion!!.text = "PROBLEM"
        }
    }

    private fun loadQuestions() {
        questions = ArrayList()
        questions!!.add(
            Question(
                getString(R.string.question_1),
                arrayOf(
                    getString(R.string.question_1_ans1),
                    getString(R.string.question_1_ans2),
                    getString(R.string.question_1_ans3),
                    getString(R.string.question_1_ans4)
                ),
                2
            )
        )
        questions!!.add(
            Question(
                getString(R.string.question_2),
                arrayOf(
                    getString(R.string.question_2_ans1),
                    getString(R.string.question_2_ans2),
                    getString(R.string.question_2_ans3),
                    getString(R.string.question_2_ans4)
                ),
                2
            )
        )
        questions!!.add(
            Question(
                getString(R.string.question_3),
                arrayOf(
                    getString(R.string.question_3_ans1),
                    getString(R.string.question_3_ans2),
                    getString(R.string.question_3_ans3),
                    getString(R.string.question_3_ans4)
                ),
                3
            )
        )
        questions!!.add(
            Question(
                getString(R.string.question_4),
                arrayOf(
                    getString(R.string.question_4_ans1),
                    getString(R.string.question_4_ans2),
                    getString(R.string.question_4_ans3),
                    getString(R.string.question_4_ans4)
                ),
                4
            )
        )
        questions!!.add(
            Question(
                getString(R.string.question_5),
                arrayOf(
                    getString(R.string.question_5_ans1),
                    getString(R.string.question_5_ans2),
                    getString(R.string.question_5_ans3),
                    getString(R.string.question_5_ans4)
                ),
                2
            )
        )
        questions!!.add(
            Question(
                getString(R.string.question_6),
                arrayOf(
                    getString(R.string.question_6_ans1),
                    getString(R.string.question_6_ans2),
                    getString(R.string.question_6_ans3),
                    getString(R.string.question_6_ans4)
                ),
                4
            )
        )
        questions!!.add(
            Question(
                getString(R.string.question_7),
                arrayOf(
                    getString(R.string.question_7_ans1),
                    getString(R.string.question_7_ans2),
                    getString(R.string.question_7_ans3),
                    getString(R.string.question_7_ans4)
                ),
                2
            )
        )
    }

    private fun updateScore() {
        textViewCurrentScoreValue!!.text = Integer.toString(currentScore)
    }

    private fun updateQuestion() {
        textViewQuestionCounterValue!!.text = "$currentQuestionIndex/$questionCount"
        updateScore()
        val currentQuestion = questions!![currentQuestionIndex - 1]
        val currentAnswers = currentQuestion.answers
        textViewCurrentQuestion!!.text = currentQuestion.question
        buttonAnswer1!!.text = currentAnswers[0]
        buttonAnswer2!!.text = currentAnswers[1]
        buttonAnswer3!!.text = currentAnswers[2]
        buttonAnswer4!!.text = currentAnswers[3]
    }

    private fun restartQuiz() {
        currentScore = 0
        currentQuestionIndex = 1
        buttonAnswer1!!.visibility = View.VISIBLE
        buttonAnswer2!!.visibility = View.VISIBLE
        buttonAnswer3!!.visibility = View.VISIBLE
        buttonAnswer4!!.visibility = View.VISIBLE
        updateQuestion()
    }
}