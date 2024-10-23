package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] Parser(String[] arg){
        MoveDirection[] moveDirections = new MoveDirection[arg.length];
        int mdi = 0;
        for (String s : arg) {
            switch (s) {
                case "f" -> moveDirections[mdi] = MoveDirection.FORWARD;
                case "b" -> moveDirections[mdi] = MoveDirection.BACKWARD;
                case "l" -> moveDirections[mdi] = MoveDirection.LEFT;
                case "r" -> moveDirections[mdi] = MoveDirection.RIGHT;
                default -> mdi--;
            }
            mdi++;
        }
        return moveDirections;
    }
}
