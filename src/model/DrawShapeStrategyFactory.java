package model;

import model.interfaces.IDrawShapeStrategy;

public class DrawShapeStrategyFactory {
    public static IDrawShapeStrategy getStrategy(Shape shape) {
        ShapeType type = shape.getType();
        IDrawShapeStrategy strategy = null;
        switch(type) {
            case ELLIPSE:
                strategy = new DrawRectangleStrategy(); //FIX
                break;
            case TRIANGLE:
                strategy = new DrawRectangleStrategy(); //FIX
                break;
            case RECTANGLE:
                strategy = new DrawRectangleStrategy();
                break;
            default:
                throw new IllegalStateException();
        }
        return strategy;
    }
}
