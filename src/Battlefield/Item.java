package Battlefield;

import java.net.PortUnreachableException;

public class Item {

    public enum Rarity {
        COMMON,
        RARE,
        EPIC;
    }

    public enum Type {
        ARMOR,
        WEAPON,
        POTION,
        QUEST;
    }

    public enum ArmType {
        METAL,
        CLOTH,
        LEATHER;
    }

    public enum ArmSlot{
        HEAD,
        HANDS
    }


}
