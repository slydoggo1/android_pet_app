package com.example.petapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.petapp.Models.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;

public class DataProvider {

    //static String[] catNames = {"Luna", "Milo", "Oliver", "Leo", "Loki", "Bella", "Charlie", "Willow", "Lucy", "Simba"};

    //static String[] catBreeds = {"Short Hair", "Scottish Fold", "Maine Coon", "Persian", "Ragdoll", "Birman"};

    static String[] catTraits = {"Very playful and energetic", "Shy around kids", "Sociable around other animals", "Hunts mice", "Loves being outdoors",
            "Sleeps on your bed", "Always hungry", "Quiet and gentle", "Cute meow", "Enjoys attacking legs",
            "Loves lying on keyboards"};

    static String[] dogTraits = {"Very affectionate with family", "Friendly with kids", "Friendly with other pets", "Knows many tricks and is easy to train",
            "Enjoys walks and running in the park", "Doesn't mind being alone", "Very needy and seeks attention", "Very playful and energetic",
            "Loyal to a fault", "Enjoys sleeping with you"};

    static String[] rabbitTraits = {"Quite timid and shy", "Will go after your cables", "Very curious", "Sociable and loves to play", "Calm and docile",
            "Loves cuddles and pats", "Loves attention", "Gets bored easily", "Aggressive and energetic",
            "Enjoys spending time with their owner"};

    private static List<Animal> catList;
    private static List<Animal> dogList;
    private static List<Animal> rabbitList;


    public static Map<String, String> generateCats() {
        Map<String, String> catNames = new LinkedHashMap<>();
        catNames.put("Luna", "Short Hair");
        catNames.put("Milo", "Scottish Fold");
        catNames.put("Oliver", "Short Hair");
        catNames.put("Leo", "Maine Coon");
        catNames.put("Loki", "Persian");
        catNames.put("Bella", "Short Hair");
        catNames.put("Charlie", "Ragdoll");
        catNames.put("Willow", "Maine Coon");
        catNames.put("Lucy", "Persian");
        catNames.put("Lily", "Short Hair");

        return catNames;
    }

    public static Map<String, String> generateDogs() {
        Map<String, String> dogNames = new LinkedHashMap<>();
        dogNames.put("Max", "German Shepherd");
        dogNames.put("Bailey", "Golden Retriever");
        dogNames.put("Daisy", "Beagle");
        dogNames.put("Lola", "Corgi");
        dogNames.put("Jax", "Samoyed");
        dogNames.put("Chloe", "Samoyed");
        dogNames.put("Cooper", "Shiba Inu");
        dogNames.put("Roxy", "Corgi");
        dogNames.put("Coco", "German Shepherd");
        dogNames.put("Bandit", "Samoyed");

        return dogNames;
    }

    public static Map<String, String> generateRabbits() {
        Map<String, String> rabbitNames = new LinkedHashMap<>();
        rabbitNames.put("Thumper", "Californian");
        rabbitNames.put("Oreo", "Lop Eared");
        rabbitNames.put("Angel", "Lop Eared");
        rabbitNames.put("Nibbles", "Californian");
        rabbitNames.put("Hops", "Lop Eared");
        rabbitNames.put("Harry", "Rex");
        rabbitNames.put("Zoe", "Lop Eared");
        rabbitNames.put("Ella", "Rex");
        rabbitNames.put("Cookie", "Crossbreed");
        rabbitNames.put("Buck", "Flemish Giant");

        return rabbitNames;
    }

    public static void generateCatInfo() {
        List<Animal> catsList = new LinkedList<Animal>();
        Map<String, String> cats = generateCats();
        //Map<String, List<String>> catImages = generateCatImages();

        for (String key : cats.keySet()) {
            String name = key;
            String breed = cats.get(key);
            int age = (int) Math.floor(Math.random() * (10 - 2 + 1) + 2);
            int viewCount = (int) Math.floor(Math.random() * 3);
            String trait1 = catTraits[(int) Math.floor(Math.random() * 11)];
            String trait2 = trait1;
            while (trait2 == trait1) {
                trait2 = catTraits[(int) Math.floor(Math.random() * 11)];
            }
            List<String> images = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                images.add(i, key.toLowerCase() + String.valueOf(i + 1));
            }
            String type = "Cat";

            Animal c = new Animal(name, breed, age, trait1, trait2, viewCount, images, type);
            catsList.add(c);
        }

        catList = catsList;
    }

    public static void generateDogInfo() {
        List<Animal> dogsList = new LinkedList<Animal>();
        Map<String, String> dogs = generateDogs();
        //Map<String, List<String>> dogImages = generateDogImages();
        for (String key : dogs.keySet()) {
            String name = key;
            String breed = dogs.get(key);
            int age = (int) Math.floor(Math.random() * (8 - 2 + 1) + 3);
            int favouriteCount = (int) Math.floor(Math.random() * 3);
            String trait1 = dogTraits[(int) Math.floor(Math.random() * 10)];
            String trait2 = trait1;
            while (trait2 == trait1) {
                trait2 = dogTraits[(int) Math.floor(Math.random() * 10)];
            }
            List<String> images = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                images.add(i, key.toLowerCase() + String.valueOf(i + 1));
            }
            String type = "Dog";

            Animal c = new Animal(name, breed, age, trait1, trait2, favouriteCount, images, type);
            dogsList.add(c);
        }

        dogList = dogsList;
    }

    public static void generateRabbitInfo() {
        List<Animal> rabbitsList = new LinkedList<Animal>();
        Map<String, String> rabbits = generateRabbits();
        //Map<String, List<String>> dogImages = generateDogImages();
        for (String key : rabbits.keySet()) {
            String name = key;
            String breed = rabbits.get(key);
            int age = (int) Math.floor(Math.random() * (7 - 1 + 1) + 1);
            int favouriteCount = (int) Math.floor(Math.random() * 3);
            String trait1 = rabbitTraits[(int) Math.floor(Math.random() * 10)];
            String trait2 = trait1;
            while (trait2 == trait1) {
                trait2 = rabbitTraits[(int) Math.floor(Math.random() * 10)];
            }
            List<String> images = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                images.add(i, key.toLowerCase() + String.valueOf(i + 1));
            }
            String type = "Rabbit";

            Animal c = new Animal(name, breed, age, trait1, trait2, favouriteCount, images, type);
            rabbitsList.add(c);
        }

        rabbitList = rabbitsList;
    }

    public static List<Animal> getCats() {
        return catList;
    }

    public static List<Animal> getDogs() {
        return dogList;
    }

    public static List<Animal> getRabbits() {
        return rabbitList;
    }

    public static List<Animal> getAllAnimals() {
        List<Animal> animalList = new ArrayList<Animal>();
        animalList.addAll(catList);
        animalList.addAll(dogList);
        animalList.addAll(rabbitList);

//        ArrayList<Animal, Integer> animalFavouriteList = new ArrayList<List<Animal>>();
//
//        Iterator<Animal> iterator = animalList.listIterator();
//
//        while(iterator.hasNext()) {
//            animalFavouriteList.add(iterator.next().getViewCount(), iterator.next());
//        }

        return animalList;
    }

    public static  List<Animal> getSortedList() {

        HashMap<Animal, Integer> fullMap = new LinkedHashMap<>();
        List<Animal> fullList = new ArrayList<Animal>();
        fullList = getAllAnimals();
        //ListIterator<Animal> iterator = fullList.listIterator();
        ArrayList<Integer> highest_five = new ArrayList<Integer>();
        int min_seen = 0;

        for (int i = 0; i < fullList.size(); i++) {
            if (i < 5) {
                fullMap.put(fullList.get(i), fullList.get(i).getViewCount());
                highest_five.add(fullList.get(i).getViewCount());
            } else {
                Collections.sort(highest_five);
                min_seen = highest_five.get(0);
                if (fullList.get(i).getViewCount() > min_seen) {
                    for (Map.Entry<Animal, Integer> entry : fullMap.entrySet()) {
                        if (entry.getValue() == min_seen) {
                            fullMap.remove(entry.getKey());
                            fullMap.put(fullList.get(i), fullList.get(i).getViewCount());

                            highest_five.remove(0);
                            highest_five.add(fullList.get(i).getViewCount());
                            break;
                        }
                    }
                }
            }
        }

        List<Map.Entry<Animal, Integer>> list = new LinkedList<Map.Entry<Animal, Integer>>(fullMap.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Animal, Integer> >() {
            public int compare(Map.Entry<Animal, Integer> o1,
                               Map.Entry<Animal, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Animal, Integer> temp = new LinkedHashMap<Animal, Integer>();
        for (Map.Entry<Animal, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }


        List<Animal> sortedList = new LinkedList<>();


        for (Map.Entry<Animal, Integer> entry : temp.entrySet()) {
            sortedList.add(entry.getKey());
        }

        Collections.reverse(sortedList);

        return sortedList;
    }

}

