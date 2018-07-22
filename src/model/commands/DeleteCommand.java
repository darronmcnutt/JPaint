package model.commands;

import model.CommandHistory;
import model.Shape;
import model.ShapeList;
import model.ShapeListManager;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.io.IOException;

public class DeleteCommand implements ICommand,IUndoable {
    private ShapeList masterShapeList;
    private ShapeList selectedShapes;
    private ShapeList deletedShapes = new ShapeList();

    public DeleteCommand(ShapeListManager shapeListManager) {
        this.selectedShapes = shapeListManager.getSelectedShapeList();
        this.masterShapeList = shapeListManager.getMasterShapeList();
    }

    @Override
    public void run() throws IOException {
        for (Shape shape : selectedShapes) {
            deletedShapes.add(shape);
            masterShapeList.remove(shape);
        }

        // Clear selected shapes list
        selectedShapes.clear();

        CommandHistory.add(this);
    }

    @Override
    public void undo() {

        // Restore deleted shapes
        for (Shape shape : deletedShapes) {
            masterShapeList.add(shape);
            selectedShapes.add(shape);
        }
    }

    @Override
    public void redo() {

        // Remove shapes from masterShapeList
        for (Shape shape : deletedShapes) {
            masterShapeList.remove(shape);
        }

        // Clear selected shapes list
        selectedShapes.clear();
    }


}
