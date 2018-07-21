package model.commands;

import model.*;
import model.interfaces.ICommand;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;


public class SelectShape implements ICommand {
    private ArrayList<Shape> selected = new ArrayList<>();
    private ShapeConfiguration shapeConfiguration;
    private ShapeList shapeList;

    public SelectShape(PairInt startPoint, PairInt endPoint, ShapeList shapeList, ShapeConfiguration shapeConfiguration) {

        // Initialize fields
        this.shapeConfiguration = shapeConfiguration;
        this.shapeList = shapeList;

        Rectangle selectBoundary = RectangleGenerator.generate(startPoint,endPoint);
        Rectangle shapeBoundary;

        // Unpack points
        int startX = startPoint.getX();
        int startY = startPoint.getY();

        // Find shapes to be selected
        for (Shape shape : shapeList) {

            shapeBoundary = shape.getBoundary();

            if (shapeBoundary.intersects(selectBoundary) ||
                    shapeBoundary.contains(startX,startY)) {
                selected.add(shape);
            }
        }

    }

    @Override
    public void run() throws IOException {
        for (Shape shape : selected) {
            Shape newShape = new Shape(shape.getStartPoint(),shape.getEndPoint(),shapeConfiguration);
            shapeList.remove(shape);
            shapeList.add(newShape);
        }
    }
}
