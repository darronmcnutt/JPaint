package model.drawstrategies;

import model.dataobjects.Shape;
import model.ShapeShadingType;
import model.fillstrategies.FillStrategyFactory;
import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IFillStrategy;
import model.interfaces.IShading;
import model.shading.ShadingFactory;
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

        // Unpack shape configuration
        Color primaryColor = shape.getPrimaryColor();
        Color secondaryColor = shape.getSecondaryColor();
        ShapeShadingType shadingType = shape.getShading();

        // Construct the triangle
        GeneralPath triangle = new GeneralPath();
        triangle.moveTo(startX, startY);
        triangle.lineTo(endX, endY);
        triangle.lineTo(startX, endY);
        triangle.lineTo(startX, startY);

        // Get canvas graphics
        Graphics2D canvasGraphics = canvas.getGraphics2D();

        // Draw triangle
        IShading shading = ShadingFactory.getShading(shadingType);
        shading.draw(triangle,primaryColor,secondaryColor,canvasGraphics);

        //IFillStrategy fillStrategy = FillStrategyFactory.getStrategy(shading);
        //fillStrategy.draw(triangle,primaryColor,secondaryColor,canvasGraphics);
    }
}
