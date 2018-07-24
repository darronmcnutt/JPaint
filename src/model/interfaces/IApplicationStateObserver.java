package model.interfaces;

import model.dataobjects.ShapeConfiguration;

public interface IApplicationStateObserver {
    void update(ShapeConfiguration shapeConfiguration);
}
