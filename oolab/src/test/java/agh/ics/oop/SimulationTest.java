package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void isOrientationGood(){
        //given
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();
        String[] array = {"f","r","l",  "f","r","l",  "f","r","l",  "f","r","b"};
        List<MoveDirection> directions = OptionsParser.parse(array);
        List<Animal> animals = new ArrayList<>(Arrays.asList(animal1, animal2, animal3));
        //when
        Simulation simulation = new Simulation(0,directions, animals);
        simulation.run();
        //then
        assertEquals(animal1.getDirection(), MapDirection.NORTH);
        assertEquals(animal2.getDirection(), MapDirection.NORTH);
        assertEquals(animal3.getDirection(), MapDirection.EAST);
    }

    @Test
    void isMovingGood(){
        //given
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();
        String[] array = {"f","r","r",  "r","r","f",  "b","r","f",  "b","r","f"};
        List<MoveDirection> directions = OptionsParser.parse(array);
        List<Animal> animals = new ArrayList<>(Arrays.asList(animal1, animal2, animal3));
        //when
        Simulation simulation = new Simulation(0,directions, animals);
        simulation.run();
        //then
        assertEquals(animal1.getPosition(), new Vector2d(0,3));
        assertEquals(animal2.getPosition(), new Vector2d(2,2));
        assertEquals(animal3.getPosition(), new Vector2d(4,2));
    }

    @Test
    void staysInMap(){
        //given
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();
        Animal animal4 = new Animal();
        String[] array = {"f","b","r","l",  "f","b","f","f",  "f","b","f","f",  "f","b","f","f", "f","b","f","f"};
        List<MoveDirection> directions = OptionsParser.parse(array);
        List<Animal> animals = new ArrayList<>(Arrays.asList(animal1, animal2, animal3, animal4));
        //when
        Simulation simulation = new Simulation(0,directions, animals);
        simulation.run();
        //then
        assertEquals(animal1.getPosition(), new Vector2d(2,4));
        assertEquals(animal2.getPosition(), new Vector2d(2,0));
        assertEquals(animal3.getPosition(), new Vector2d(4,2));
        assertEquals(animal4.getPosition(), new Vector2d(0,2));
    }




}