package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.petapp.Adapters.AnimalListAdapter;
import com.example.petapp.Models.Animal;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    class ViewHolder {


        ListView listViewAnimals;

        public ViewHolder() {
            listViewAnimals = findViewById(R.id.list);
        }
    }

    ViewHolder vh;

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        vh = new ViewHolder();

//        ViewGroup sceneRoot = (ViewGroup) findViewById(R.id.list);
//
//        scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.activity_list, this);
//        scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.activity_details, this);
//
//        scene1.enter();
//        currentScene = scene1;

        String category = getIntent().getStringExtra("category");

        List<Animal> currentCategory = null;

        if (category.equals("1")) {
            currentCategory = DataProvider.getCats();
        } else if (category.equals("2")) {
            currentCategory = DataProvider.getDogs();
        } else {
            currentCategory = DataProvider.getRabbits();
        }

        AnimalListAdapter animalListAdapter = new AnimalListAdapter(this, R.layout.list_view_animal_item, currentCategory);
        vh.listViewAnimals.setAdapter(animalListAdapter);

        vh.listViewAnimals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailsActivity = new Intent(getBaseContext(), DetailsActivity.class);

                String category = getIntent().getStringExtra("category");
                List<Animal> currentCategory = null;

                if (category.equals("1")) {
                    currentCategory = DataProvider.getCats();
                } else if (category.equals("2")) {
                    currentCategory = DataProvider.getDogs();
                } else {
                    currentCategory = DataProvider.getRabbits();
                }

                currentCategory.get(position).updateViewCount();

//                if (currentScene == scene1) {
//                    TransitionManager.go(scene2);
//                    currentScene = scene2;
//                } else {
//                    TransitionManager.go(scene1);
//                    currentScene = scene1;
//                }


                detailsActivity.putExtra("animal", (Parcelable) currentCategory.get(position));
                startActivity(detailsActivity);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }
}