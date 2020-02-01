package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;

public class Worm {

    private int x;
    private int y;
    private Direction direction;
    private List<Piece> worm;
    private int length;
    private boolean grow;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.direction = originalDirection;
        this.worm = new ArrayList<Piece>();
        this.worm.add(new Piece(originalX, originalY));
        this.grow = false;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public int getLength() {
        return worm.size();
    }

    public List<Piece> getPieces() {
        return this.worm;
    }

    public void move() {
        if (this.direction == Direction.RIGHT) {
            this.x = x + 1;
        } else if (this.direction == Direction.LEFT) {
            this.x -= 1;
        } else if (this.direction == Direction.UP) {
            this.y = y - 1;
        } else if (this.direction == Direction.DOWN) {
            this.y = y + 1;
        }
        if (getLength() > 2 && !grow) {
            worm.remove(0);
        }

        if (grow = true) {
            grow = false;
        }
        this.worm.add(new Piece(x, y));
    }

    public void grow() {
        grow = true;

    }

    public boolean runsInto(Piece piece) {
        for (Piece pieces : worm) {
            if ((pieces.getX() == piece.getX()) && (pieces.getY() == piece.getY())) {
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself() {
        for (int i = 0; i < getLength() - 1; i++) {
            if (wormHead().getX() == worm.get(i).getX() && wormHead().getY() == worm.get(i).getY()) {
                return true;
            }
        }

        return false;
    }

    public Piece wormHead() {
        return worm.get(getLength() - 1);
    }
}
