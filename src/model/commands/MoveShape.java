package model.commands;

import model.CommandHistory;
import model.PairInt;
import model.Shape;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.awt.*;
import java.io.IOException;

public class MoveShape implements ICommand, IUndoable {

    ShapeList shapeList;
    model.Shape originalShape;
    model.Shape newShape;

    public MoveShape(PairInt startPoint, PairInt endPoint, ShapeList shapeList) {

        // Initialize shapeList field
        this.shapeList = shapeList;

        // Unpack points
        int startX = startPoint.getX();
        int startY = startPoint.getY();
        int endX = endPoint.getX();
        int endY = endPoint.getY();


        // Find shape to be moved
        for (model.Shape shape : shapeList) {
            if (shape.getBoundary().contains(startX,startY)) {
                this.originalShape = shape;
            }
        }

        // Abort if shape not found in shapeList
        if (originalShape == null) { return; }

        // Calculate new start and endpoints
        int xDiff = endX - startX;
        int yDiff = endY - startY;


        // Generate new pairs
        startPoint = new PairInt(originalShape.getStartPoint().getX() + xDiff,
                originalShape.getStartPoint().getY() + yDiff);
        endPoint = new PairInt(originalShape.getEndPoint().getX() + xDiff,
                originalShape.getEndPoint().getY() + yDiff);


        // Generate new shape
        this.newShape = new Shape(startPoint,endPoint,originalShape.getShapeConfiguration());

    }

    @Override
    public void run() throws IOException {
            if (originalShape == null) {
                return;
            }

            shapeList.remove(originalShape);
            shapeList.add(newShape);
            CommandHistory.add(this);
    }


    @Override
    public void undo() {
        shapeList.remove(newShape);
        shapeList.add(originalShape);
    }

    @Override
    public void redo() {
        shapeList.remove(originalShape);
        shapeList.add(newShape);
    }
}
