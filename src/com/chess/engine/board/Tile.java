package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

import java.util.HashMap;
import java.util.Map;
import com.google.common.collect.ImmutableMap;


/*
Chess board consists of 64 tiles ( 8x8 ). This class represents one of these tiles.
 */
public abstract class Tile {


    // Immutable variable defining the tile number and hence its coordinate.
    protected final int tileCoordinate;

    // An immutable Hashmap, mapping the tiles to their respective numbers.
    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();


    /*

     */
    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {

        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for(int i = 0;i < 64; i++){
            emptyTileMap.put(i, new EmptyTile(i));
        }

        return ImmutableMap.copyOf(emptyTileMap);
    }

    public static Tile createTile(final int tileCoordinate, final Piece piece){
        return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);

        /*
        The above can be rewritten as:
        if (piece != null) {
            return new OccupiedTile(tileCoordinate, piece);
        }
        return EMPTY_TILES.get(tileCoordinate);

         */
    }


    /*
    Constructor, constructs a new Tile with tileCoordinate value.
     */
    private Tile(int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }

    /*
    Returns boolean value depending on whether this tile is occupied (True) or not (False).
     */
    public abstract boolean isTileOccupied();


    /*
    Returns the com.chess.engine.pieces.Piece that is occupying the current tile.
     */
    public abstract Piece getPiece();


    public static final class EmptyTile extends Tile{

        private EmptyTile(final int tileCoordinate){
            super(tileCoordinate);
        }

        @Override
        public boolean isTileOccupied(){
            return false;
        }

        @Override

        public Piece getPiece(){
            return null;
        }
    }

    public static final class OccupiedTile extends Tile{

        private final Piece pieceOnTile;

        private OccupiedTile(final int tileCoordinate, Piece pieceOnTile){
            super(tileCoordinate);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }
    }


}
