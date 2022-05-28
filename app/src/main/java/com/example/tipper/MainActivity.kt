package com.example.tipper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipper.R
import android.widget.ImageButton
import android.view.animation.Animation
import android.content.Intent
import com.example.tipper.MenuActivity
import com.example.tipper.BmiCalculatorActivity
import com.example.tipper.CaloriesCalculatorActivity
import com.example.tipper.ReceipActivity
import com.example.tipper.QuizActivity
import android.widget.TextView
import com.example.tipper.Question
import android.annotation.SuppressLint
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import android.widget.EditText
import com.github.mikephil.charting.utils.ColorTemplate
import android.text.TextWatcher
import android.text.Editable
import android.view.animation.AnimationUtils
import com.google.android.material.textfield.TextInputLayout
import android.widget.Toast

/**
 * MainActivity
 * @author Damian Brzoskowski s20047
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startBtn = findViewById<ImageButton>(R.id.startButton)
        val animFadeIn = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
        startBtn.animation = animFadeIn
        startBtn.setOnClickListener { launchMenu() }
    }

    private fun launchMenu() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }
}