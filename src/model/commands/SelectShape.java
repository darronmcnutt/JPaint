package model.commands;

import model.*;
import model.interfaces.ICommand;
import model.utilities.RectangleGenerator;

import java.awt.Rectangle;
import java.io.IOException;


public class SelectShape implements ICommand {
    private final ShapeList masterShapeList;
    private final ShapeList selectedShapeList;

    private final int startX;
    private final int startY;

    private final Rectangle selectBoundary;

    public SelectShape(PairInt startPoint, PairInt endPoint, ShapeListManager shapeListManager) {

        // Initialize fields
        this.masterShapeList = shapeListManager.getMasterShapeList();
        this.selectedShapeList = shapeListManager.getSelectedShapeList();
        this.selectBoundary = RectangleGenerator.generate(startPoint,endPoint);

        // Unpack points
        this.startX = startPoint.getX();
        this.startY = startPoint.getY();

    }

    @Override
    public void run() throws IOException {

        // Remove all elements from the list of of selected shapes
        selectedShapeList.clear();

        Rectangle shapeBoundary;

        // Add elements to the selected shapes list
        for (Shape shape : masterShapeList) {

            shapeBoundary = shape.getBoundary();

            if (shapeBoundary.intersects(selectBoundary) ||
                    shapeBoundary.contains(startX,startY)) {
                selectedShapeList.add(shape);
            }
        }
    }
}
