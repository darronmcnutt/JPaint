package model;

public class PairInt {
    private final int x;
    private final int y;

    public PairInt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y;
    }
    
}
