package model;

import model.commands.UpdateCommand;
import model.interfaces.IStateObserver;
import model.persistence.ApplicationState;

import java.io.IOException;

public class StateObserver implements IStateObserver {
    private final ApplicationState appState;
    private final ShapeListManager shapeListManager;

    public StateObserver(ApplicationState appState, ShapeListManager shapeListManager) {
        this.appState = appState;
        this.shapeListManager = shapeListManager;
    }

    @Override
    public void update() {
        try {
            new UpdateCommand(shapeListManager,appState).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
