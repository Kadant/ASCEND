package Weapons.Items;
import Abilities.WeaponAtk;
import Characters.AChar;
import Characters.Player;
import General.CombatCalc;
import Weapons.Weapon;

import java.util.List;

public class CommonersDirk extends Weapon {

    CombatCalc cC;

    CommonersDirk() {
        super("Commoners Dirk", 2, 1, Handed.ONE, WeaponType.DAGGER);
        passives.put(Passives.BLEEDING, 3);
        passives.put(Passives.THROWABLE, 0);
        passives.put(Passives.DUALWIELD, -1);
    }

    public void passiveCritIncrease(Player p){
        if(p.pStats.get(AChar.Attribute.AGILITY) > 2){
            p.sStats.put(AChar.Stats.CRITDMG, p.sStats.get(AChar.Stats.CRITDMG) + 1);
        }
    }

    WeaponAtk pierce = new WeaponAtk("Pierce", -1, WeaponAtk.Range.ONE, 2, CombatCalc.DmgType.PIERCE, List.of(WeaponAtk.Dice.D6));

    public void pierce (Player player, AChar target){
        pierce.basicAttackWithBleed(player, target, this, 1);
    }
}
