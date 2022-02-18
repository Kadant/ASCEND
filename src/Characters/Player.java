package Characters;

import General.CombatCalc;

public class Player extends AChar {

    public enum PlayerClass{
        ROGUE
    }

    PlayerClass pClass;

    Player(String name, int str, int intel, int agil, int health, Family race, PlayerClass pClass) {
        super(name, str, intel, agil, health, race);
        maxAP = 4;
        this.pClass = pClass;

        resistances.put(CombatCalc.DmgType.PIERCE, 0);
        resistances.put(CombatCalc.DmgType.SLASH, 0);
        resistances.put(CombatCalc.DmgType.BLUNT, 0);
        resistances.put(CombatCalc.DmgType.COLD, 0);
        resistances.put(CombatCalc.DmgType.BURN, 0);
        resistances.put(CombatCalc.DmgType.DECAY, 0);
        resistances.put(CombatCalc.DmgType.MIND, 0);
        resistances.put(CombatCalc.DmgType.SHOCK, 0);
    }
}
