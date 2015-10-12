package com.eldorado.endoguide.controllers;

import com.eldorado.endoguide.model.Position;
import com.eldorado.endoguide.model.Quadrant;
import com.eldorado.endoguide.model.Tooth;
import com.eldorado.endoguide.util.EGConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msi-pc on 10/11/2015.
 */
public class DataGenerator {

    private List<Tooth> teeth;

    public void generateTeeth() {
        teeth = new ArrayList<>();

        Quadrant rightMaxillar = new Quadrant(EGConstants.MAXILLAR_ARCADE, EGConstants.POSITION_RIGHT);
        Quadrant leftMaxillar = new Quadrant(EGConstants.MAXILLAR_ARCADE, EGConstants.POSITION_LEFT);
        Quadrant leftMandibular = new Quadrant(EGConstants.MANDIBULAR_ARCADE, EGConstants.POSITION_LEFT);
        Quadrant rightMandibular = new Quadrant(EGConstants.MANDIBULAR_ARCADE, EGConstants.POSITION_RIGHT);

        // 11
        Tooth tooth = new Tooth(new Position(rightMaxillar, 1), 1, 2, "central");
        teeth.add(tooth);

        // 12
        tooth = new Tooth(new Position(rightMaxillar, 2), 1, 2, "lateral");
        teeth.add(tooth);
    }

    public List<Tooth> getTeeth() {
        return teeth;
    }

    public void setTeeth(List<Tooth> teeth) {
        this.teeth = teeth;
    }
}
