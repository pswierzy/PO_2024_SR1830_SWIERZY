package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    @Test
    void createsSetNumberOfGrassTiles(){
        GrassField field = new GrassField(10);
        int grassCount = 0;
        for(int i = 0; i <= 10; i++){
            for(int j = 0; j <= 10; j++){
                if (field.isOccupied(new Vector2d(i,j))) grassCount++;
            }
        }
        assertEquals(10, grassCount);
    }

    @Test
    void placeTest(){
        //given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        //when
        boolean res1 = map.place(animal1);
        boolean res2 = map.place(animal2);
        //then
        assertTrue(res1);
        assertFalse(res2);
    }

    @Test
    void movingTest(){
        //given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        map.place(animal1);
        //when
        map.move(animal1, MoveDirection.FORWARD);
        //then
        assertEquals(animal1.getPosition(),new Vector2d(2,3));
        assertEquals(map.objectAt(animal1.getPosition()), animal1);
        assertTrue(map.objectAt(animal1.getPosition()) == animal1);
        assertFalse(map.isOccupied(new Vector2d(2,2)));
        assertTrue(map.isOccupied(new Vector2d(2,3)));
        assertTrue(map.canMoveTo(new Vector2d(2,2)));
        assertFalse(map.canMoveTo(new Vector2d(2,3)));
    }

    @Test
    void objectAtTest(){
        //given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2,3));
        Animal animal2 = new Animal(new Vector2d(5,5));
        //when
        map.place(animal1);
        map.place(animal2);
        //then
        assertTrue(map.objectAt(new Vector2d(2,3)) == animal1);
        assertTrue(map.objectAt(new Vector2d(5,5)) == animal2);
    }

    @Test
    void canMoveToTest(){
        //given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        map.place(animal1);
        //then
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        assertTrue(map.canMoveTo(new Vector2d(2,3)));
        assertTrue(map.canMoveTo(new Vector2d(1000,1000)));
    }

    @Test
    void getElementsTest(){
        //given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(1,1));
        Animal animal2 = new Animal(new Vector2d(2,2));
        Animal animal3 = new Animal(new Vector2d(3,3));
        List<WorldElement> elements = List.of(animal1, animal2, animal3);
        //then
        assertEquals(10, map.getElements().size());
        //when
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);
        //then
        assertEquals(elements, map.getElements().subList(0,3));
        assertTrue(map.getElements().get(0) == animal1);
        assertEquals(13, map.getElements().size());
    }

}