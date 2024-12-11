package leetcode.dungeon_game;

import java.util.ArrayList;
import java.util.List;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, 0, dungeon[0][0]));
        return 1 - visitTile(0, 0, dungeon, tiles);
    }

    private int visitTile(int y, int x, int[][] dungeon, List<Tile> tiles) {
        Tile tile = popTile(y, x, tiles);
        if (x == dungeon[0].length - 1 && y == dungeon.length - 1)
            return tile.value;
        if (x < dungeon[0].length - 1) {
            Tile rightTile = popTile(y, x + 1, tiles);
            if (rightTile != null)
                rightTile.value = Math.max(rightTile.value, tile.value + dungeon[y][x + 1]);
            else
                rightTile = new Tile(y, x + 1, tile.value + dungeon[y][x + 1]);
            tiles.add(rightTile);
        }

        if (y < dungeon.length - 1) {
            Tile downTile = popTile(y + 1, x, tiles);
            if (downTile != null)
                downTile.value = Math.max(downTile.value, tile.value + dungeon[y + 1][x]);
            else
                downTile = new Tile(y + 1, x, tile.value + dungeon[y + 1][x]);
            tiles.add(downTile);
        }
        Tile nextTile = null;
        for (Tile currentTile : tiles) {
            if (nextTile == null || currentTile.value > nextTile.value)
                nextTile = currentTile;
        }
        return visitTile(nextTile.y, nextTile.x, dungeon, tiles);
    }

    private class Tile {
        int x, y, value;

        Tile(int y, int x, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    private Tile popTile(int y, int x, List<Tile> tiles) {
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).x == x && tiles.get(i).y == y) {
                Tile tile = tiles.get(i);
                tiles.remove(i);
                return tile;
            }
        }
        return null;
    }
}