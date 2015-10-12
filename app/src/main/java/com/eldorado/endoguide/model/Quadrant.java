package com.eldorado.endoguide.model;

import com.eldorado.endoguide.util.EGConstants;

/**
 * Created by msi-pc on 10/11/2015.
 */
public class Quadrant {
    private String arcade;
    private String position;

    public Quadrant() {
        arcade = EGConstants.MANDIBULAR_ARCADE;
        position = EGConstants.POSITION_LEFT;
    }

    public Quadrant(String arcade, String position) {
        this.arcade = arcade;
        this.position = position;
    }

    public String getArcade() {
        return arcade;
    }

    public void setArcade(String arcade) {
        this.arcade = arcade;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quadrant)) return false;

        Quadrant quadrant = (Quadrant) o;

        if (getArcade() != null ? !getArcade().equals(quadrant.getArcade()) : quadrant.getArcade() != null)
            return false;
        return !(getPosition() != null ? !getPosition().equals(quadrant.getPosition()) : quadrant.getPosition() != null);

    }

    @Override
    public int hashCode() {
        int result = getArcade() != null ? getArcade().hashCode() : 0;
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        return result;
    }
}
