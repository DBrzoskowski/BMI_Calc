/*
BMI Calculator based on Tipper project
Author: Damian Brzoskowski s18499
*/


package com.example.tipper;
import java.text.DecimalFormat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.view.View;
import android.widget.Button;
import android.widget.EditText; // for bill amount input
import android.widget.TextView; // for displaying text
/**
 * BmiCalculatorActivity
 * @author Damian Brzoskowski s18499
 */
public class BmiCalculatorActivity extends AppCompatActivity {

    // currency and percent formatter objects
    private double weightAmount = 0; // bill amount entered by the user
    private double heightAmount = 0; // bill amount entered by the user
    private TextView weightTextView; // shows formatted bill amount
    private TextView heightTextView; // shows formatted bill amount
    private TextView bmiTextView;
    private Button main;

    // called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call superclass onCreate
        setContentView(R.layout.activity_bmi_calculator); // inflate the GUI

        // get references to programmatically manipulated TextViews
        weightTextView = (TextView) findViewById(R.id.weightTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        bmiTextView = (TextView) findViewById(R.id.bmiTextView);
        String bmiInitText = "0 BMI";
        bmiTextView.setText(bmiInitText);
        main = findViewById(R.id.backToMainMenu);

        // set amountEditText's TextWatcher
        EditText weightEditText =
                (EditText) findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);

        // set amountEditText's TextWatcher
        EditText heightEditText =
                (EditText) findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heightEditTextWatcher);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    // calculate and display tip and total amounts
    private void calculate() {
        // calculate the tip and total
        double total = (weightAmount / ((heightAmount / 100) * (heightAmount / 100)));

        // display tip and total formatted as currency
        DecimalFormat dfZero = new DecimalFormat("0.00");
        String result = dfZero.format(total) + " " + "BMI";
        bmiTextView.setText(result);
    }

    // listener object for the EditText's text-changed events
    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        // called when the user modifies the bill amount
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try { // get bill amount and display currency formatted value
                weightAmount = Integer.parseInt(s.toString());
                String result = weightAmount + " " + "kg";
                weightTextView.setText(result);
            }
            catch (NumberFormatException e) { // if s is empty or non-numeric
                weightTextView.setText("");
                weightAmount = 0;
            }

            calculate(); // update the tip and total TextViews
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    private final TextWatcher heightEditTextWatcher = new TextWatcher() {
        // called when the user modifies the bill amount
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try { // get bill amount and display currency formatted value
                heightAmount = Integer.parseInt(s.toString());
                String result = heightAmount + " " + "cm";
                heightTextView.setText(result);
            }
            catch (NumberFormatException e) { // if s is empty or non-numeric
                heightTextView.setText("");
                heightAmount = 0;
            }

            calculate(); // update the tip and total TextViews
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };
}


/*************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
