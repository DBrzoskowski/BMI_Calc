package com.example.tipper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

/**
 * ReceipActivity
 * @author Damian Brzoskowski s18499
 */
public class ReceipActivity extends AppCompatActivity {

    private TextView titleTextView;
    private ImageView dishImageView, recipeImageView;
    private Button main;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receip);

        titleTextView = findViewById(R.id.titleTextView);
        dishImageView = findViewById(R.id.dishImageView);
        recipeImageView = findViewById(R.id.recipeImageView);
        main = findViewById(R.id.backToMainMenu);

        generateView();

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void generateView() {
        final int upperbound = getResources().getInteger(R.integer.upperbound); //random from 0 to 1
        int recipe = random.nextInt(upperbound);
        switch (recipe) {
            case 0: {
                titleTextView.setText("Magiczne Ciasto");
                dishImageView.setImageResource(R.drawable.magiczne_ciasto);
                recipeImageView.setImageResource(R.drawable.magiczne_ciasto_przepis);
                break;
            } case 1: {
                titleTextView.setText("Szarlotka z Lodami");
                dishImageView.setImageResource(R.drawable.szarlotka_z_lodami);
                recipeImageView.setImageResource(R.drawable.szarlotka_z_lodami_przepis);
                break;
            }
        }
    }
}