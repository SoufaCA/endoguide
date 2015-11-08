package com.eldorado.endoguide.controllers;

import com.eldorado.endoguide.R;
import com.eldorado.endoguide.model.Description;
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
        tooth.getFirstDescriptions().add(new Description("This is a First 1 long long long long long description", R.drawable.ic_11_1));
        tooth.getFirstDescriptions().add(new Description("This is a First 2 test description", R.drawable.ic_logo));
        tooth.getFirstDescriptions().add(new Description("This is a First 3 test description", R.drawable.ic_logo));
        tooth.getFirstDescriptions().add(new Description("This is a First 4 test description", R.drawable.ic_logo));

        tooth.getSecondDescriptions().add(new Description("This is a Second 1 description", R.drawable.ic_logo));
        tooth.getSecondDescriptions().add(new Description("This is a Second 2 test description", R.drawable.ic_logo));

        tooth.getThirdDescriptions().add(new Description("This is a Third 1 description", R.drawable.ic_logo));
        tooth.getThirdDescriptions().add(new Description("This is a Third 2 test description", R.drawable.ic_logo));
        teeth.add(tooth);
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
