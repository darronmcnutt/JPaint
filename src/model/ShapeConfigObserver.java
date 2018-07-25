package model;

import model.commands.UpdateShapeConfig;
import model.dataobjects.ShapeConfiguration;
import model.dataobjects.ShapeListManager;
import model.interfaces.IApplicationStateObserver;

import java.io.IOException;

public class ShapeConfigObserver implements IApplicationStateObserver {
    private final ShapeListManager shapeListManager;

    public ShapeConfigObserver(ShapeListManager shapeListManager) {
        this.shapeListManager = shapeListManager;
    }

    @Override
    public void update(ShapeConfiguration shapeConfiguration) {

        try {
            new UpdateShapeConfig(shapeListManager,shapeConfiguration).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
