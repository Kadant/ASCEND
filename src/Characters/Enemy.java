package Characters;

import java.util.*;

public class Enemy extends AChar {

    public enum Region{
        IRDRAS
    }

    Region region;
    int expOnKill;
    int nLootDrawsOnKill;
    EnemyClass eClass;
    int initiative;
    Loot lootTable;

    Enemy(String name, int str, int intel, int agil, int health, Family family, Race race, EnemyClass eClass, Region region, int expOnKill, int maxAP, int nLootDrawsOnKill, int initiative) {
        super(name, str, intel, agil, health, family, race);
        this.initiative = initiative;
        this.region = region;
        this.expOnKill = expOnKill;
        this.maxAP = maxAP;
        this.nLootDrawsOnKill =  nLootDrawsOnKill;
        this.eClass = eClass;
    }

    public ArrayList<Loot.T> add3ToLoot(Loot.T t1, Loot.T t2, Loot.T t3){
        return new ArrayList<>(Arrays.asList(t1, t2, t3));
    }

    public ArrayList<Loot.T> add2ToLoot(Loot.T t1, Loot.T t2){
        return new ArrayList<>(Arrays.asList(t1, t2));
    }

    public ArrayList<Loot.T> add1ToLoot(Loot.T t1){
        return new ArrayList<>(List.of(t1));
    }
}