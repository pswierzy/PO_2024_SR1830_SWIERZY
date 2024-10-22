package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void equalsTest(){
        //when
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        Vector2d v3 = new Vector2d(1,3);
        Vector2d v4 = new Vector2d(2,2);
        Vector2d v5 = new Vector2d(2,3);
        //then
        assertTrue(v1.equals(v2));
        assertFalse(v1.equals(v3));
        assertFalse(v1.equals(v4));
        assertFalse(v1.equals(v5));
    }

    @Test
    void toStringTest(){
        //given
        Vector2d v1 = new Vector2d(1,2);
        //when
        String v2 = v1.toString();
        //then
        assertEquals("(1, 2)", v2);
    }

    @Test
    void precedesTest(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);
        Vector2d v3 = new Vector2d(2,3);
        Vector2d v4 = new Vector2d(2,3);
        Vector2d v5 = new Vector2d(3,2);

        assertTrue(v1.precedes(v2));
        assertTrue(v1.precedes(v3));
        assertTrue(v1.precedes(v4));
        assertTrue(v2.precedes(v4));
        assertTrue(v3.precedes(v4));
        assertFalse(v4.precedes(v5));
        assertFalse(v5.precedes(v4));
    }

    @Test
    void followsTest(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);
        Vector2d v3 = new Vector2d(2,3);
        Vector2d v4 = new Vector2d(2,3);
        Vector2d v5 = new Vector2d(3,2);

        assertTrue(v2.follows(v1));
        assertTrue(v3.follows(v1));
        assertTrue(v4.follows(v1));
        assertTrue(v4.follows(v2));
        assertTrue(v4.follows(v3));
        assertFalse(v5.follows(v4));
        assertFalse(v4.follows(v5));
    }

    @Test
    void upperRightTest(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);
        Vector2d v3 = new Vector2d(1,3);
        Vector2d v4 = new Vector2d(2,3);

        assertEquals(v4, v2.upperRight(v3));
        assertEquals(new Vector2d(2,2), v1.upperRight(v2));
        assertEquals(new Vector2d(1,3), v1.upperRight(v3));
    }

    @Test
    void lowerRightTest(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);
        Vector2d v3 = new Vector2d(1,3);
        Vector2d v4 = new Vector2d(2,3);

        assertEquals(new Vector2d(1,1), v1.lowerLeft(v2));
        assertEquals(new Vector2d(1,1), v1.lowerLeft(v3));
        assertEquals(new Vector2d(1,3), v3.lowerLeft(v4));
    }

    @Test
    void addTest(){
        Vector2d v0 = new Vector2d(0,0);
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);

        assertEquals(new Vector2d(0,0), v0.add(v0));
        assertEquals(new Vector2d(1,1), v0.add(v1));
        assertEquals(v2.add(v1), v1.add(v2));
        assertEquals(new Vector2d(3,3), v1.add(v2));
    }

    @Test
    void substractTest(){
        Vector2d v0 = new Vector2d(1,1);
        Vector2d v1 = new Vector2d(4,2);
        Vector2d v2 = new Vector2d(2,3);

        assertEquals(new Vector2d(-2,1), v2.subtract(v1));
        assertEquals(new Vector2d(1,2), v2.subtract(v0));
        assertEquals(new Vector2d(3,1), v1.subtract(v0));
        assertEquals(new Vector2d(0,0), v2.subtract(v2));
        assertEquals(new Vector2d(2,-1), v1.subtract(v2));
    }

    @Test
    void oppositeTest(){
        Vector2d v0 = new Vector2d(0,0);
        Vector2d v1 = new Vector2d(1,2);

        assertEquals(new Vector2d(0,0), v0.opposite());
        assertEquals(new Vector2d(-1,-2), v1.opposite());
    }
}