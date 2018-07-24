package model.commands;

import model.*;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.io.IOException;

public class CreateShape implements ICommand, IUndoable {
    private final Shape shape;
    private final ShapeList masterShapeList;

    public CreateShape(PairInt startPoint, PairInt endPoint, ShapeConfiguration shapeConfiguration, ShapeListManager shapeListManager) {
        this.shape = new Shape(startPoint,endPoint,shapeConfiguration);
        this.masterShapeList = shapeListManager.getMasterShapeList();
    }

    @Override
    public void run() throws IOException {
        masterShapeList.add(shape);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        masterShapeList.remove(shape);
    }

    @Override
    public void redo() {
        masterShapeList.add(shape);
    }
}
