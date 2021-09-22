package com.company;

import com.company.objects.Leaf;

import java.util.Collections;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        int amount = 10;

        Vector<Leaf> leaf = new Vector<>();
        leaf.add(new Leaf("Default",50));
        leaf.add(new Leaf("Pine",30));
        leaf.add(new Leaf("Spread",10));
        leaf.add(new Leaf("Palm",10));

        Vector<String> endLeaf = new Vector<>();

        for(int i=0;i<leaf.size();i++){
            float howMuch = (leaf.get(i).getChance() * amount) / 100;
            for (int j=0;j<howMuch;j++){
                endLeaf.add(leaf.get(i).getName());
            }
        }

        Collections.shuffle(endLeaf,new Random());

        int b = 1 + 1;
    }
}
