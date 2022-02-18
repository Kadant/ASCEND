package General;

import Characters.AChar;
import Abilities.WeaponAtk;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class CombatCalc {

    public enum DmgType {
        PIERCE,
        BLUNT,
        SLASH,
        MIND,
        DECAY,
        COLD,
        BURN,
        SHOCK
    }

    public enum Condition {
        BLEEDING,
        BURNING,
        POISONED
    }

    public enum Range{
        SELF,
        ONE,
        TWO,
        REACH,
        THREE,
        FOUR,
        FIVE,
        SIX,
        INTELLECT,
        STRENGTH,
        AGILITY,
        ANY
    }

    public enum Dice{
        D4,
        D6
    }

    int maxDmg = 0;

    public int rollDice (List<Dice> diceList){
        Random rand = new Random();
        int totalDmg = 0;

        for (Dice damageDice : diceList) {
            switch (damageDice) {
                case D4 -> totalDmg += rand.nextInt(1, 4);
                case D6 -> totalDmg += rand.nextInt(1, 6);
            }
        }
        return totalDmg;
    }

    public int dmgAfterDiceReduction (int dmg){
        if (dmg < 1){
            dmg = 1;
        }
        return dmg;
    }

    public void inflictCondition(Condition condition, int[] statusList, int nStacks){
        Arrays.sort(statusList);
        for (int i = 0; i < nStacks; i++) {
            switch (condition){
                case BURNING -> statusList[i] = 2;
                case BLEEDING -> statusList[i] = 4;
                case POISONED -> statusList[i] = 3;
            }
        }
    }

    public boolean isGraze(WeaponAtk atk, int dmg, List<Dice> dices){
        if (atk.diceDmgAlteration > 0){
            return (dmg == dices.size() + atk.diceDmgAlteration);
        }
        return (dmg == dices.size());
    }

    public boolean isCrit(double critChance){
        Random rand = new Random();
        double randomDouble = rand.nextDouble(0, 100);
        return (critChance) > randomDouble;
    }

    public int applyCrits (boolean isCrit, int dmg, double critDmg){
        if (isCrit){
            dmg *= critDmg;
            Math.round(dmg);
        }
        return dmg;
    }

    public boolean missed(AChar ch, AChar target){
        Random rand = new Random();
        double r1 = rand.nextDouble(0, 100);
        double r2 = rand.nextDouble(0, 100);
        return (!(ch.sStats.get(AChar.Stats.HITCHANCE) * r1 > target.sStats.get(AChar.Stats.DODGECHANCE) * r2));
    }

    public int afterResistances(AChar target, int dmg, DmgType dmgType){
        switch (dmgType){
            case BURN -> dmg -= target.resistances.get(DmgType.BURN);
            case BLUNT -> dmg -= target.resistances.get(DmgType.BLUNT);
            case COLD -> dmg -= target.resistances.get(DmgType.COLD);
            case DECAY -> dmg -= target.resistances.get(DmgType.DECAY);
            case MIND -> dmg -= target.resistances.get(DmgType.MIND);
            case PIERCE -> dmg -= target.resistances.get(DmgType.PIERCE);
            case SHOCK -> dmg -= target.resistances.get(DmgType.SHOCK);
            case SLASH -> dmg -= target.resistances.get(DmgType.SLASH);
        }
        if (dmg < 0){
            dmg = 0;
        }
        return dmg;
    }

    public int initialDmg(List<Dice> dices) {
        return dmgAfterDiceReduction(rollDice(dices));
    }

    public int maxDamage(WeaponAtk atk) {
        maxDmg = 0;
        for (Dice dice : atk.dmgDices) {
            switch (dice) {
                case D6 -> maxDmg += 6;
                case D4 -> maxDmg += 4;
            }
        }
        return maxDmg + atk.diceDmgAlteration;
    }

    public void causeFinalDmg(AChar ch, AChar target, int dmg, DmgType dmgType){
        dmg = applyCrits(isCrit(ch.sStats.get(AChar.Stats.CRITCHANCE)), dmg, ch.sStats.get(AChar.Stats.CRITDMG));
        dmg = afterResistances(target, dmg, dmgType);
        target.health -= dmg;
    }

    public void applyConditionDamage (AChar ch, Condition condition, int[] conditionStack){
        for (int i = 0; i < conditionStack.length; i++) {
            if (conditionStack[i] != 0){
                switch (condition){
                    case BLEEDING -> ch.health -= 1;
                    case POISONED -> ch.health -= 2;
                    case BURNING -> ch.health -= 3;
                }
                conditionStack[i]--;
            }
        }
    }
}
