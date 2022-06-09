package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.TextView;

import com.example.petapp.Adapters.ViewPagerAdapter;
import com.example.petapp.Models.Animal;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    class ViewHolder {

        CardView cardViewPetInfo;
        ViewPager viewPagerImages;
        TextView textViewName;
        TextView textViewBreed;
        TextView textViewAge;
        TextView textViewTrait1;
        TextView textViewTrait2;

        public ViewHolder() {
            cardViewPetInfo = findViewById(R.id.cardview_pet_images);
            viewPagerImages = findViewById(R.id.viewPagerMain);
            textViewName = findViewById(R.id.textview_name);
            textViewBreed = findViewById(R.id.textview_breed);
            textViewAge = findViewById(R.id.textview_age);
            textViewTrait1 = findViewById(R.id.textview_trait1);
            textViewTrait2 = findViewById(R.id.textview_trait2);

        }
    }

    public int[] getConvertedImageArray(Animal currentAnimal) {

        int[] icons = new int[3];
        List<String> images = currentAnimal.getImages();
        for (int i = 0; i < 3; i++) {
            icons[i] = getResources().getIdentifier(
                    images.get(i), "drawable",
                    getPackageName());
        }

        return icons;
    }

    ViewHolder vh;

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        vh = new ViewHolder();



        Animal animal = getIntent().getParcelableExtra("animal");

        vh.textViewName.setText(animal.getName());
        vh.textViewBreed.setText(animal.getBreed());
        vh.textViewAge.setText(String.valueOf(animal.getAge()));
        vh.textViewTrait1.setText(animal.getTrait1());
        vh.textViewTrait2.setText(animal.getTrait2());

        // Initializing the ViewPagerAdapter
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, getConvertedImageArray(animal));

        // Adding the Adapter to the ViewPager
        vh.viewPagerImages.setAdapter(viewPagerAdapter);

    }
}