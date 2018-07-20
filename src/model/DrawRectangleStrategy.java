package model;

import model.interfaces.IDrawShapeStrategy;
import view.gui.PaintCanvas;
import java.awt.*;

public class DrawRectangleStrategy implements IDrawShapeStrategy {

    @Override
    public void draw(Shape shape, PaintCanvas canvas) {

        // Unpack rectangle start point
        int startX = shape.getRectX();
        int startY = shape.getRectY();

        // Get rectangle width and height
        int width = shape.getRectWidth();
        int height = shape.getRectHeight();

        // Draw rectangle
        Graphics2D canvasGraphics = canvas.getGraphics2D();
        canvasGraphics.setColor(Color.BLACK);
        canvasGraphics.fillRect(startX,startY,width,height);

    }



}
