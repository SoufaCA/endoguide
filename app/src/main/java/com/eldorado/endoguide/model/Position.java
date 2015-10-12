package com.eldorado.endoguide.model;

import com.eldorado.endoguide.util.EGConstants;

/**
 * Created by msi-pc on 10/11/2015.
 */
public class Position {
    private Quadrant quadrant;
    private int index;

    public Position(Quadrant quadrant, int index) {
        this.quadrant = quadrant;
        this.index = index;
    }

    public Position() {
        this.quadrant = new Quadrant();
        this.index = EGConstants.DEFAULT_INDEX;
    }

    public Quadrant getQuadrant() {
        return quadrant;
    }

    public void setQuadrant(Quadrant quadrant) {
        this.quadrant = quadrant;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPosition() {

        int result = 0;

        if (quadrant.equals(new Quadrant(EGConstants.MANDIBULAR_ARCADE, EGConstants.POSITION_LEFT))) {
            result = 3;
        } else if (quadrant.equals(new Quadrant(EGConstants.MANDIBULAR_ARCADE, EGConstants.POSITION_RIGHT))) {
            result = 4;
        } else if (quadrant.equals(new Quadrant(EGConstants.MAXILLAR_ARCADE, EGConstants.POSITION_LEFT))) {
            result = 2;
        } else if (quadrant.equals(new Quadrant(EGConstants.MAXILLAR_ARCADE, EGConstants.POSITION_RIGHT))) {
            result = 1;
        }

        return result;
    }
}
