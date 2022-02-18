package Abilities;

import General.CombatCalc;

import java.util.List;

public abstract class Abilities extends CombatCalc{

    public String name;
    public Range range;
    public int actionCost;
    public int coolDown;

    public Abilities(String name, Range range, int actionCost, int coolDown) {
        this.name = name;
        this.actionCost = actionCost;
        this.range = range;
        this.coolDown = coolDown;
    }
}
