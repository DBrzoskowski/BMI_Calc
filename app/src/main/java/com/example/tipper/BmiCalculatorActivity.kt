/*
BMI Calculator based on Tipper project
Author: Damian Brzoskowski s18499
*/
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
import android.graphics.Color
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import android.text.TextWatcher
import android.text.Editable
import android.view.View
import android.widget.*
import com.github.mikephil.charting.components.Description
import com.google.android.material.textfield.TextInputLayout
import java.lang.NumberFormatException
import java.text.DecimalFormat
import java.util.*

// for EditText event handling
// EditText listener
// for bill amount input
// for displaying text
/**
 * BmiCalculatorActivity
 * @author Damian Brzoskowski s18499
 */
class BmiCalculatorActivity : AppCompatActivity() {
    // currency and percent formatter objects
    private var weightAmount = 0.0 // bill amount entered by the user
    private var heightAmount = 0.0 // bill amount entered by the user
    private var weightTextView // shows formatted bill amount
            : TextView? = null
    private var heightTextView // shows formatted bill amount
            : TextView? = null
    private var bmiTextView: TextView? = null
    private var main: Button? = null
    private var buttonBmiAddDataPoint: Button? = null
    private var temp_last_bmi_value = ""
    private var total = 0.0
    var barChart: BarChart? = null
    var barData: BarData? = null
    var barDataSet: BarDataSet? = null
    private var x_index = 0
    var barEntries: ArrayList<*> = ArrayList<BarEntry>(
        Arrays.asList(
            BarEntry(x_index++, 30.0f),
            BarEntry(x_index++, 27.0f),
            BarEntry(x_index++, 28.0f),
            BarEntry(x_index++, 25.5f)
        )
    )

    // called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // call superclass onCreate
        setContentView(R.layout.activity_bmi_calculator) // inflate the GUI

        // get references to programmatically manipulated TextViews
        weightTextView = findViewById(R.id.weightTextView)
        heightTextView = findViewById(R.id.heightTextView)
        bmiTextView = findViewById(R.id.bmiTextView)
        barChart = findViewById(R.id.barchart)
        buttonBmiAddDataPoint = findViewById(R.id.buttonBmiAddDataPoint)
        val bmiInitText = "0 BMI"
        bmiTextView.setText(bmiInitText)
        main = findViewById(R.id.backToMainMenu)

        // set amountEditText's TextWatcher
        val weightEditText = findViewById<EditText>(R.id.weightEditText)
        weightEditText.addTextChangedListener(weightEditTextWatcher)

        // set amountEditText's TextWatcher
        val heightEditText = findViewById<EditText>(R.id.heightEditText)
        heightEditText.addTextChangedListener(heightEditTextWatcher)
        updateBmiBarChart()
        main.setOnClickListener(View.OnClickListener { finish() })
        buttonBmiAddDataPoint.setOnClickListener(View.OnClickListener {
            if (total != 0.0) {
                val formatter = Formatter()
                formatter.format("%.2f", total)
                temp_last_bmi_value = formatter.toString()
                addDataPointAndUpdateBarChart()
            }
        })
    }

    private fun addDataPointAndUpdateBarChart() {
        if (temp_last_bmi_value == "") {
            return
        }
        barEntries.add(BarEntry(x_index, temp_last_bmi_value.toFloat()))
        x_index++
        updateBmiBarChart()
    }

    private fun updateBmiBarChart() {
        val desc = Description()
        desc.text = ""
        barChart!!.description = desc
        barDataSet = BarDataSet(barEntries, "")
        barData = BarData(barDataSet)
        barChart!!.data = barData
        barDataSet!!.setColors(*ColorTemplate.JOYFUL_COLORS)
        barDataSet!!.valueTextColor = Color.BLACK
        barDataSet!!.valueTextSize = 18f
        barChart!!.invalidate()
    }

    // calculate and display tip and total amounts
    private fun calculate() {
        // calculate the tip and total
        total = weightAmount / (heightAmount / 100 * (heightAmount / 100))

        // display tip and total formatted as currency
        val dfZero = DecimalFormat("0.00")
        val result = dfZero.format(total) + " " + "BMI"
        if (total != 0.0) {
            val formatter = Formatter()
            formatter.format("%.2f", total)
            temp_last_bmi_value = formatter.toString()
            //            binding.textViewBMIValue.setText(formatter.toString());
        }
        bmiTextView!!.text = result
    }

    // listener object for the EditText's text-changed events
    private val weightEditTextWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the bill amount
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            try { // get bill amount and display currency formatted value
                weightAmount = s.toString().toInt().toDouble()
                val result = "$weightAmount kg"
                weightTextView!!.text = result
            } catch (e: NumberFormatException) { // if s is empty or non-numeric
                weightTextView!!.text = ""
                weightAmount = 0.0
            }
            calculate() // update the tip and total TextViews
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int
        ) {
        }
    }
    private val heightEditTextWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the bill amount
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            try { // get bill amount and display currency formatted value
                heightAmount = s.toString().toInt().toDouble()
                val result = "$heightAmount cm"
                heightTextView!!.text = result
            } catch (e: NumberFormatException) { // if s is empty or non-numeric
                heightTextView!!.text = ""
                heightAmount = 0.0
            }
            calculate() // update the tip and total TextViews
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int
        ) {
        }
    }
}