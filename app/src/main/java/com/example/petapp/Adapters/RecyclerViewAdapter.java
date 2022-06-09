package com.example.petapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petapp.MainActivity;
import com.example.petapp.Models.Animal;
import com.example.petapp.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Animal> mAnimals;
    private Context mContext;
    private OnAnimalListener mOnAnimalListener;

    public RecyclerViewAdapter(List<Animal> animals, Context context, OnAnimalListener onAnimalListener) {

        this.mAnimals = animals;
        this.mContext = context;
        this.mOnAnimalListener = onAnimalListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_animal_item, parent, false);
        return new ViewHolder(view, mOnAnimalListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Animal currentAnimal;
        currentAnimal = mAnimals.get(position);

        List<String> icons = currentAnimal.getImages();
        int i = mContext.getResources().getIdentifier(
                icons.get(0), "drawable",
                mContext.getPackageName());

        holder.image.setImageResource(i);

        holder.name.setText(currentAnimal.getName());
    }

    @Override
    public int getItemCount() {
        return mAnimals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView name;
        OnAnimalListener onAnimalListener;

        public ViewHolder(@NonNull View itemView, OnAnimalListener onAnimalListener) {
            super(itemView);
            image = itemView.findViewById(R.id.animal_recycler_view_image);
            name = itemView.findViewById(R.id.animal_recycler_view_name);
            this.onAnimalListener = onAnimalListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onAnimalListener.onAnimalClick(getAdapterPosition());
        }
    }

    public interface OnAnimalListener {
        void onAnimalClick(int position);
    }


}
