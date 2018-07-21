package model;

import java.awt.Rectangle;

public class RectangleGenerator {
    public static Rectangle generate (PairInt startPoint, PairInt endPoint) {

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

        int width = endX - startX;
        int height = endY - startY;

        return new Rectangle(startX,startY,width,height);
    }
}
