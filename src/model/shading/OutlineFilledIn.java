package model.shading;

import model.interfaces.IShading;

import java.awt.*;

public class OutlineFilledIn implements IShading {

    private final IShading shading;

    public OutlineFilledIn(IShading shading) {
        this.shading = shading;
    }

    @Override
    public void draw(Shape shape, Color primaryColor, Color secondaryColor, Graphics2D canvasGraphics) {
        shading.draw(shape,primaryColor,secondaryColor,canvasGraphics);
        new Outline().draw(shape,primaryColor,secondaryColor,canvasGraphics);
    }
}
