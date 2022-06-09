package com.example.petapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.example.petapp.Adapters.RecyclerViewAdapter;
import com.example.petapp.Models.Animal;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  RecyclerViewAdapter.OnAnimalListener{



    class ViewHolder {

        CardView cardViewCats;
        CardView cardViewDogs;
        CardView cardViewRabbits;
        RecyclerView recyclerViewTop;

        public ViewHolder() {
            recyclerViewTop = findViewById(R.id.recycler_view_top);
            cardViewCats = findViewById(R.id.cardview_cats);
            cardViewDogs = findViewById(R.id.cardview_dogs);
            cardViewRabbits = findViewById(R.id.cardview_rabbits);
        }
    }

    ViewHolder vh;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search_activity_button) {
            Intent searchActivity = new Intent(getBaseContext(), SearchActivity.class);
            startActivity(searchActivity);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        vh.recyclerViewTop.setLayoutManager(layoutManager);
        RecyclerViewAdapter topAnimalAdapter = new RecyclerViewAdapter(DataProvider.getSortedList(), this, this);
        vh.recyclerViewTop.setAdapter(topAnimalAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataProvider.generateCatInfo();
        DataProvider.generateDogInfo();
        DataProvider.generateRabbitInfo();

        vh = new ViewHolder();


        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        vh.recyclerViewTop.setLayoutManager(layoutManager);
        RecyclerViewAdapter topAnimalAdapter = new RecyclerViewAdapter(DataProvider.getSortedList(), this, this);
        vh.recyclerViewTop.setAdapter(topAnimalAdapter);


        vh.cardViewCats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listActivity = new Intent(getBaseContext(), ListActivity.class);
                listActivity.putExtra("category", "1");
                startActivity(listActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        vh.cardViewDogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listActivity = new Intent(getBaseContext(), ListActivity.class);
                listActivity.putExtra("category", "2");
                startActivity(listActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        vh.cardViewRabbits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listActivity = new Intent(getBaseContext(), ListActivity.class);
                listActivity.putExtra("category", "3");
                startActivity(listActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }

    @Override
    public void onAnimalClick(int position) {

        Animal animal = DataProvider.getSortedList().get(position);

        animal.updateViewCount();

        Intent detailsActivity = new Intent(getBaseContext(), DetailsActivity.class);
        detailsActivity.putExtra("animal", (Parcelable) animal);
        startActivity(detailsActivity);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
