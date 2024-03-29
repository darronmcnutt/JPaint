package model.drawstrategies;

import model.dataobjects.Shape;
import model.ShapeShadingType;
import model.fillstrategies.FillStrategyFactory;
import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IFillStrategy;
import view.gui.PaintCanvas;

import java.awt.*;

public class DrawRectangleStrategy implements IDrawShapeStrategy {

    @Override
    public void draw(Shape shape, PaintCanvas canvas) {

        // Get boundary rectangle from shape
        Rectangle rectangle = shape.getBoundary();

        // Unpack shape configuration
        Color primaryColor = shape.getPrimaryColor();
        Color secondaryColor = shape.getSecondaryColor();
        ShapeShadingType shading = shape.getShading();

        // Get canvas graphics
        Graphics2D canvasGraphics = canvas.getGraphics2D();

        // Draw rectangle
        IFillStrategy fillStrategy = FillStrategyFactory.getStrategy(shading);
        fillStrategy.draw(rectangle,primaryColor,secondaryColor,canvasGraphics);

    }
}
