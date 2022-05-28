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
import java.util.*

/**
 * ReceipActivity
 * @author Damian Brzoskowski s18499
 */
class ReceipActivity : AppCompatActivity() {
    private var titleTextView: TextView? = null
    private var dishImageView: ImageView? = null
    private var recipeImageView: ImageView? = null
    private var main: Button? = null
    private val random = Random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receip)
        titleTextView = findViewById(R.id.titleTextView)
        dishImageView = findViewById(R.id.dishImageView)
        recipeImageView = findViewById(R.id.recipeImageView)
        main = findViewById(R.id.backToMainMenu)
        generateView()
        main.setOnClickListener(View.OnClickListener { finish() })
    }

    fun generateView() {
        val upperbound = resources.getInteger(R.integer.upperbound) //random from 0 to 1
        val recipe = random.nextInt(upperbound)
        when (recipe) {
            0 -> {
                titleTextView!!.text = "Magiczne Ciasto"
                dishImageView!!.setImageResource(R.drawable.magiczne_ciasto)
                recipeImageView!!.setImageResource(R.drawable.magiczne_ciasto_przepis)
            }
            1 -> {
                titleTextView!!.text = "Szarlotka z Lodami"
                dishImageView!!.setImageResource(R.drawable.szarlotka_z_lodami)
                recipeImageView!!.setImageResource(R.drawable.szarlotka_z_lodami_przepis)
            }
        }
    }
}