package Weapons.Items;
import Abilities.WeaponAtk;
import Characters.AChar;
import Characters.Player;
import General.CombatCalc;
import Weapons.Weapon;

import java.util.List;

public class ArmOfElenad extends Weapon {

    CombatCalc cC;
    int tempDmg;
    boolean tempCrit;

    ArmOfElenad() {
        super("Arm of Elenad", 27, 3, Handed.TWO, WeaponType.STAFF);
        statReq.put(AChar.Attribute.STRENGTH, 3);
        statReq.put(AChar.Attribute.INTELLECT, 3);
        String flavorText = "The voice that spoke to nature echoes";
    }

    WeaponAtk bash = new WeaponAtk("Bash", -2, CombatCalc.Range.INTELLECT, 4, CombatCalc.DmgType.BLUNT, List.of(WeaponAtk.Dice.D6));
    WeaponAtk mind = new WeaponAtk("Mind", -2, CombatCalc.Range.INTELLECT, 4, CombatCalc.DmgType.MIND, List.of(WeaponAtk.Dice.D6));

    public void bashAndMind(Player player, AChar target) {
        bash.basicAttack(player, target);
        mind.basicAttack(player, target);
    }
}

    /**
    As long as Arm of Elenad is equipped: Wildlife enemies are passive until dealt damage.
    If there are only common and/or rare wildlife enemies on the battlefield the party may choose to end combat.
    If they do, disregard any loot reward from thhose enemies
     */
