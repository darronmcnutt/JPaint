package model;

import model.interfaces.IDrawShapeStrategy;
import view.gui.PaintCanvas;
import java.awt.*;

public class DrawRectangleStrategy implements IDrawShapeStrategy {

    @Override
    public void draw(Shape shape, PaintCanvas canvas) {
        PairInt startPoint = shape.getStartPoint();
        PairInt endPoint = shape.getEndPoint();

        // Unpack start and end points
        int startX = startPoint.getX();
        int startY = startPoint.getY();

        int endX = endPoint.getX();
        int endY = endPoint.getY();

        // Swap start and end points if necessary
        if (endX < startX) {
            int temp = endX;
            endX = startX;
            startX = temp;
        }

        if (endY < startY) {
            int temp = endY;
            endY = startY;
            startY = temp;
        }

        // Calculate
        int width = endX - startX;
        int height = endY - startY;

        Graphics2D graphics2D = canvas.getGraphics2D();
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(startX,startY,width,height);

    }



}
