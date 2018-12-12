package agh.cs.lab7;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2D,IMapElement> mapElements = new HashMap<>();

    @Override
    public void run(MoveDirection[] directions){
        IMapElement[] values= mapElements.values().toArray(new IMapElement[mapElements.size()]);
        List<Car> carList=new ArrayList<>();

        for (IMapElement element : values){
            if (element instanceof Car) carList.add((Car)element);
        }

        for (int i = 0; i < directions.length; i++) {
            Car tmpCar = carList.get(i%carList.size());
            tmpCar.move(directions[i]);
        }
    }
    @Override
    public boolean isOccupied(Vector2D position) {
        return objectAt(position) != null;
    }

    @Override
    public boolean place(Car car) throws IllegalArgumentException{
        if(!isOccupied(car.getPosition())){
            mapElements.put(car.getPosition(),car);
            return true;
        } else {
            throw new IllegalArgumentException("position: " + car.getPosition().toString() + "is occupied!");
        }
    }
    @Override
    public Object objectAt(Vector2D position) {
        return mapElements.get(position);
    }
    @Override
    public boolean canMoveTo(Vector2D position) {
        return (!isOccupied(position));
    }

    @Override
    public void positionChanged(Vector2D oldPosition, Vector2D newPosition){
        IMapElement mapElement = mapElements.get(oldPosition);
        mapElements.remove(oldPosition);
        mapElements.put(newPosition,mapElement);
    }
}
