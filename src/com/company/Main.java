package com.company;

import com.company.objects.Object;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int amount = 2000;
        int endAmount = 1000;

        // --- LEAVES --- //
        List<Object> leaf = new ArrayList<>();
        leaf.add(new Object("Default",51));
        leaf.add(new Object("Pine",24));
        leaf.add(new Object("Spread",12));
        leaf.add(new Object("Palm",13));

        List<String> endLeaf = getEnd(leaf,amount);

        // --- SCAMFRUITS --- //
        List<Object> scamFruits = new ArrayList<>();
        scamFruits.add(new Object("Empty",35));
        scamFruits.add(new Object("Apples",19));
        scamFruits.add(new Object("Coconuts",14));
        scamFruits.add(new Object("Bananarama",12));
        scamFruits.add(new Object("Peaches",10));
        scamFruits.add(new Object("Flowers",7));
        scamFruits.add(new Object("X-Mas",3));

        List<String> endScamFruits = getEnd(scamFruits, amount);

        // --- ISLANDS --- //
        List<Object> islands = new ArrayList<>();
        islands.add(new Object("type1",61));
        islands.add(new Object("type2",25));
        islands.add(new Object("type3",14));

        List<String> endIslands = getEnd(islands, amount);

        // --- DIRT COLORS --- //
        List<Object> dirtColors = new ArrayList<>();
        dirtColors.add(new Object("Brown#8B4513",57));
        dirtColors.add(new Object("DimGray#696969",23));
        dirtColors.add(new Object("Icy#E0FFFF",12));
        dirtColors.add(new Object("OliveDrab#6B8E23",8));

        List<String> endDirtColors = getEnd(dirtColors, amount);

        // --- PLANT COLORS --- //
        List<Object> plantColors = new ArrayList<>();
        plantColors.add(new Object("Salmon#FA8072",11));
        plantColors.add(new Object("Crimson#DC143C",7));
        plantColors.add(new Object("DarkRed#8B0000",6));

        plantColors.add(new Object("Green#008000",20));

        plantColors.add(new Object("Teal#008080",11));
        plantColors.add(new Object("Aquamarine#66CDAA",9));

        plantColors.add(new Object("Indigo#4B0082",11));
        plantColors.add(new Object("Orchid#DA70D6",7));
        plantColors.add(new Object("Lime#32CD32",6));

        plantColors.add(new Object("Gold#FF8C00",4));
        plantColors.add(new Object("Silver#A9A9A9",4));
        plantColors.add(new Object("Chocolate#A0522D",4));

        List<String> endPlantColors = getEnd(plantColors, amount);

        // --- LEAVES COLORS --- //
        List<Object> leavesColors = new ArrayList<>();
        leavesColors.add(new Object("Salmon#FA8072",11));
        leavesColors.add(new Object("Crimson#DC143C",7));
        leavesColors.add(new Object("DarkRed#8B0000",6));

        leavesColors.add(new Object("Green#008000",20));

        leavesColors.add(new Object("Teal#008080",11));
        leavesColors.add(new Object("Aquamarine#66CDAA",9));

        //BlueViolet 8A2BE2
        leavesColors.add(new Object("Indigo#4B0082",11));
        leavesColors.add(new Object("Orchid#DA70D6",7));
        leavesColors.add(new Object("Lime#32CD32",6));

        leavesColors.add(new Object("Gold#FF8C00",4));
        leavesColors.add(new Object("Silver#A9A9A9",4));
        leavesColors.add(new Object("Chocolate#A0522D",4));// 89

        List<String> endLeavesColors = getEnd(leavesColors, amount);

        // --- BACKGROUND COLORS --- //
        List<Object> backgroundColors = new ArrayList<>();
        backgroundColors.add(new Object("PeachPuff#FFDAB9",20));
        backgroundColors.add(new Object("Teal#008080",17));
        backgroundColors.add(new Object("Aquamarine#66CDAA",32));

        //backgroundColors.add(new Object("Salmon#FA8072",11));
        //backgroundColors.add(new Object("Crimson#DC143C",7));

        backgroundColors.add(new Object("Plum#DDA0DD",20));


        backgroundColors.add(new Object("Orchid#DA70D6",7));
        backgroundColors.add(new Object("Lime#32CD32",3));
        backgroundColors.add(new Object("Black#000000",1));
        //backgroundColors.add(new Object("Gold#FF8C00",4)); поменять на нормальный золотой, монотонный цвет не работает
        //backgroundColors.add(new Object("Silver#A9A9A9",4)); сейм
        List<String> endBackgroundColors  = getEnd(backgroundColors, amount);

        getOutput(endLeaf,endScamFruits,endDirtColors,endPlantColors,endLeavesColors,endBackgroundColors,endIslands,amount,endAmount);
    }

    public static List<String> getEnd(List<Object> input, int amount){
        List<String> end = new ArrayList<>();

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

    public static void getOutput(List<String> endLeaf, List<String> endScamFruits,
                                 List<String> endDirtColors, List<String> endPlantColors,
                                 List<String> endLeavesColors,List<String> endBackgroundColors,
                                 List<String> endIslands,
                                 int amount,int endAmount) {

        try (FileWriter output = new FileWriter("output.txt", false)) {
            List<String> outputVec = new ArrayList<>();
            for (int i=0;i<amount;i++){
                outputVec.add(endLeaf.get(i) + " " + endScamFruits.get(i) + " " + endIslands.get(i) + " " +
                        endDirtColors.get(i) + " " + endPlantColors.get(i) + " " +
                        endLeavesColors.get(i) + " " + endBackgroundColors.get(i));
            }

            LinkedHashSet<String> outputVec2 = new LinkedHashSet<String>( outputVec );

            //clear the List
            outputVec.clear();

            //add all unique elements back to the List
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
