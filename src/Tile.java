/***
 * Tile
 * represents a chess Tile
 * takes tileCoordinate as parameter
 * - key methods:
 *  - isTileOccupied
 *  - getPiece
 * with that, we have two subclasses that defines those behaviours
 */

public abstract class Tile {
    int tileCoordinate;
    Tile(int tileCoordinate) {
        //constructor to create individual tiles
        this.tileCoordinate = tileCoordinate;
    }
    public abstract boolean isTileOccupied();
        //abstract - as we're not defining it in this class but instead at a subclass
    public abstract Piece getPiece();
    public static final class EmptyTile extends Tile{
        //subclass to represent empty tile
        EmptyTile(int coordinate) {
            //constructor that calls a super class constructor with a tile coordinate that's passed into it
            super(coordinate);
        }
        @Override
        public boolean isTileOccupied(){
            return false;
        }
        @Override
        public Piece getPiece(){
            return null; //because theres no piece to return from empty tiles
        }
    }
    public static final class OccupiedTile extends Tile{
        //to define the occupied tile
        //only difference in this from Empty, is there's actually a piece
        Piece pieceOnTile;
        OccupiedTile(int tileCoordinate, Piece pieceOnTile){
            super(tileCoordinate); //call superclass constructor that establish tile coordinate
            this.pieceOnTile = pieceOnTile; //equal to piece passed on the constructor
        }
        @Override
        public boolean isTileOccupied(){
            return true;
        }
        @Override
        public Piece getPiece(){
            return this.pieceOnTile;
        }
    }
}
