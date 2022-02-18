package Weapons.Items;

import Abilities.WeaponAtk;
import Characters.AChar;
import Characters.Player;
import General.CombatCalc;
import Weapons.Weapon;

import java.util.List;

public class PillarOfTheMany extends Weapon {

    CombatCalc cC;
    int tempDmg;
    boolean crit;
    PillarOfTheMany() {
        super("Tooth of Volena", 35, 1, Handed.ONE, WeaponType.DAGGER);
        statReq.put(AChar.Attribute.STRENGTH, 2);
        statReq.put(AChar.Attribute.AGILITY, 3);
        statReq.put(AChar.Attribute.INTELLECT, 2);
        passives.put(Passives.BLEEDING, 3);
        passives.put(Passives.THROWABLE, 0);
        String flavorText = "\"Immortality is a curse\" is what Vntal would say had her lungs not be full of sand. Had she not still layed deep beneath the desert lands.";
    }

    WeaponAtk pierce = new WeaponAtk("Pierce", -1, CombatCalc.Range.REACH, 3, CombatCalc.DmgType.PIERCE, List.of(WeaponAtk.Dice.D6));

    public void pierce(Player player, AChar target) {
        pierce.basicAttackWithBleedOnCrit(player, target, 2, pierce.isCrit(player.sStats.get(AChar.Stats.CRITCHANCE)));
    }

    /*
    public double special(Player player){
        double newCritChance = 0;
        if(equipped && ch.sStats.get(AChar.Stats.CRITCHANCE) > ch.pStats.get(AChar.Attribute.AGILITY) / 2.5){
            newCritChance = ch.sStats.get(AChar.Stats.CRITCHANCE) * 2;
        }
    return newCritChance;
    }
    */
}