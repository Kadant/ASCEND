package Characters;

import java.util.ArrayList;
import java.util.List;

public class Loot {

    public enum T {
        COMMON, RARE, EPIC, ARMOR, WEAPON, POTION, QUEST, METAL, CLOTH, LEATHER, HEAD, HANDS
    }

    public int nDraws;
    public int nTakes;
    public int value;
    public List<ArrayList<T>> lootTypes;

    public Loot(int nDraws, int nTakes, int value, List<ArrayList<T>> lootTypes) {
        this.nDraws = nDraws;
        this.nTakes = nTakes;
        this.value = value;
        this.lootTypes = lootTypes;
    }


}