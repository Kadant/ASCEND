package Weapons.Items;

import Abilities.WeaponAtk;
import Characters.AChar;
import Characters.Player;
import General.CombatCalc;
import Weapons.Weapon;

import java.util.List;

public class ValinShortSword extends Weapon {

    CombatCalc cC;

    ValinShortSword() {
        super("Valin Short-sword", 3, 1, Handed.MAIN, WeaponType.SWORD);
        statReq.put(AChar.Attribute.STRENGTH, 1);
        passives.put(Passives.BLEEDING, 3);
        passives.put(Passives.THROWABLE, -1);
    }

    WeaponAtk stab = new WeaponAtk("Stab", -3, WeaponAtk.Range.ONE, 2, CombatCalc.DmgType.PIERCE, List.of(WeaponAtk.Dice.D6));
    WeaponAtk slash = new WeaponAtk("Slash", -4, WeaponAtk.Range.ONE, 2, CombatCalc.DmgType.SLASH, List.of(WeaponAtk.Dice.D6));

    //@Override
    public void equip(Player player){
        if (player.pStats.get(AChar.Attribute.STRENGTH) >= 2){
            passives.put(Passives.DUALWIELD, 0);
        }
        // Weapon.equip(this, player);
    }

    //Override
    public void unEquip(Player player){
        passives.remove(Passives.DUALWIELD);
        // Weapon.equip(this, player);
    }

    public void stab (Player player, AChar target){
        stab.basicAttack(player, target);
    }

    public void slash (Player player, AChar target){
        slash.basicAttack(player, target);
    }
}
