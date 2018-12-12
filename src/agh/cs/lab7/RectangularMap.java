package agh.cs.lab7;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap  {
    private Vector2D upperRight;
    private Vector2D lowerLeft;

    public RectangularMap(int width, int height) {
        this.upperRight = new Vector2D(width,height);
        this.lowerLeft = new Vector2D(0,0);
    }

    public boolean vecInRange(Vector2D vec){
        Vector2D topRight = this.upperRight;
        Vector2D bottLeft = this.lowerLeft;
        return (vec.larger(bottLeft) && vec.smaller(topRight));
    }

    @Override
    public boolean canMoveTo(Vector2D position) {
        return (vecInRange(position) && super.canMoveTo(position));
}

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(this.lowerLeft,this.upperRight);
    }
}
