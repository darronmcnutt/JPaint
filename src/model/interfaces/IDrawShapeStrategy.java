package model.interfaces;

import model.Shape;
import view.gui.PaintCanvas;

public interface IDrawShapeStrategy {
    void draw(Shape shape, PaintCanvas canvas);
}
