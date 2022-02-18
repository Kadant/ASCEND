package Weapons.Items;
import Abilities.WeaponAtk;
import Characters.AChar;
import Characters.Player;
import General.CombatCalc;
import Weapons.Weapon;

import java.util.List;

public class AmuladDoomOfElendal extends Weapon {

    CombatCalc cC;
    int tempDmg;
    boolean tempCrit;

    AmuladDoomOfElendal() {
        super("Amulad, Doom of Elendal", 40, 4, Handed.TWO, WeaponType.WARHAMMER);
        statReq.put(AChar.Attribute.STRENGTH, 4);
    }

    WeaponAtk bash = new WeaponAtk("Bash", 0, WeaponAtk.Range.REACH, 4, CombatCalc.DmgType.BLUNT, List.of(WeaponAtk.Dice.D6, WeaponAtk.Dice.D6));
    WeaponAtk slash = new WeaponAtk("Decay", -2, WeaponAtk.Range.REACH, 4, CombatCalc.DmgType.DECAY, List.of(WeaponAtk.Dice.D6, WeaponAtk.Dice.D6));

    public void bash(Player player, AChar target) {
        generalAttack(player, target, bash);
    }

    public void slash (Player player, AChar target){
        generalAttack(player, target, slash);
    }

    public void generalAttack(Player player, AChar target, WeaponAtk atk){
        if (!atk.missed(player, target)) {
            player.maxAP -= atk.actionCost;
            tempDmg = cC.initialDmg(atk.dmgDices);
            cC.applyCrits(tempCrit, tempDmg, player.sStats.get(AChar.Stats.CRITDMG));
            special(target, atk);
            target.health -= tempDmg;
        } else {
            reduceAC(atk);
            // Only during next turn
        }
    }

    public void special(AChar target, WeaponAtk atk){
        if (target.race != AChar.Family.WILDLIFE){
            cC.afterResistances(target, tempDmg, atk.dmgType);
        }
    }

    public void reduceAC(WeaponAtk atk){
        atk.actionCost -= 2;
        if (atk.actionCost <= 0){
            atk.actionCost = 1;
        }
    }
}
