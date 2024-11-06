package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.Arrays;
import java.util.List;

public class World {
//    public static void run(MoveDirection[] args){
//
//        int i=0;
//        while( args[i] != null ){
//            switch(args[i]){
//                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
//                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
//                case RIGHT -> System.out.println("Zwierzak skreca w prawo");
//                case LEFT -> System.out.println("Zwierzak skreca w lewo");
//            }
//            i++;
//        }
//
//    }

    public static void main(String[] args) {

        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        WorldMap map = new GrassField(10);
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();
    }
}
