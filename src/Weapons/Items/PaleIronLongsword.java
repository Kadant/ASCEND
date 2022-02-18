package Weapons.Items;
import Abilities.WeaponAtk;
import Characters.AChar;
import Characters.Player;
import General.CombatCalc;
import Weapons.Weapon;


import java.util.List;

public class PaleIronLongsword extends Weapon {

    CombatCalc cC;

    PaleIronLongsword() {
        super("Pale Iron Longsword", 3, 3, Handed.TWO, WeaponType.LONGSWORD);
        statReq.put(AChar.Attribute.STRENGTH, 2);
        passives.put(Passives.BLEEDING, 4);
        String flavorText = "Pale iron, or \"commoners iron\" as its known by Pieniar weaponsmiths is the affordable alternative to Pure and regular iron. It, just as Pure iron isn't actual iron but metal the Pieniar discovered during the Vale Expansion when deposits grew short. To the naked eye it has the appearance its pure counterpart which, in the past had created large trade disputes throughout all of Delman as commoners became rich from selling these dull swords.";
    }

    //@Override
    public void equip(Player player){
        if (player.pStats.get(AChar.Attribute.STRENGTH) >= 2){
            passives.put(Passives.DUALWIELD, 0);
        }
        // Weapon.equip(this, p);
    }

    //Override
    public void unEquip(Player player){
        passives.remove(Passives.DUALWIELD);
        // Weapon.equip(this, player);
    }

    WeaponAtk stab = new WeaponAtk("Stab", -3, WeaponAtk.Range.ONE, 3, CombatCalc.DmgType.PIERCE, List.of(WeaponAtk.Dice.D6));
    WeaponAtk slash = new WeaponAtk("Slash", -2, WeaponAtk.Range.ONE, 3, CombatCalc.DmgType.SLASH, List.of(WeaponAtk.Dice.D6));

    public void stab (Player player, AChar target){
        stab.basicAttack(player, target);
    }

    public void slash (Player player, AChar target){
        slash.basicAttack(player, target);
    }
}
