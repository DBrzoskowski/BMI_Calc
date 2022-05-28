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
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import android.text.TextWatcher
import android.text.Editable
import android.widget.*
import com.google.android.material.textfield.TextInputLayout

/**
 * MenuActivity
 * @author Damian Brzoskowski s18499
 */
class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val goBmiBtn: Button
        val goCaloriesBtn: Button
        val goReceip: Button
        val goQuiz: Button
        goBmiBtn = findViewById(R.id.bmiCalculatorButton)
        goCaloriesBtn = findViewById(R.id.caloriesCalculator)
        goReceip = findViewById(R.id.getReceip)
        goQuiz = findViewById(R.id.goQuiz)
        goBmiBtn.setOnClickListener { launchBmiCalculator() }
        goCaloriesBtn.setOnClickListener { launchCaloriesCalculator() }
        goReceip.setOnClickListener { launchGetReceip() }
        goQuiz.setOnClickListener { launchQuiz() }
    }

    private fun launchBmiCalculator() {
        val intent = Intent(this, BmiCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun launchCaloriesCalculator() {
        val intent = Intent(this, CaloriesCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun launchGetReceip() {
        val intent = Intent(this, ReceipActivity::class.java)
        startActivity(intent)
    }

    private fun launchQuiz() {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }
}