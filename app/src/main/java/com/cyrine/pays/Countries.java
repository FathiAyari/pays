package com.cyrine.pays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Countries extends AppCompatActivity {
    private RecyclerView countryRecyclerView;
    private CountryAdapter countryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        countryRecyclerView = findViewById(R.id.countryRecyclerView);
        countryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Les Etats-Unis", R.drawable.usa, "Amérique de nord", "Washington, D.C.", "US Dollar"));
        countries.add(new Country("Canada", R.drawable.canada, " Amérique de nord", "Ottawa", "Dollar Canadian "));
        countries.add(new Country("La Tunisie", R.drawable.tunisia, "L'afrique", "Tunis", "Dinar Tunisian "));
        countries.add(new Country("La france", R.drawable.france, "Europe", "Paris", "Euro"));
        countries.add(new Country("Brésil", R.drawable.brezil, "Amérique du Sud", "Brasilia ", "Réal brésilien"));
        countries.add(new Country("Japon", R.drawable.japan, "Asie", "Tokyo", "Yen"));
        countries.add(new Country("Australie", R.drawable.aust, "North America", "Canberra ", " Dollar australien"));
        countries.add(new Country("Egypte", R.drawable.egy, " Afrique", "Le Caire", " Livre égyptienne"));
        countries.add(new Country("Argentine", R.drawable.arg, "Amérique du Sud", "Buenos Aires", " Peso argentin "));
        countries.add(new Country("Norvège", R.drawable.norv, "Europe", "Oslo ", "Couronne norvégienne "));

        countryAdapter = new CountryAdapter(countries, this);
        countryRecyclerView.setAdapter(countryAdapter);
    }
}