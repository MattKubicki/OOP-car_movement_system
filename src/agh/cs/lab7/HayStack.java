package agh.cs.lab7;

public class HayStack implements IMapElement {
    private Vector2D position;

    public HayStack(Vector2D position) {
        this.position = position;
    }

    @Override
    public Vector2D getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return "s";
    }
}
