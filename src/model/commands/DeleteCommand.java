package model.commands;

import model.CommandHistory;
import model.dataobjects.Shape;
import model.ShapeList;
import model.dataobjects.ShapeListManager;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.io.IOException;

public class DeleteCommand implements ICommand,IUndoable {
    private final ShapeList masterShapeList;
    private final ShapeList selectedShapes;
    private final ShapeList deletedShapes = new ShapeList();

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
