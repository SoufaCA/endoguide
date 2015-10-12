package com.eldorado.endoguide.model;

/**
 * Created by msi-pc on 10/11/2015.
 */
public class Tooth {

    private Position position;
    private int minNumberRoots;
    private int maxNumberRoots;
    private String name;

    public Tooth(Position position, int minNumberRoots, int maxNumberRoots, String name) {
        this.position = position;
        this.minNumberRoots = minNumberRoots;
        this.maxNumberRoots = maxNumberRoots;
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getMinNumberRoots() {
        return minNumberRoots;
    }

    public void setMinNumberRoots(int minNumberRoots) {
        this.minNumberRoots = minNumberRoots;
    }

    public int getMaxNumberRoots() {
        return maxNumberRoots;
    }

    public void setMaxNumberRoots(int maxNumberRoots) {
        this.maxNumberRoots = maxNumberRoots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
