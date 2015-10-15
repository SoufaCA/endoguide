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
        teeth.add(new Tooth(new Position(rightMaxillar, 1), 1, 2, "central"));
        // 12
        teeth.add(new Tooth(new Position(rightMaxillar, 2), 1, 2, "lateral"));
        // 13
        teeth.add(new Tooth(new Position(rightMaxillar, 3), 1, 2, "cuspid"));
        // 14
        teeth.add(new Tooth(new Position(rightMaxillar, 4), 1, 2, "premolar_1"));
        // 15
        teeth.add(new Tooth(new Position(rightMaxillar, 5), 1, 2, "premolar_2"));
        // 16
        teeth.add(new Tooth(new Position(rightMaxillar, 6), 1, 2, "molar_1"));
        // 17
        teeth.add(new Tooth(new Position(rightMaxillar, 7), 1, 2, "molar_2"));
        // 18
        teeth.add(new Tooth(new Position(rightMaxillar, 8), 1, 2, "molar_3"));
    }

    public List<Tooth> getTeeth() {
        return teeth;
    }

    public void setTeeth(List<Tooth> teeth) {
        this.teeth = teeth;
    }
}
