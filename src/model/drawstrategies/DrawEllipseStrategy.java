package model.drawstrategies;

import model.dataobjects.Shape;
import model.ShapeShadingType;
import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShading;
import model.shading.ShadingFactory;
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

        // Unpack rectangle width and height
        double width = rectangle.getWidth();
        double height = rectangle.getHeight();

        // Unpack shape configuration
        Color primaryColor = shape.getPrimaryColor();
        Color secondaryColor = shape.getSecondaryColor();
        ShapeShadingType shadingType = shape.getShading();

        // Create ellipse
        Ellipse2D.Double ellipse = new Ellipse2D.Double(startX, startY, width, height);

        // Get canvas graphics
        Graphics2D canvasGraphics = canvas.getGraphics2D();

        // Draw ellipse
        IShading shading = ShadingFactory.getShading(shadingType);
        shading.draw(ellipse,primaryColor,secondaryColor,canvasGraphics);

        //IFillStrategy fillStrategy = FillStrategyFactory.getShading(shading);
        //fillStrategy.draw(ellipse,primaryColor,secondaryColor,canvasGraphics);
    }
}
