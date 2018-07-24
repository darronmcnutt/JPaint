package model.drawstrategies;

import model.dataobjects.Shape;
import model.ShapeType;
import model.interfaces.IDrawShapeStrategy;

public class DrawShapeStrategyFactory {
    public static IDrawShapeStrategy getStrategy(Shape shape) {
        ShapeType type = shape.getType();
        IDrawShapeStrategy strategy = null;
        switch(type) {
            case ELLIPSE:
                strategy = new DrawEllipseStrategy();
                break;
            case TRIANGLE:
                strategy = new DrawTriangleStrategy();
                break;
            case RECTANGLE:
                strategy = new DrawRectangleStrategy();
                break;
        }
        return strategy;
    }
}
