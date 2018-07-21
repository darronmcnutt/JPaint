package model.fillstrategies;

import model.interfaces.IFillStrategy;

import java.awt.*;
import java.awt.Shape;

public class OutlineFilledStrategy implements IFillStrategy {
    @Override
    public void draw(Shape shape, Color primaryColor, Color secondaryColor, Graphics2D canvasGraphics) {
        canvasGraphics.setColor(primaryColor);
        canvasGraphics.fill(shape);
        canvasGraphics.setColor(secondaryColor);
        canvasGraphics.draw(shape);
    }
}
