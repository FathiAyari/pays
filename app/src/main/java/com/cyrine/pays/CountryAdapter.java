package com.cyrine.pays;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cyrine.pays.Country;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private List<Country> countryList;
    private Context context;

    public CountryAdapter(List<Country> countryList, Context context) {
        this.countryList = countryList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.country_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.nameTextView.setText(country.getName());
        holder.continentTextView.setText(country.getContinent());
        holder.flagImageView.setImageResource(country.getFlagResourceId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CountryDetailsActivity.class);
                intent.putExtra("country", country);
                Bundle bn = new Bundle();

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView flagImageView;
        TextView nameTextView;
        TextView continentTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            flagImageView = itemView.findViewById(R.id.flagImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            continentTextView = itemView.findViewById(R.id.continentTextView);
        }
    }
}
