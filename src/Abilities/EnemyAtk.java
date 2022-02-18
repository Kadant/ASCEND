package Abilities;

import java.util.ArrayList;
import java.util.List;

public class EnemyAtk extends Attacks {

    public List<PreferedTarget> preferedTargets;
    public int coolDown;
    public int curCooldown;

    public EnemyAtk(String name, int diceDmgAlteration, Range range, int actionCost, DmgType dmgType, List<Dice> dmgDices, int coolDown) {
        super(name, diceDmgAlteration, range, actionCost, dmgType, dmgDices);
        this.coolDown = coolDown;
        preferedTargets = new ArrayList<>();
        curCooldown = 0;
    }

    public enum PreferedTarget{
        CLOSEST,
        LOWESTHEALTH
    }

    public void triggerCooldown(EnemyAtk atk){
        curCooldown = coolDown;
    }
}
