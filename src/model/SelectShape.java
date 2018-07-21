package model;

import model.interfaces.ICommand;

import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SelectShape implements ICommand {
    Rectangle boundary;

    public SelectShape(PairInt startPoint, PairInt endPoint, ShapeList shapeList) {

        // CREATE SOME KIND OF RECTANGLE STRATEGY THAT CAN BE REUSED
        // Unpack start and end points
        int startX = startPoint.getX();
        int startY = startPoint.getY();

        int endX = endPoint.getX();
        int endY = endPoint.getY();

        // Swap start and end points if necessary
        if (endX < startX) {
            int temp = endX;
            endX = startX;
            startX = temp;
        }

        if (endY < startY) {
            int temp = endY;
            endY = startY;
            startY = temp;
        }

        int width = endX - startX;
        int height = endY - startY;

        this.boundary = new Rectangle(startX,startY,width,height);

        // Find shape to be moved
        //FIX - for testing purposes only
        int i = 0;
        for (Shape shape : shapeList) {
            if (shape.getBoundary().intersects(boundary)) {
                System.out.println(i);
            }
            i++;
        }

    }

    @Override
    public void run() throws IOException {
        return;
    }
}
