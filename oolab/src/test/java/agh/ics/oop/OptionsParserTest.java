package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parseTest(){
        //given
        String[] args1 = {"f", "l", "r", "b"};
        String[] args2 = {"m", "m", "m", "m", "b"};
        String[] args3 = {};
        //when
        List<MoveDirection> res1 = new ArrayList<>(4);
        res1.add(MoveDirection.FORWARD);
        res1.add(MoveDirection.LEFT);
        res1.add(MoveDirection.RIGHT);
        res1.add(MoveDirection.BACKWARD);
        List<MoveDirection> res2 = new ArrayList<>(1);
        res2.add(MoveDirection.BACKWARD);

        //then
        assertEquals(res1, OptionsParser.parse(args1));
        assertEquals(res2, OptionsParser.parse(args2));
        assertEquals(new ArrayList<>(), OptionsParser.parse(args3));
    }

}