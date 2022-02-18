package Abilities;

import java.util.ArrayList;
import java.util.List;

public class EnemyAbility extends Abilities{

    public List<EnemyAtk.PreferedTarget> preferedTargets;
    public int coolDown;
    public int curCooldown;

    public EnemyAbility(String name, Range range, int actionCost, int coolDown) {
        super(name, range, actionCost, coolDown);
        this.coolDown = coolDown;
        preferedTargets = new ArrayList<>();
        curCooldown = 0;
    }
}
