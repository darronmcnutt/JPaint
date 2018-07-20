package model;

import model.interfaces.IDrawShapeStrategy;
import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class DrawEllipseStrategy implements IDrawShapeStrategy {

    @Override
    public void draw(Shape shape, PaintCanvas canvas) {

        // Get boundary rectangle from shape
        Rectangle rectangle = shape.getBoundary();

        // Unpack start point
        double startX = rectangle.getX();
        double startY = rectangle.getY();

        // Get rectangle width and height
        double width = rectangle.getWidth();
        double height = rectangle.getHeight();

        // Create ellipse
        Ellipse2D.Double ellipse = new Ellipse2D.Double(startX,startY,width,height);

        Graphics2D canvasGraphics = canvas.getGraphics2D();
        canvasGraphics.setColor(Color.BLACK);
        canvasGraphics.fill(ellipse);
    }
}
