package Characters;

import java.util.*;

public class IrdrassianFortress extends Enemy{

    IrdrassianFortress() {
        super("Irdrassian Fortress", 2, 1, 0, 12, Family.HUMANOID, Race.HUMAN, EnemyClass.SOLDIER, Region.IRDRAS, 3, 4, 3, 2);
        ArrayList<Loot.T> l1 = new ArrayList<>(
                Arrays.asList(Loot.T.ARMOR, Loot.T.METAL));

        ArrayList<Loot.T> l2 = new ArrayList<>(
                List.of(Loot.T.WEAPON));

        lootTable = new Loot(3,2,3, List.of(add2ToLoot(Loot.T.ARMOR, Loot.T.METAL));
    }
}