package Weapons.Items;
import Abilities.WeaponAtk;
import Characters.AChar;
import Characters.Player;
import General.CombatCalc;
import Weapons.Weapon;

import java.util.List;

public class BattlePick extends Weapon {

    CombatCalc cC;

    BattlePick() {
        super("Battle Pick", 2, 1, Handed.MAIN, WeaponType.MACE);
        statReq.put(AChar.Attribute.STRENGTH, 1);
    }

    WeaponAtk pick = new WeaponAtk("Pick", -2, WeaponAtk.Range.ONE, 2, CombatCalc.DmgType.PIERCE, List.of(WeaponAtk.Dice.D6));

    public void pick (Player player, AChar target){
        pick.basicAttack(player, target);
    }

    WeaponAtk bash = new WeaponAtk("Bash", -3, WeaponAtk.Range.ONE, 2, CombatCalc.DmgType.BLUNT, List.of(WeaponAtk.Dice.D6));

    public void bash (Player player, AChar target){
        bash.basicAttack(player, target);
    }
}
