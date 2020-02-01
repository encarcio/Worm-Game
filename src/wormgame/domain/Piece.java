package wormgame.domain;

public class Piece {

    private int x;
    private int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean runsInto(Piece piece) {
        if ((this.getX() == piece.getX()) && (this.getY() == piece.getY())) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "("+this.x+","+this.y+")";
    }
}
