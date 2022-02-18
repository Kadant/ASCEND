package Battlefield.Terrains;

import Battlefield.Gatherables.BailenWeed;
import Battlefield.Terrain;

import java.util.List;

public class MuddySwamp extends Terrain {

    /**
           *   *   *
         *   *   *   *
       *   *   *   *   *
     *   *   *   *   *   *
       *   *   *   *   *
         *   *   *   *
           *   *   *
     */


    public MuddySwamp(String name, Formation form) {
        super("Muddy Swamp", Formation.HEXAGON);
        tiles = List.of(wet, wet, wet,
                wet, water, water, tar,
                wet, wet, water, water, tree,
                wet, tree, tar, water, water, tar,
                wet, water, water, water, tar,
                tar, water, water, wet,
                wet, wet, wet);
        giveTilesPosition(form);
        gatherable = List.of(new BailenWeed());
    }

    /*
    public void lowerAgilityChecks{
        StatChecks.agilityCheck -= 1;
    }
     */
}