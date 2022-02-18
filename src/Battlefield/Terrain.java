package Battlefield;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Terrain{

    public enum Formation{
        HEXAGON,
        SQUARE
    }

    public Tile plain = new Tile(Tile.TileType.PLAIN);
    public Tile tree = new Tile(Tile.TileType.TREE);
    public Tile bush = new Tile(Tile.TileType.BUSH);
    public Tile wet = new Tile(Tile.TileType.WET);
    public Tile water = new Tile(Tile.TileType.WATER);
    public Tile tar = new Tile(Tile.TileType.TAR);

    public String name;
    public List<Item> gatherable;
    public List<Tile.TileType> indestructibleTiles;
    public List<Tile.TileToken> indestructibleTokens;
    public List<Tile> tiles;
    public Formation form;

    public Terrain(String name, Formation form) {
        this.name = name;
        gatherable = new ArrayList<>();
        this.form = form;
        tiles = new ArrayList<>();
        indestructibleTiles = new ArrayList<>();
        indestructibleTokens = new ArrayList<>();
    }

    public void giveTilesPosition(Formation form){
        if (form == Formation.HEXAGON){
            for (int i = 0; i < tiles.size(); i++) {
                if (i < 3) {
                    tiles.get(i).pos = new Point(1, i + 1);
                } else if (i < 7) {
                    tiles.get(i).pos = new Point(2, i - 3);
                } else if (i < 12) {
                    tiles.get(i).pos = new Point(3, i - 7);
                } else if (i < 18) {
                    tiles.get(i).pos = new Point(4, i - 12);
                } else if (i < 23) {
                    tiles.get(i).pos = new Point(5, i - 18);
                } else if (i < 27) {
                    tiles.get(i).pos = new Point(6, i - 23);
                } else {
                    tiles.get(i).pos = new Point(7, i - 27);
                }
            }
        }
    }
}
