package Battlefield;

import Abilities.WeaponAtk;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Tile {

    public TileType type;
    public List<TileToken> tokenList;
    public Point pos;

    Tile(TileType type) {
        this.type = type;
        tokenList = new ArrayList<>();
    }

    enum TileType{
        BUSH,
        TREE,
        GRASS,
        WATER,
        THINICE,
        THICKICE,
        HIGHGRASS,
        PLAIN,
        TAR,
        MUD,
        WET,
        SAND,
        QUICKSAND,
        WOODENBRIDGE,
        STONEBRIDGE,
        WALL
    }

    enum TileToken{
        GAS,
        STEAM,
        LIGHTNING,
        FOG,
        ONFIRE,
        FROZEN,
        FALLENTREE,
        BLOCKADEWOOD,
        RUBBLE
    }

    public boolean hasToken(TileToken token, List<TileToken> tokenList){
        for (TileToken tileToken : tokenList) {
            if (tileToken == token) {
                return true;
            }
        }
        return false;
    }

    public void removeToken(TileToken token, List<TileToken> tokenList, List<TileToken> indestructible) {
        if (hasToken(token, tokenList) && !indestructible.contains(token)){
            for (int i = 0; i < tokenList.size(); i++) {
                if (tokenList.get(i) == token) {
                    tokenList.remove(i);
                    i--;
                }
            }
        }
    }

    public boolean canDestroyTile(WeaponAtk atk, TileType tt, List<TileType> indestructible){
        return true;
    }

    public void attackTile(Tile tile, WeaponAtk atk){
        switch (tile.type) {
            case THINICE:
                switch (atk.dmgType) {
                    case BLUNT, PIERCE, SLASH, SHOCK -> type = TileType.PLAIN;
                    case BURN -> type = TileType.WET;
                }
            case MUD:
                switch (atk.dmgType){
                    case COLD -> tile.type = Tile.TileType.THINICE;
                }
            case TAR:
                switch (atk.dmgType){
                    case COLD -> tile.tokenList.add(Tile.TileToken.FROZEN);
                    // case SHOCK -> cause small aoe shockdmg
                }
            case WET:
                switch (atk.dmgType) {
                    case BURN -> {
                        tile.type = Tile.TileType.PLAIN;
                        tile.tokenList.add(Tile.TileToken.STEAM);
                    }
                    case COLD -> tile.tokenList.add(Tile.TileToken.FROZEN);
                    // case SHOCK -> additional damage
                }
            case TREE:
                switch (atk.dmgType) {
                    case BURN -> tile.tokenList.add(Tile.TileToken.ONFIRE);
                }
        }

    }

    public void attackTile2(Tile tile, WeaponAtk atk, Terrain btf){
        switch (atk.dmgType) {
            case SLASH:
                switch (type){
                    case THINICE, HIGHGRASS -> type = TileType.PLAIN;
                    case WET -> removeToken(TileToken.FROZEN, tokenList, btf.indestructibleTokens);
                }
            case BLUNT:
                switch (type){
                    case THINICE, THICKICE -> type = TileType.PLAIN;
                    case WOODENBRIDGE -> {
                        if (canDestroyTile(atk, TileType.WOODENBRIDGE, btf.indestructibleTiles)) {
                            type = TileType.PLAIN;
                            tokenList.add(TileToken.BLOCKADEWOOD);
                        }
                    }
                }
                removeToken(TileToken.FROZEN, tokenList, btf.indestructibleTokens);
            case PIERCE:
                switch (type){
                    case BUSH:
                }
        }
    }
}
