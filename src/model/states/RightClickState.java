package model.states;

import model.ShapeColor;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IClickState;

public class RightClickState implements IClickState {
    public RightClickState() {
    }

    @Override
    public ShapeConfiguration getConfiguration(IApplicationState appState) {

        ShapeConfiguration shapeConfiguration = appState.getCurrentShapeConfiguration();

        // Unpack shape configuration
        ShapeType shapeType = shapeConfiguration.getShapeType();
        ShapeColor primaryColor = shapeConfiguration.getPrimaryColor();
        ShapeColor secondaryColor = shapeConfiguration.getSecondaryColor();
        ShapeShadingType shadingType = shapeConfiguration.getShadingType();

        // Swap primary and secondary colors
        return new ShapeConfiguration(shapeType,secondaryColor,primaryColor,shadingType);

    }
}
