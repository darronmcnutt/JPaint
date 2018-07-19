package model;

import model.interfaces.IDrawShapeStrategy;
import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class DrawTriangleStrategy implements IDrawShapeStrategy {
    @Override
    public void draw(Shape shape, PaintCanvas canvas) {

        // Unpack start and end points
        int startX = shape.getStartPoint().getX();
        int startY = shape.getStartPoint().getY();

        int endX = shape.getEndPoint().getX();
        int endY = shape.getEndPoint().getY();

        // Construct the triangle
        GeneralPath triangle = new GeneralPath();
        triangle.moveTo(startX,startY);
        triangle.lineTo(endX,endY);
        triangle.lineTo(startX,endY);
        triangle.lineTo(startX,startY);

        // Draw the triangle
        Graphics2D canvasGraphics = canvas.getGraphics2D();
        canvasGraphics.setColor(Color.BLACK);
        canvasGraphics.fill(triangle);


    }
}
