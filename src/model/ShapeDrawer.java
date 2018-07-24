package model;

import model.dataobjects.Shape;
import model.drawstrategies.DrawShapeStrategyFactory;
import model.interfaces.IDrawShapeStrategy;
import view.gui.PaintCanvas;

import java.awt.*;

public class ShapeDrawer {
    private final ShapeList shapeList;
    private final PaintCanvas canvas;

    public ShapeDrawer(ShapeList shapeList, PaintCanvas canvas) {
        this.shapeList = shapeList;
        this.canvas = canvas;
    }

    public void update() {

        // Erase the canvas
        Graphics2D canvasGraphics = canvas.getGraphics2D();
        canvasGraphics.setColor(Color.WHITE);
        canvasGraphics.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        // Draw all shapes from the shape list
        for(Shape shape : shapeList) {
            IDrawShapeStrategy drawStrategy = DrawShapeStrategyFactory.getStrategy(shape);
            drawStrategy.draw(shape,canvas);
        }
    }


}
