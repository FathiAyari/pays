package com.cyrine.pays;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CountryDetailsActivity extends AppCompatActivity {
    private TextView countryNameTextView;
    private TextView countryCapitalTextView;
    private TextView countryCurrencyTextView;
    private TextView countryContinentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);

        countryNameTextView = findViewById(R.id.countryNameTextView);
        countryCapitalTextView = findViewById(R.id.countryCapitalTextView);
        countryCurrencyTextView = findViewById(R.id.countryCurrencyTextView);
        countryCapitalTextView = findViewById(R.id.countryCapitalTextView);
        countryContinentTextView = findViewById(R.id.countryContinentTextView);

        Intent intent = getIntent();
        Country ctr = (Country) getIntent().getSerializableExtra("country");
        System.out.println(ctr.toString());

        countryNameTextView.setText("Votre choix est : "+ctr.getName());
        countryCapitalTextView.setText("La capital est :"+ctr.getCapital());
        countryCurrencyTextView.setText("Le monnaie est :"+ctr.getCurrency());
        countryContinentTextView.setText("La continent est :"+ctr.getContinent());
    }
}
