package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.petapp.Adapters.AnimalListAdapter;
import com.example.petapp.Models.Animal;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private List<Animal> filteredList;

    class ViewHolder {


        ListView listViewSearch;
        TextView textViewSearch;

        public ViewHolder() {

            listViewSearch = findViewById(R.id.list_view_search);
            textViewSearch = findViewById(R.id.text_view_search_result);

        }
    }

    ViewHolder vh;

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the options menu from XML
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

//        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default
        searchView.setQueryHint("Search by breed or animal");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                vh.textViewSearch.setText("Showing results for: " + newText);
                filterList(newText);
                return true;
            }
        });


        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        vh = new ViewHolder();

        filteredList = DataProvider.getAllAnimals();

        AnimalListAdapter animalListAdapter = new AnimalListAdapter(this, R.layout.list_view_animal_item, filteredList);
        vh.listViewSearch.setAdapter(animalListAdapter);

        vh.listViewSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailsActivity = new Intent(getBaseContext(), DetailsActivity.class);

                getFilteredList().get(position).updateViewCount();

                detailsActivity.putExtra("animal", (Parcelable) getFilteredList().get(position));
                startActivity(detailsActivity);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }

    private void filterList(String text) {
        List<Animal> list = new ArrayList<Animal>();
        AnimalListAdapter animalListAdapter = new AnimalListAdapter(this, R.layout.list_view_animal_item, list);

        for(Animal animal: DataProvider.getAllAnimals()) {
            if(animal.getBreed().toLowerCase().contains(text.toLowerCase()) || animal.getType().toLowerCase().contains(text.toLowerCase())) {
                list.add(animal);
            }
        }

        if (list.isEmpty()) {
            vh.textViewSearch.setText("Sorry, search result not found");

        }
        animalListAdapter.setFilteredList(list);
        vh.listViewSearch.setAdapter(animalListAdapter);

        filteredList = list;

    }

    private List<Animal> getFilteredList() {
        return filteredList;
    }

}