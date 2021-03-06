package com.company.objects;

public class Object {
    private String name; // Pine
    private float chance; // 0.2

    public Object(String name, float chance) {
        this.name = name;
        this.chance = chance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getChance() {
        return chance;
    }

    public void setChance(float chance) {
        this.chance = chance;
    }
}
