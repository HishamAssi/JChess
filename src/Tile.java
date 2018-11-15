public abstract class Tile {

    // Chess board consists of 64 tiles ( 8x8 ).

    int tileCoordinate;

    /*
    Constructor, constructs a new Tile with tileCoordinate value.
     */
    Tile(int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }

    /*
    Returns boolean value depending on whether this tile is occupied (True) or not (False).
     */
    public abstract boolean isTileOccupied();


    /*
    Returns the Piece that is occupying the current tile.
     */
    public abstract Piece getPiece();


    public static final class EmptyTile extends Tile{

        EmptyTile(int tileCoordinate){
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

        Piece pieceOnTile;

        OccupiedTile(int tileCoordinate, Piece pieceOnTile){
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
