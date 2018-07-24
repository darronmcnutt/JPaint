package model.interfaces;

import model.dataobjects.ShapeConfiguration;

public interface IClickState {
    ShapeConfiguration getConfiguration(IApplicationState appState);
}
