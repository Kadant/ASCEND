package Weapons.Items;

import Abilities.WeaponAtk;
import Characters.AChar;
import Characters.Player;
import General.CombatCalc;
import Weapons.Weapon;

import java.util.List;

public class NagiaArmOfTheSuns extends Weapon {

    CombatCalc cC;

    NagiaArmOfTheSuns() {
        super("Nagia, Arm of the Suns", 6, 2, Handed.TWO, WeaponType.POLEARM);
        passives.put(Passives.BLEEDING, 6);
        statReq.put(AChar.Attribute.STRENGTH, 2);
    }

    WeaponAtk sweep = new WeaponAtk("Sweep", +2, WeaponAtk.Range.REACH, 3, CombatCalc.DmgType.SLASH, List.of(WeaponAtk.Dice.D6));

    int dmg;
    boolean crit;

    public void sweep (Player player, AChar target){
        if (!sweep.missed(player, target)) {
            player.maxAP -= sweep.actionCost;
            dmg = cC.initialDmg(sweep.dmgDices);
            sweep.causeWeaponBleed(passives, dmg, target, 1);
            special(player, target);
            cC.applyCrits(crit, dmg, player.sStats.get(AChar.Stats.CRITDMG));
            cC.afterResistances(target, dmg, sweep.dmgType);
            target.health -= dmg;
        }
    }

    public void special(Player player, AChar target){
        if(target.nStatusStacks(target.bleedStack) >= 2){
            sweep.inflictCondition(CombatCalc.Condition.BURNING, target.burningStack, 1);
        }
        if(target.nStatusStacks(target.burningStack) != 0){
            crit = cC.isCrit(player.sStats.get(AChar.Stats.CRITCHANCE) + 4.0);
        } else{
            crit = cC.isCrit(player.sStats.get(AChar.Stats.CRITCHANCE));
        }
    }
}
