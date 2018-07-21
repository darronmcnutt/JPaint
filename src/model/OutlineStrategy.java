package model;

import model.interfaces.IFillStrategy;

import java.awt.*;
import java.awt.Shape;

public class OutlineStrategy implements IFillStrategy {

    @Override
    public void draw(Shape shape, Color primaryColor, Color secondaryColor, Graphics2D canvasGraphics) {
        canvasGraphics.setColor(secondaryColor);
        canvasGraphics.draw(shape);
    }
}
