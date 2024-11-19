package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<Vector2d> startPositions;
    private final List<MoveDirection> moves;
    private List<Animal> animals;

    public Simulation(List <Vector2d> startPositions, List <MoveDirection> moves) {
        this.startPositions = startPositions;
        this.moves = moves;

        createAnimalList();
    }

    //Do testów
    public Simulation(int a, List<MoveDirection> moves, List<Animal> animals) {
        this.startPositions = new ArrayList<>();
        this.moves = moves;
        this.animals = animals;
    }


    private void createAnimalList(){
        // Używam ArrayList a nie LinkedList, bo mamy stałą liczbę zwierząt i nie dodajemy nowych
        // a odnosimy się do nich dosyć często

        animals = new ArrayList<>();
        for (int i = 0; i < startPositions.size(); i++) {
           animals.add(new Animal(startPositions.get(i)));
        }
    }


    public void run(WorldMap map){
        int numberOfAnimals = animals.size();
        int currentAnimalIndex = 0;

        for (Animal animal : animals) {
            map.place(animal);
        }

        for (MoveDirection move : moves) {

            if (currentAnimalIndex == numberOfAnimals) currentAnimalIndex = 0;

            map.move(animals.get(currentAnimalIndex), move);
            System.out.println(map);

            currentAnimalIndex++;
        }
    }



}
