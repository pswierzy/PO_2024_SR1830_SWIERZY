package agh.ics.oop;

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
        System.out.println("Start");

        MoveDirection[] enumargs = OptionsParser.Parser(args);
        System.out.println(enumargs[0]);
        run(enumargs);

        System.out.println("Stop");
    }
}
