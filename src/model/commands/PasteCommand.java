package model.commands;

import model.*;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.io.IOException;

public class PasteCommand implements ICommand,IUndoable {
    private ShapeList clipboard;
    private ShapeList masterShapeList;
    private ShapeList undoRedoList;

    public PasteCommand(ShapeListManager shapeListManager) {
        this.clipboard = shapeListManager.getClipboard();
        this.masterShapeList = shapeListManager.getMasterShapeList();
        this.undoRedoList = new ShapeList();
    }

    @Override
    public void run() throws IOException {
        for (Shape shape : clipboard) {
            PairInt startPoint = new PairInt(shape.getStartPoint().getX() + 10,
                    shape.getStartPoint().getY() + 10);
            PairInt endPoint = new PairInt(shape.getEndPoint().getX() + 10,
                    shape.getEndPoint().getY() + 10);
            Shape newShape = new Shape(startPoint,endPoint,shape.getShapeConfiguration());
            masterShapeList.add(newShape);
            undoRedoList.add(newShape);

        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (Shape shape : undoRedoList) {
            masterShapeList.remove(shape);
        }
    }

    @Override
    public void redo() {
        for (Shape shape : undoRedoList) {
            masterShapeList.add(shape);
        }
    }
}
