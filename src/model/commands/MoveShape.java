package model.commands;

import model.*;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;
import model.utilities.MovedShapeGenerator;

import java.io.IOException;

public class MoveShape implements ICommand, IUndoable {

    private ShapeList masterShapeList;
    private ShapeList selectedShapes;
    private ShapeList movedShapes = new ShapeList();
    private ShapeList originalShapes = new ShapeList();

    public MoveShape(PairInt startPoint, PairInt endPoint, ShapeListManager shapeListManager) {
        this.masterShapeList = shapeListManager.getMasterShapeList();
        this.selectedShapes = shapeListManager.getSelectedShapeList();

        for (Shape shape : selectedShapes) {
            movedShapes.add(MovedShapeGenerator.generate(shape,startPoint,endPoint));
        }

    }

    @Override
    public void run() throws IOException {
            // Remove selected shapes from master shape list
            for (Shape shape : selectedShapes) {
                originalShapes.add(shape);
                masterShapeList.remove(shape);
            }

            // Clear the selected shapes list
            selectedShapes.clear();

            // Add moved shapes to master list and selected list
            for (Shape shape : movedShapes) {
                masterShapeList.add(shape);
                selectedShapes.add(shape);
            }

            CommandHistory.add(this);
    }


    @Override
    public void undo() {
        // Clear selected shape list
        selectedShapes.clear();

        // Remove moved shapes from master list
        for (Shape shape : movedShapes) {
            masterShapeList.remove(shape);
        }

        // Add original shapes to master list and selected list
        for (Shape shape : originalShapes) {
            masterShapeList.add(shape);
            selectedShapes.add(shape);
        }

    }

    @Override
    public void redo() {

        // Clear selected shape list
        selectedShapes.clear();

        // Remove original shapes from master list
        for (Shape shape : originalShapes) {
            masterShapeList.remove(shape);
        }

        // Add moved shapes to master list and selected list
        for (Shape shape : movedShapes) {
            masterShapeList.add(shape);
            selectedShapes.add(shape);
        }

    }

}
