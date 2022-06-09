package com.example.petapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.petapp.Models.Animal;
import com.example.petapp.R;

import java.util.List;
import java.util.Locale;


public class AnimalListAdapter extends ArrayAdapter<Animal> {

    private int mLayout;
    private Context mContext;
    private List<Animal> mAnimals;

    class ViewHolder {
        ImageView iconImageView;
        TextView nameTextView;
        TextView breedTextView;

        public ViewHolder(View currentView) {
            iconImageView = currentView.findViewById(R.id.animals_listview_icon);
            nameTextView = currentView.findViewById(R.id.animals_listview_name);
            breedTextView = currentView.findViewById(R.id.animals_listview_breed);
        }
    }

    public void setFilteredList(List<Animal> filteredList) {
        this.mAnimals = filteredList;
        notifyDataSetChanged();
    }


    public AnimalListAdapter(@NonNull Context context, int resource, @NonNull List<Animal> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mLayout = resource;
        this.mAnimals = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Get a reference to the current ListView item
        View currentListViewItem = convertView;

        // Check if the existing view is being reused, otherwise inflate the view
        if (currentListViewItem == null) {
            currentListViewItem = LayoutInflater.from(getContext()).inflate(mLayout, parent, false);
        }

        ViewHolder vh = new ViewHolder(currentListViewItem);

        //Get the Animal object for the current position
        Animal currentAnimal;
        currentAnimal = mAnimals.get(position);

        //Set the attributed of list_view_number_item views
        List<String> icons = currentAnimal.getImages();
        int i = mContext.getResources().getIdentifier(
                icons.get(0), "drawable",
                mContext.getPackageName());

        //Setting the icon
        vh.iconImageView.setImageResource(i);

        vh.nameTextView.setText(currentAnimal.getName());

        vh.breedTextView.setText(currentAnimal.getBreed());

        return currentListViewItem;
    }
}
