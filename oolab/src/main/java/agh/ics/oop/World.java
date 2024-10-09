package agh.ics.oop;

public class World {
    public static void run(String[] args){

        int leng = args.length;

        /*for (int i=0; i<leng-1; i++) {
            System.out.print(args[i]+", ");
        }
        System.out.println(args[leng-1]);*/

        for(String arg : args){
            switch(arg){
                case "f" -> System.out.println("Zwierzak idzie do przodu");
                case "b" -> System.out.println("Zwierzak idzie do tylu");
                case "r" -> System.out.println("Zwierzak skreca w prawo");
                case "l" -> System.out.println("Zwierzak skreca w lewo");
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Start");

        run(args);

        System.out.println("Stop");
    }
}
