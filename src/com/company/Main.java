package com.company;

import com.company.objects.Object;

import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        int amount = 10;

        Vector<Object> leaf = new Vector<>();
        leaf.add(new Object("Default",50));
        leaf.add(new Object("Pine",30));
        leaf.add(new Object("Spread",10));
        leaf.add(new Object("Palm",10));

        Vector<String> endLeaf = new Vector<>();
        endLeaf = getEnd(leaf,amount);


        int b = 1 + 1;
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
