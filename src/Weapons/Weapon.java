package Weapons;

import Characters.AChar;

import java.util.HashMap;

public class Weapon {

    public HashMap<Passives,Integer> passives;
    public HashMap<AChar.Attribute, Integer> statReq;

    String name;
    Handed handed;
    int value;
    int weight;
    WeaponType type;

    public enum Passives{
        THROWABLE,
        BLEEDING,
        DUALWIELD
    }

    public enum Handed{
        TWO,
        ONE,
        MAIN,
        OFF
    }

    public enum WeaponType {
        SWORD,
        DAGGER,
        MACE,
        AXE,
        POLEARM,
        STAFF,
        LONGSWORD,
        GREATSWORD,
        WARHAMMER
    }

    /** General constructor*/
    public Weapon(String name, int value, int weight, Handed handed, WeaponType type){
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.handed  = handed;
        passives = new HashMap<>();
        statReq = new HashMap<>();
        this.type = type;
    }
}
