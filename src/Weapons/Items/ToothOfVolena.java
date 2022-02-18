package Weapons.Items;

import Abilities.WeaponAtk;
import Characters.AChar;
import Characters.Player;
import General.CombatCalc;
import Weapons.Weapon;

import java.util.List;

public class ToothOfVolena extends Weapon {

    CombatCalc cC;
    int tempDmg;

    ToothOfVolena() {
        super("Tooth of Volena", 35, 1, Handed.ONE, WeaponType.DAGGER);
        statReq.put(AChar.Attribute.STRENGTH, 2);
        statReq.put(AChar.Attribute.AGILITY, 4);
        passives.put(Passives.BLEEDING, 3);
        passives.put(Passives.DUALWIELD, 0);
        String flavorText = "With his party slaughtered, he fled. Mienar, Idroian slayer of Ydelvra brought nothing home but a single tooth, not the head that was ordered of him. He voued to slay the beast with the very thing that was coated with the blood of his comrades. However, that day would never come. As Volenas whispers grew louder and louder Mienars mind broke.";
    }

    WeaponAtk pierce = new WeaponAtk("Pierce", -1, CombatCalc.Range.ONE, 2, CombatCalc.DmgType.PIERCE, List.of(WeaponAtk.Dice.D6));

    public void pierce(Player player, AChar target) {
        generalAttack(player, target, pierce);
    }

    public void generalAttack(Player player, AChar target, WeaponAtk atk) {
        if (atk.missed(player, target)) {
            tempDmg = cC.initialDmg(atk.dmgDices);
            player.maxAP -= atk.actionCost;
            special (target, atk);
            cC.causeFinalDmg(player, target, tempDmg, atk.dmgType);
        }
    }

    public void special (AChar target, WeaponAtk atk) {
        int nBleeds = target.nStatusStacks(target.bleedStack);
        int nPoison = target.nStatusStacks(target.poisonStack);
        if (nBleeds != 4) {
            atk.causeWeaponBleed(passives, tempDmg, target, 2);
        } else if (nPoison != 3) {
            cC.inflictCondition(CombatCalc.Condition.POISONED, target.poisonStack, 1);
        } else {
            cC.applyConditionDamage(target, CombatCalc.Condition.BLEEDING, target.bleedStack);
            cC.applyConditionDamage(target, CombatCalc.Condition.POISONED, target.bleedStack);
        }
    }
}