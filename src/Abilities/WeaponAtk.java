package Abilities;

import Characters.AChar;
import Characters.Player;
import Weapons.Weapon;

import java.util.HashMap;
import java.util.List;

public class WeaponAtk extends Attacks {

    public int maxDmg;

    public WeaponAtk(String name, int diceDmgAlteration, Range range, int actionCost, DmgType dmgType, List<Dice> dmgDices) {
        super(name, diceDmgAlteration, range, actionCost, dmgType, dmgDices);
        maxDmg = maxDamage(this);
    }

    public void basicAttackWithBleed(Player player, AChar target, Weapon weapon, int stacks){
        if (missed(player, target)) {
            player.maxAP -= actionCost;
            int dmg = initialDmg(dmgDices);
            causeWeaponBleed(weapon.passives, dmg, target, stacks);
            causeFinalDmg(player, target, dmg, dmgType);
        }
    }

    public void basicAttackWithBleedOnCrit(Player player, AChar target, int stacks, boolean isCrit){
        if (missed(player, target)) {
            player.maxAP -= actionCost;
            int tempDmg = initialDmg(dmgDices);
            bleedOnCrit(target, stacks, isCrit);
            applyCrits(isCrit, tempDmg, player.sStats.get(AChar.Stats.CRITDMG));
            afterResistances(target, tempDmg, dmgType);
            target.health -= tempDmg;
        }
    }

    public void bleedOnCrit(AChar target, int stacks, boolean isCrit){
        if(isCrit){
            inflictCondition(Condition.BLEEDING, target.bleedStack, stacks);
        }
    }

    public void causeWeaponBleed(HashMap<Weapon.Passives, Integer> passives, int dmg, AChar target, int stacks) {
        if (passives.containsKey(Weapon.Passives.BLEEDING) && dmg >= passives.get(Weapon.Passives.BLEEDING)) {
            inflictCondition(Condition.BLEEDING, target.bleedStack, stacks);
        }
    }
}