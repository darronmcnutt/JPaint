package model;

import model.interfaces.IDrawShapeStrategy;
import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class DrawEllipseStrategy implements IDrawShapeStrategy {

    @Override
    public void draw(Shape shape, PaintCanvas canvas) {

        // Unpack start point
        int startX = shape.getRectX();
        int startY = shape.getRectY();

        // Get rectangle width and height
        int width = shape.getRectWidth();
        int height = shape.getRectHeight();

        Graphics2D canvasGraphics = canvas.getGraphics2D();
        canvasGraphics.setColor(Color.BLACK);
        canvasGraphics.fill(new Ellipse2D.Double(startX,startY,width,height));
    }
}
