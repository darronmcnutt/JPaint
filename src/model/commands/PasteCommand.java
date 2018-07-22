package model.commands;

import model.*;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.io.IOException;

public class PasteCommand implements ICommand,IUndoable {
    private ShapeList clipboard;
    private ShapeList masterShapeList;
    private ShapeList pastedShapes;

    public PasteCommand(ShapeListManager shapeListManager) {
        this.clipboard = shapeListManager.getClipboard();
        this.masterShapeList = shapeListManager.getMasterShapeList();
        this.pastedShapes = new ShapeList();
    }

    @Override
    public void run() throws IOException {
        for (Shape shape : clipboard) {
            PairInt startMove = new PairInt(0,0);
            PairInt endMove = new PairInt(15,15);
            Shape newShape = MovedShapeGenerator.generate(shape,startMove,endMove);
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
