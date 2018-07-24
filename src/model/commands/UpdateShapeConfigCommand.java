package model.commands;

import model.*;
import model.dataobjects.Shape;
import model.dataobjects.ShapeConfiguration;
import model.dataobjects.ShapeListManager;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.io.IOException;

public class UpdateShapeConfigCommand implements ICommand, IUndoable {

    private final ShapeList selected;
    private final ShapeList masterShapeList;
    private final ShapeList originalShapes = new ShapeList();
    private final ShapeList newShapes = new ShapeList();

    private final ShapeColor primaryColor;
    private final ShapeColor secondaryColor;
    private final ShapeShadingType shadingType;

    public UpdateShapeConfigCommand(ShapeListManager shapeListManager, ShapeConfiguration shapeConfiguration) {
        this.selected = shapeListManager.getSelectedShapeList();
        this.masterShapeList = shapeListManager.getMasterShapeList();

        // Unpack shape configuration
        primaryColor = shapeConfiguration.getPrimaryColor();
        secondaryColor = shapeConfiguration.getSecondaryColor();
        shadingType = shapeConfiguration.getShadingType();
    }

    @Override
    public void run() throws IOException {
        for (Shape shape : selected) {

            // Store original shape
            originalShapes.add(shape);

            // Remove shape from master shape list
            masterShapeList.remove(shape);

            // Generate new shape configuration
            ShapeConfiguration newShapeConfiguration =
                    new ShapeConfiguration(shape.getType(),primaryColor,secondaryColor,shadingType);

            // Create new shape
            Shape newShape =
                    new Shape(shape.getStartPoint(), shape.getEndPoint(), newShapeConfiguration);

            //Add new shape to master shape list and new shape list
            masterShapeList.add(newShape);
            newShapes.add(newShape);
        }

        // Clear selected shape list
        selected.clear();

        // Repopulate selected shape list
        for (Shape shape : newShapes) {
            selected.add(shape);
        }

    }


    @Override
    public void undo() {

        for (Shape shape : newShapes) {
            masterShapeList.remove(shape);
        }

        selected.clear();

        for (Shape shape : originalShapes) {
            masterShapeList.add(shape);
            selected.add(shape);
        }

    }

    @Override
    public void redo() {
        for (Shape shape : originalShapes) {
            masterShapeList.remove(shape);
        }

        selected.clear();

        for (Shape shape : newShapes) {
            masterShapeList.add(shape);
            selected.add(shape);
        }
    }
}
