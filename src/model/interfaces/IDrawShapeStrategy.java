package model.interfaces;

import model.dataobjects.Shape;
import view.gui.PaintCanvas;

public interface IDrawShapeStrategy {
    void draw(Shape shape, PaintCanvas canvas);
}
