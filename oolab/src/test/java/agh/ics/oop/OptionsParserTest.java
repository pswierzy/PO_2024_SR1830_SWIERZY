package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parserTest(){
        //when
        String[] args1 = {"f", "l", "r", "b"};
        String[] args2 = {"m", "m", "m", "m", "b"};
        String[] args3 = {};

        //then
        assertEquals(new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.BACKWARD}, OptionsParser.parser(args1));
        assertEquals(new MoveDirection[]{MoveDirection.BACKWARD}, OptionsParser.parser(args2));
        assertEquals(new MoveDirection[]{}, OptionsParser.parser(args3));
    }

}