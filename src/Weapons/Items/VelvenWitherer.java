package Weapons.Items;

import Abilities.WeaponAtk;
import Characters.AChar;
import Characters.Player;
import General.CombatCalc;
import Weapons.Weapon;

import java.util.List;

public class VelvenWitherer extends Weapon {

    VelvenWitherer() {
            super("Velven Witherer", 4, 2, Handed.MAIN, WeaponType.DAGGER);
    }

    WeaponAtk pierce = new WeaponAtk("Hack", -2, CombatCalc.Range.ONE, 2, CombatCalc.DmgType.PIERCE, List.of(WeaponAtk.Dice.D6));

    public void pierce (Player player, AChar target){
        pierce.basicAttack(player, target);
    }
}

    /** Any bush-tiles hit by Velven Witherer are turned into plain-tiles. */