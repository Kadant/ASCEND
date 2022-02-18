package Abilities;

import Characters.AChar;

import java.util.List;

public abstract class Attacks extends Abilities {

    public int diceDmgAlteration;
    public DmgType dmgType;
    public List<Dice> dmgDices;

    public Attacks(String name, int diceDmgAlteration, Range range, int actionCost, DmgType dmgType, List<Dice> dmgDices) {
        super(name, range, actionCost);
        this.dmgDices = dmgDices;
        this.diceDmgAlteration = diceDmgAlteration;
        this.dmgType = dmgType;
    }

    public void basicAttack(AChar ch, AChar target) {
        if (missed(ch, target)) {
            ch.maxAP -= actionCost;
            causeFinalDmg(ch, target, initialDmg(dmgDices), dmgType);
        }
    }
}
