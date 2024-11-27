package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class SimulationEngine {
    List<Simulation> simulations;
    LinkedList<Thread> threads = new LinkedList<>();

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync(){
        for(Simulation simulation : simulations){
            simulation.run();
        }
    }

    public void runAsync(){
        for(Simulation simulation : simulations){
            Thread thread = new Thread(simulation);
            threads.addFirst(thread);
            thread.start();
        }
    }

    public void awaitSimulationsEnd(){
        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
