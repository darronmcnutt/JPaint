package model.commands;

import model.*;
import model.dataobjects.PairInt;
import model.dataobjects.Shape;
import model.dataobjects.ShapeListManager;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;
import model.utilities.MovedShapeGenerator;

import java.io.IOException;

public class PasteCommand implements ICommand,IUndoable {
    private final ShapeList clipboard;
    private final ShapeList masterShapeList;
    private final ShapeList pastedShapes = new ShapeList();

    public PasteCommand(ShapeListManager shapeListManager) {
        this.clipboard = shapeListManager.getClipboard();
        this.masterShapeList = shapeListManager.getMasterShapeList();
    }

    @Override
    public void run() throws IOException {
        for (Shape shape : clipboard) {

            // Calculate offset for pasted shape
            PairInt startMove = new PairInt(0,0);
            PairInt endMove = new PairInt(15,15);

            // Generate pasted shape
            Shape newShape = MovedShapeGenerator.generate(shape,startMove,endMove);

            // Add pasted shape to master list and pasted shapes list
            masterShapeList.add(newShape);
            pastedShapes.add(newShape);
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (Shape shape : pastedShapes) {
            masterShapeList.remove(shape);
        }
    }

    @Override
    public void redo() {
        for (Shape shape : pastedShapes) {
            masterShapeList.add(shape);
        }
    }
}
