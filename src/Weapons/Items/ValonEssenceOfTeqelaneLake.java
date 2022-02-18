package Weapons.Items;

import Abilities.WeaponAtk;
import Characters.AChar;
import Characters.Player;
import General.CombatCalc;
import Weapons.Weapon;

import java.util.List;

public class ValonEssenceOfTeqelaneLake extends Weapon {

    ValonEssenceOfTeqelaneLake() {
        super("Valon, Essence of Teqelane Lake", 10, 2, Handed.TWO, WeaponType.STAFF);
        statReq.put(AChar.Attribute.STRENGTH, 1);
        String flavorText = "When Aidé left home to sail across the Spine Sea he brought with him what he would miss the most";
    }

    WeaponAtk bash = new WeaponAtk("Bash", -2, WeaponAtk.Range.ONE, 3, CombatCalc.DmgType.BLUNT, List.of(WeaponAtk.Dice.D6));

    public void Bash (Player player, AChar target){
        bash.basicAttack(player, target);
    }
}

    /**
     If 2 INT or more:
     Become Proficient in Conjure water while wielding Valon. Learn Tidal wave (One use)

     The wielder of Valon may use it as a watersource.
     Each time they do, put a notion counter on Valon.
     This effect can no longer be used if it has 6 or more notion counters on it
     */
