package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SimulationPresenter implements MapChangeListener{

    WorldMap worldMap;
    @FXML
    private Label infoLabel;
    @FXML
    private TextField moves;
    @FXML
    private Label moveDescription;

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void drawMap(){
        infoLabel.setText(worldMap.toString());
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(() -> {
            drawMap();
            moveDescription.setText(message);
        });
    }

    public void onSimulationStartClicked(ActionEvent actionEvent) {
        List<MoveDirection> directions = OptionsParser.parse(moves.getText().split(" "));

        Simulation simulation = new Simulation(directions, worldMap);
        SimulationEngine simulationEngine = new SimulationEngine(List.of(simulation));
        simulationEngine.runAsync();
    }
}
