package model.shading;

import model.interfaces.IShading;

import java.awt.*;

public class Outline implements IShading {
    @Override
    public void draw(Shape shape, Color primaryColor, Color secondaryColor, Graphics2D canvasGraphics) {
        canvasGraphics.setColor(secondaryColor);
        canvasGraphics.draw(shape);
    }
}
