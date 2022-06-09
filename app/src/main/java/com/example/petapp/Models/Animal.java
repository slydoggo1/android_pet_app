package com.example.petapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Animal implements Parcelable {

    String type;
    String name, breed, trait1, trait2;
    int age, viewCount;
    List<String> images;

    public Animal(String name, String breed, int age, String trait1, String trait2, int viewCount, List<String> images, String type) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.trait1 = trait1;
        this.trait2 = trait2;
        this.viewCount = viewCount;
        this.images = images;
        this.type = type;
    }

    protected Animal(Parcel in) {
        name = in.readString();
        breed = in.readString();
        trait1 = in.readString();
        trait2 = in.readString();
        age = in.readInt();
        viewCount = in.readInt();
        images = in.createStringArrayList();
        type = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getTrait1() {
        return trait1;
    }

    public String getTrait2() {
        return trait2;
    }

    public int getViewCount() {
        return viewCount;
    }

    public List<String> getImages() {
        return images;
    }

    public String getType() {
        return type;
    }

    public void updateViewCount() {
        viewCount = viewCount + 1;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(breed);
        dest.writeString(trait1);
        dest.writeString(trait2);
        dest.writeInt(age);
        dest.writeInt(viewCount);
        dest.writeStringList(images);
        dest.writeString(type);
    }
}
