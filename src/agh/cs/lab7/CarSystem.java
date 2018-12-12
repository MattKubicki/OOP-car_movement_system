package agh.cs.lab7;


import java.util.ArrayList;
import java.util.List;

public class CarSystem {
    public static void main(String[] args) {
        try {
            String[] commands = {"f", "r", "backward", "l", "forward", "forward", "l"};
            MoveDirection[] directions = new OptionParser(commands).parse();
            AbstractWorldMap map = new RectangularMap(5,5);
            Car car = new Car(map, 2,2);
            map.place(car);
            car.addObserver(map);
            map.run(directions);
            System.out.println(map);
            car.removeObserver(map);
        }
        catch (IllegalArgumentException ex){
            ex.printStackTrace();
            System.out.println(ex.toString());
            System.exit(1);
        }
    }
}
