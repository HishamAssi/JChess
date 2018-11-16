package com.chess.engine.board;

import java.util.Arrays;

public class BoardUtils {

    public static final boolean[] FIRST_COLUMN = columnTile(1);
    public static final boolean[] SECOND_COLUMN = columnTile(2);
    public static final boolean[] SEVENTH_COLUMN = columnTile(7);
    public static final boolean[] EIGHTH_COLUMN = columnTile(8);



    private BoardUtils() {
        throw new RuntimeException("You cannot instantiate me!!!!!");
    }

    public static boolean isValidTileCoordinate(int tileCoordinate) {
        return tileCoordinate >= 0 && tileCoordinate < 64;
    }

    private static boolean[] columnTile(int columnNum){
        boolean[] allTiles = new boolean[64];
        Arrays.fill(allTiles, false);
        for (int i = columnNum-1; i < 64; i+=8 ){
            allTiles[i] = true;
        }
        return allTiles;
    }


}
