package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;

public class World {
    public static void run(MoveDirection[] args){

        /*for (int i=0; i<leng-1; i++) {
            System.out.print(args[i]+", ");
        }
        System.out.println(args[leng-1]);*/
        int i=0;
        while( args[i] != null ){
            switch(args[i]){
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case RIGHT -> System.out.println("Zwierzak skreca w prawo");
                case LEFT -> System.out.println("Zwierzak skreca w lewo");
            }
            i++;
        }

    }

    public static void main(String[] args) {
        /*System.out.println("Start");

        MoveDirection[] enumArgs = OptionsParser.parser(args);
        System.out.println(enumArgs[0]);
        run(enumArgs);

        System.out.println("Stop");
        MapDirection direction = MapDirection.NORTH;
        Vector2d position1 = direction.toUnitVector();
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position2.add(position1));*/

        Animal gitus = new Animal();
        System.out.println(gitus.toString());


    }
}
