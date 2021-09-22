package com.company;

import com.company.objects.Object;

import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        int amount = 10;

        // --- LEAVES --- //
        Vector<Object> leaf = new Vector<>();
        leaf.add(new Object("Default",50));
        leaf.add(new Object("Pine",30));
        leaf.add(new Object("Spread",10));
        leaf.add(new Object("Palm",10));

        Vector<String> endLeaf = new Vector<>();
        endLeaf = getEnd(leaf,amount);

        // --- SCAMFRUITS --- //
        Vector<Object> scamFruits = new Vector<>();
        scamFruits.add(new Object("Empty",35));
        scamFruits.add(new Object("Apples",15));
        scamFruits.add(new Object("Coconuts",15));
        scamFruits.add(new Object("Bananarama",15));
        scamFruits.add(new Object("Peaches",10));
        scamFruits.add(new Object("Flowers",7));
        scamFruits.add(new Object("X-Mas",3));

        Vector<String> endScamFruits = new Vector<>();
        endScamFruits = getEnd(scamFruits, amount);

        // --- DIRT COLORS --- //
        Vector<Object> dirtColors = new Vector<>();
        dirtColors.add(new Object("Brown#8B4513",50));
        dirtColors.add(new Object("DimGray#696969",30));
        dirtColors.add(new Object("Icy#E0FFFF",12));
        dirtColors.add(new Object("OliveDrab#6B8E23",8));

        Vector<String> endDirtColors = new Vector<>();
        endDirtColors = getEnd(dirtColors, amount);

        // --- PLANT COLORS --- //
        Vector<Object> plantColors = new Vector<>();
        plantColors.add(new Object("Salmon##FA8072",100));
        plantColors.add(new Object("Crimson#DC143C",100));
        plantColors.add(new Object("DarkRed#8B0000",100));

        plantColors.add(new Object("Lime#32CD32",100));
        plantColors.add(new Object("Green#008000",100));

        plantColors.add(new Object("Teal#008080",100));
        plantColors.add(new Object("Aquamarine#66CDAA",100));

        plantColors.add(new Object("Indigo#4B0082",100));
        plantColors.add(new Object("Orchid#DA70D6",100));
        plantColors.add(new Object("Lime#32CD32",100));

        plantColors.add(new Object("Gold#FF8C00",100));
        plantColors.add(new Object("Silver#A9A9A9",100));
        plantColors.add(new Object("Chocolate#A0522D",100));
    }

    public static Vector<String> getEnd(Vector<Object> input, int amount){
        Vector<String> end = new Vector<>();

        for(int i=0;i<input.size();i++){
            float howMuch = (input.get(i).getChance() * amount) / 100;
            for (int j=0;j<howMuch;j++){
                end.add(input.get(i).getName());
            }
        }

        Collections.shuffle(end,new Random());
        return end;
    }
}
