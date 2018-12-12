package agh.cs.lab7;


public class Vector2D {
    public final int x;
    public final int y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean smaller(Vector2D vec) {
        return ((this.x <= vec.x) && (this.y <= vec.y));
    }

    public boolean larger(Vector2D vec) {
        return ((this.x >= vec.x) && (this.y >= vec.y));
    }

    public Vector2D add(Vector2D vec) {
        Vector2D result = new Vector2D((this.x + vec.x), (this.y + vec.y));
        return result;
    }

    public Vector2D oppositeVec() {
        Vector2D result = new Vector2D((-1 * this.x), (-1 * this.y));
        return result;
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2D))
            return false;
        Vector2D that = (Vector2D) other;
        return ((this.x == that.x) && (this.y == that.y));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override

    public int hashCode() {
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
    }

}
