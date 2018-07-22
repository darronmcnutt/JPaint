package model.interfaces;

import model.ShapeConfiguration;

public interface IClickState {
    ShapeConfiguration getConfiguration(IApplicationState appState);
}
