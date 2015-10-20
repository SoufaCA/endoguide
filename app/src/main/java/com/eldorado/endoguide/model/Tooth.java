package com.eldorado.endoguide.model;

import com.eldorado.endoguide.R;

import java.io.Serializable;

/**
 * Created by msi-pc on 10/11/2015.
 */
public class Tooth implements Serializable {

    private Position position;
    private int minNumberRoots;
    private int maxNumberRoots;
    private String name;
    private String generatedName;

    public Tooth() {
    }

    public Tooth(Position position, int minNumberRoots, int maxNumberRoots, String name) {
        this.position = position;
        this.minNumberRoots = minNumberRoots;
        this.maxNumberRoots = maxNumberRoots;
        this.name = name;
    }

    public String toString() {
        return generatedName;
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

    public String getGeneratedName() {
        return generatedName;
    }

    public void setGeneratedName(String generatedName) {
        this.generatedName = generatedName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tooth)) return false;

        Tooth tooth = (Tooth) o;

        if (getMinNumberRoots() != tooth.getMinNumberRoots()) return false;
        if (getMaxNumberRoots() != tooth.getMaxNumberRoots()) return false;
        if (getPosition() != null ? !getPosition().equals(tooth.getPosition()) : tooth.getPosition() != null)
            return false;
        if (getName() != null ? !getName().equals(tooth.getName()) : tooth.getName() != null)
            return false;
        return !(getGeneratedName() != null ? !getGeneratedName().equals(tooth.getGeneratedName()) : tooth.getGeneratedName() != null);

    }

    @Override
    public int hashCode() {
        int result = getPosition() != null ? getPosition().hashCode() : 0;
        result = 31 * result + getMinNumberRoots();
        result = 31 * result + getMaxNumberRoots();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getGeneratedName() != null ? getGeneratedName().hashCode() : 0);
        return result;
    }
}
