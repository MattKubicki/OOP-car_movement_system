package agh.cs.lab7;

import java.util.LinkedList;
import java.util.List;

public class Car implements IMapElement {
    private Vector2D position = new Vector2D(2,2);
    private MapDirection orientation = MapDirection.NORTH;
    private IWorldMap map;

    private List<IPositionChangeObserver> observers = new LinkedList<>();

    public Car(IWorldMap map, int x, int y) {
        this.position = new Vector2D(x,y);
        this.map = map;
    }
    public Car(Vector2D position, MapDirection orientation){
        this.orientation = orientation;
        this.position = position;
    }

    public Car(IWorldMap map){
        this.map = map;
    }

    @Override
    public String toString() {
        return orientation.toString().substring(0,1);
    }

    @Override
    public Vector2D getPosition(){
        return this.position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public void move(MoveDirection direction){
        Vector2D displacement = null;
        switch (direction){
            case LEFT:
                orientation = orientation.previous();
                return;
            case RIGHT:
                orientation = orientation.next();
                return;
            case FORWARD:
                displacement = orientation.moveVec();
                break;
            case BACKWARD:
                displacement = orientation.moveVec().oppositeVec();
                break;
        }
        Vector2D newPosition = position.add(displacement);
        if (map.canMoveTo(newPosition)){
            positionChanged(position,newPosition);
            position = newPosition;
        }
    }

    void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    void positionChanged(Vector2D oldPosition, Vector2D newPosition) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

}
