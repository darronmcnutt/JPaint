package model;

import model.interfaces.IDrawShapeStrategy;
import view.gui.PaintCanvas;

public class ShapeDrawer {
    private final ShapeList shapeList;
    private final PaintCanvas canvas;

    public ShapeDrawer(ShapeList shapeList, PaintCanvas canvas) {
        this.shapeList = shapeList;
        this.canvas = canvas;
    }

    public void update() {
        for(Shape shape : shapeList) {
            IDrawShapeStrategy strategy = DrawShapeStrategyFactory.getStrategy(shape);
            strategy.draw(shape,canvas);
        }
    }


}
