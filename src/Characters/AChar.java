package Characters;

import General.CombatCalc;

import java.security.PublicKey;
import java.util.HashMap;

abstract public class AChar {

    public enum Attribute {
        STRENGTH,
        INTELLECT,
        AGILITY
    }

    public enum Stats {
        CRITDMG,
        CRITCHANCE,
        DODGECHANCE,
        HITCHANCE
    }

    public enum Family{
        HUMANOID,
        WILDLIFE
    }

    public enum Race{
        HUMAN
    }

    public enum EnemyClass{
        ROGUE,
        SOLDIER
    }

    public int health;
    public int[] bleedStack;
    public int[] poisonStack;
    public int[] burningStack;
    public HashMap<Attribute, Integer> pStats = new HashMap<>();
    public HashMap<Stats, Double> sStats = new HashMap<>();
    public int maxAP;
    public HashMap<CombatCalc.DmgType, Integer> resistances = new HashMap<>();
    public Family family;
    public Race race;
    public String name;

    AChar(String name, int str, int intel, int agil, int health, Family family, Race race) {
        this.name = name;
        this.health = health;
        this.family = family;
        this.race = race;

        pStats.put(Attribute.STRENGTH, str);
        pStats.put(Attribute.INTELLECT, intel);
        pStats.put(Attribute.AGILITY, agil);

        sStats.put(Stats.CRITDMG, agil * 10.0);
        sStats.put(Stats.CRITCHANCE, agil / 2.5);
        sStats.put(Stats.DODGECHANCE, agil / 2.0);
        sStats.put(Stats.HITCHANCE, 100.0);

        bleedStack = new int[]{0, 0, 0, 0};
        poisonStack = new int[]{0, 0, 0};
        burningStack = new int[]{0, 0};
    }

    public int nStatusStacks(int[] statusStack){
        int n = 0;
        for (int i : statusStack) {
            if (i != 0) {
                n++;
            }
        }
        return n;
    }
}
