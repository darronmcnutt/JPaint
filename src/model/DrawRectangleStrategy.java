package model;

import model.interfaces.IDrawShapeStrategy;
import view.gui.PaintCanvas;
import java.awt.*;

public class DrawRectangleStrategy implements IDrawShapeStrategy {

    @Override
    public void draw(Shape shape, PaintCanvas canvas) {

        // Unpack start and end points
        int startX = shape.getStartPoint().getX();
        int startY = shape.getStartPoint().getY();

        int endX = shape.getEndPoint().getX();
        int endY = shape.getEndPoint().getY();

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

        // Calculate width and height
        int width = endX - startX;
        int height = endY - startY;

        // Draw rectangle
        Graphics2D canvasGraphics = canvas.getGraphics2D();
        canvasGraphics.setColor(Color.BLACK);
        canvasGraphics.fillRect(startX,startY,width,height);

    }



}
