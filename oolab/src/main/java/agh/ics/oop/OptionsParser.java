package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {

    public static MoveDirection[] parser(String[] arg){
        int newLen = 0;
        for (int i = 0; i < arg.length; i++) {
            String s = arg[i];
            if (s == "f" || s == "b" || s == "l" || s == "r") newLen++;
        }
        MoveDirection[] moveDirections = new MoveDirection[newLen];
        int mdi = 0;
        for (String s : arg) {
            if (s=="f" || s=="b" || s=="l" || s=="r") {
                moveDirections[mdi] = switch (s) {
                    case "f" -> MoveDirection.FORWARD;
                    case "b" -> MoveDirection.BACKWARD;
                    case "l" -> MoveDirection.LEFT;
                    case "r" -> MoveDirection.RIGHT;
                    default -> throw new IllegalStateException("Unexpected value: " + s);
                };
                mdi++;
            }
        }
        return moveDirections;
    }
}
