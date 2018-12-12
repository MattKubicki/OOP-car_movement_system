package agh.cs.lab7;

import java.util.ArrayList;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {

    public UnboundedMap(List<HayStack> hays) {
        if(hays!=null) {
            for (HayStack hay : hays) {
                mapElements.put(hay.getPosition(), hay);
            }
        }
    }

    @Override
    public String toString(){
        int minX, minY, maxX, maxY;
        minX = maxX = mapElements.values().iterator().next().getPosition().getX();
        minY = maxY = mapElements.values().iterator().next().getPosition().getY();
        for (IMapElement element : mapElements.values()) {
            if (element.getPosition().getX() < minX) minX = element.getPosition().getX();
            if (element.getPosition().getY() < minY) minY = element.getPosition().getY();
            if (element.getPosition().getX() > maxX) maxX = element.getPosition().getX();
            if (element.getPosition().getY() > maxY) maxY = element.getPosition().getY();
        }
        Vector2D lowerLeft = new Vector2D(minX,minY);
        Vector2D upperRight = new Vector2D(maxX,maxY) ;
        return new MapVisualizer(this).draw(lowerLeft,upperRight);
    }

}
