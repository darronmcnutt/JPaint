package model;

import model.interfaces.IDrawShapeStrategy;
import view.gui.PaintCanvas;
import java.awt.*;

public class DrawRectangleStrategy implements IDrawShapeStrategy {

    @Override
    public void draw(Shape shape, PaintCanvas canvas) {

        // Get boundary rectangle from shape
        Rectangle rectangle = shape.getBoundary();

        // Draw rectangle
        Graphics2D canvasGraphics = canvas.getGraphics2D();
        canvasGraphics.setColor(Color.BLACK);
        canvasGraphics.draw(rectangle);

    }



}
