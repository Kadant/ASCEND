package Weapons.Items;
import Abilities.WeaponAtk;
import Characters.AChar;
import Characters.Player;
import General.CombatCalc;
import Weapons.Weapon;

import java.util.List;

public class BronzeMace extends Weapon {

    CombatCalc cC;

    BronzeMace() {
        super("Bronze Mace", 2, 1, Handed.MAIN, WeaponType.MACE);
        statReq.put(AChar.Attribute.STRENGTH, 1);
    }

    WeaponAtk bash = new WeaponAtk("Bash", -2, WeaponAtk.Range.ONE, 2, CombatCalc.DmgType.BLUNT, List.of(WeaponAtk.Dice.D6));

    public void bash (Player player, AChar target){
        bash.basicAttack(player, target);
    }
}
