package Characters;

import Abilities.EnemyAbility;
import Abilities.EnemyAtk;
import Battlefield.Terrain;
import General.CombatCalc;
import Abilities.WeaponAtk;

import java.util.List;

public class RydonianRogue extends Enemy {

    EnemyAtk pitchforkJab;
    EnemyAbility shadowStep;

    RydonianRogue() {
        super("Rydonian Rogue", 1, 1, 2, 5, Family.HUMANOID, Race.HUMAN, EnemyClass.ROGUE, Region.IRDRAS, 2, 3, 1);
        resistances.put(CombatCalc.DmgType.PIERCE, 1);
        pitchforkJab = new EnemyAtk("Pitchfork Jab", -3, CombatCalc.Range.ONE, 2, CombatCalc.DmgType.PIERCE, List.of(WeaponAtk.Dice.D6), 0);
        pitchforkJab.preferedTargets.add(EnemyAtk.PreferedTarget.LOWESTHEALTH);
        pitchforkJab.preferedTargets.add(EnemyAtk.PreferedTarget.CLOSEST);
        shadowStep = new EnemyAbility("Shadowstep", CombatCalc.Range.ANY,1,2);
        shadowStep.preferedTargets.add(EnemyAtk.PreferedTarget.LOWESTHEALTH);
    }

    public void pitchforkJab(AChar target) {
        pitchforkJab.basicAttack(this, target);
    }

    public void shadowStep(Terrain field){

    }
}
