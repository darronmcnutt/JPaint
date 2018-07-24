package model.states;

import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IClickState;

public class LeftClickState implements IClickState {

    public LeftClickState() { }

    @Override
    public ShapeConfiguration getConfiguration(IApplicationState appState) {
        return appState.getCurrentShapeConfiguration();
    }
}
