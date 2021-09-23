package com.company;

import com.company.objects.Object;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int amount = 1050;
        int endAmount = 1000;

        // --- LEAVES --- //
        Vector<Object> leaf = new Vector<>();
        leaf.add(new Object("Default",50));
        leaf.add(new Object("Pine",30));
        leaf.add(new Object("Spread",10));
        leaf.add(new Object("Palm",10));

        Vector<String> endLeaf = getEnd(leaf,amount);

        // --- SCAMFRUITS --- //
        Vector<Object> scamFruits = new Vector<>();
        scamFruits.add(new Object("Empty",35));
        scamFruits.add(new Object("Apples",15));
        scamFruits.add(new Object("Coconuts",15));
        scamFruits.add(new Object("Bananarama",15));
        scamFruits.add(new Object("Peaches",10));
        scamFruits.add(new Object("Flowers",7));
        scamFruits.add(new Object("X-Mas",3));

        Vector<String> endScamFruits = getEnd(scamFruits, amount);

        // --- ISLANDS --- //
        Vector<Object> islands = new Vector<>();
        islands.add(new Object("type1",50));
        islands.add(new Object("type2",25));
        islands.add(new Object("type3",25));

        Vector<String> endIslands = getEnd(islands, amount);

        // --- DIRT COLORS --- //
        Vector<Object> dirtColors = new Vector<>();
        dirtColors.add(new Object("Brown#8B4513",50));
        dirtColors.add(new Object("DimGray#696969",30));
        dirtColors.add(new Object("Icy#E0FFFF",12));
        dirtColors.add(new Object("OliveDrab#6B8E23",8));

        Vector<String> endDirtColors = getEnd(dirtColors, amount);

        // --- PLANT COLORS --- //
        Vector<Object> plantColors = new Vector<>();
        plantColors.add(new Object("Salmon#FA8072",11));
        plantColors.add(new Object("Crimson#DC143C",7));
        plantColors.add(new Object("DarkRed#8B0000",6));

        plantColors.add(new Object("Lime#32CD32",11));
        plantColors.add(new Object("Green#008000",9));

        plantColors.add(new Object("Teal#008080",11));
        plantColors.add(new Object("Aquamarine#66CDAA",9));

        plantColors.add(new Object("Indigo#4B0082",11));
        plantColors.add(new Object("Orchid#DA70D6",7));
        plantColors.add(new Object("Lime#32CD32",6));

        plantColors.add(new Object("Gold#FF8C00",4));
        plantColors.add(new Object("Silver#A9A9A9",4));
        plantColors.add(new Object("Chocolate#A0522D",4));

        Vector<String> endPlantColors = getEnd(plantColors, amount);

        // --- LEAVES COLORS --- //
        Vector<Object> leavesColors = new Vector<>();
        leavesColors.add(new Object("Salmon#FA8072",11));
        leavesColors.add(new Object("Crimson#DC143C",7));
        leavesColors.add(new Object("DarkRed#8B0000",6));

        leavesColors.add(new Object("Lime#32CD32",11));
        leavesColors.add(new Object("Green#008000",9));

        leavesColors.add(new Object("Teal#008080",11));
        leavesColors.add(new Object("Aquamarine#66CDAA",9));

        leavesColors.add(new Object("Indigo#4B0082",11));
        leavesColors.add(new Object("Orchid#DA70D6",7));
        leavesColors.add(new Object("Lime#32CD32",6));

        leavesColors.add(new Object("Gold#FF8C00",4));
        leavesColors.add(new Object("Silver#A9A9A9",4));
        leavesColors.add(new Object("Chocolate#A0522D",4));

        Vector<String> endLeavesColors = getEnd(leavesColors, amount);

        // --- BACKGROUND COLORS --- //
        Vector<Object> backgroundColors = leavesColors;
        Vector<String> endBackgroundColors  = getEnd(backgroundColors, amount);

        getOutput(endLeaf,endScamFruits,endDirtColors,endPlantColors,endLeavesColors,endBackgroundColors,endIslands,amount,endAmount);
    }

    public static Vector<String> getEnd(Vector<Object> input, int amount){
        Vector<String> end = new Vector<>();

        for(int i=0;i<input.size();i++){
            float howMuch = (input.get(i).getChance() * amount) / 100;
            for (int j=0;j<howMuch;j++){
                end.add(input.get(i).getName());
            }
        }


        for(int i=0;i<input.size();i++)
        Collections.shuffle(end,new Random());
        return end;
    }

    public static void getOutput(Vector<String> endLeaf, Vector<String> endScamFruits,
                                 Vector<String> endDirtColors, Vector<String> endPlantColors,
                                 Vector<String> endLeavesColors,Vector<String> endBackgroundColors,
                                 Vector<String> endIslands,
                                 int amount,int endAmount) {

        try (FileWriter output = new FileWriter("output.txt", false)) {
            Vector<String> outputVec = new Vector<>();
            for (int i=0;i<amount;i++){
                outputVec.add(endLeaf.get(i) + " " + endScamFruits.get(i) + " " + endIslands.get(i) + " " +
                        endDirtColors.get(i) + " " + endPlantColors.get(i) + " " +
                        endLeavesColors.get(i) + " " + endBackgroundColors.get(i));
            }

            LinkedHashSet<String> outputVec2 = new LinkedHashSet<String>( outputVec );

            //clear the vector
            outputVec.clear();

            //add all unique elements back to the vector
            outputVec.addAll(outputVec2);

            int b = 1+1;
            for (int i=0;i<endAmount;i++){
                output.write(outputVec.get(i));
                output.write("\n");
            }

            output.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
