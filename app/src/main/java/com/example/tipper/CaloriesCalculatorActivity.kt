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
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputLayout
import java.text.DecimalFormat
import java.util.*

/**
 * CaloriesCalculatorActivity
 * @author Damian Brzoskowski s18499
 */
class CaloriesCalculatorActivity : AppCompatActivity() {
    private var female: Button? = null
    private var male: Button? = null
    private var calculate: Button? = null
    private var main: Button? = null
    private var inputHeightLayout: TextInputLayout? = null
    private var inputWeightLayout: TextInputLayout? = null
    private var inputAgeLayout: TextInputLayout? = null
    private var result: TextView? = null
    private var weight = 0f
    private var height = 0f
    private var calories = 0f
    private var age = 0
    private var gender: String? = null
    private val df = DecimalFormat("#.##")
    private var formatted: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories_calculator)
        female = findViewById(R.id.chooseFemale)
        male = findViewById(R.id.chooseMale)
        calculate = findViewById(R.id.calculateCalories)
        main = findViewById(R.id.returnToMainMenu)
        inputHeightLayout = findViewById(R.id.inputHeightLayout)
        inputWeightLayout = findViewById(R.id.inputWeightLayout)
        inputAgeLayout = findViewById(R.id.inputAgeLayout)
        result = findViewById(R.id.showResult)
        main = findViewById(R.id.returnToMainMenu)

        //set default gender
        gender = "female"
        female.setEnabled(false)
        female.setOnClickListener(View.OnClickListener {
            if (gender == "female") {
                female.setEnabled(false)
            } else {
                gender = "female"
                female.setEnabled(false)
                male.setEnabled(true)
            }
        })
        male.setOnClickListener(View.OnClickListener {
            if (gender == "male") {
                male.setEnabled(false)
            } else {
                gender = "male"
                male.setEnabled(false)
                female.setEnabled(true)
            }
        })
        calculate.setOnClickListener(View.OnClickListener { getResult() })
        main.setOnClickListener(View.OnClickListener { finish() })
    }

    private fun getResult() {
        height =
            Objects.requireNonNull(inputHeightLayout!!.editText).text.toString().trim { it <= ' ' }
                .toFloat()
        weight =
            Objects.requireNonNull(inputWeightLayout!!.editText).text.toString().trim { it <= ' ' }
                .toFloat()
        age = Objects.requireNonNull(inputAgeLayout!!.editText).text.toString().trim { it <= ' ' }
            .toInt()
        if (gender != null) {
            when (gender) {
                "male" -> {
                    calories = 66.47f + 13.7f * weight + 5.0f * height - 6.76f * age
                    formatted = df.format(calories.toDouble())
                    result!!.text = formatted
                }
                "female" -> {
                    calories = 655.1f + 9.567f * weight + 1.85f * height - 4.68f * age
                    formatted = df.format(calories.toDouble())
                    result!!.text = formatted
                }
            }
        } else Toast.makeText(applicationContext, "Choose gender!", Toast.LENGTH_SHORT).show()
    }
}