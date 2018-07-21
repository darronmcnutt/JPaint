package model.commands;

import model.*;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.io.IOException;

public class CreateShape implements ICommand, IUndoable {
    private final Shape shape;
    private final ShapeList shapeList;

    public CreateShape(PairInt startPoint, PairInt endPoint, ShapeConfiguration shapeConfiguration, ShapeList shapeList) {
        this.shape = new Shape(startPoint,endPoint,shapeConfiguration);
        this.shapeList = shapeList;
    }

    @Override
    public void run() throws IOException {
        shapeList.add(shape);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.remove(shape);
    }

    @Override
    public void redo() {
        shapeList.add(shape);
    }
}
