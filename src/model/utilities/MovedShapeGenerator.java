package model.utilities;

import model.dataobjects.PairInt;
import model.dataobjects.Shape;

public class MovedShapeGenerator {
    public static Shape generate (Shape shape, PairInt startMove, PairInt endMove) {

        // Unpack points
        int startX = startMove.getX();
        int startY = startMove.getY();
        int endX = endMove.getX();
        int endY = endMove.getY();

        // Calculate new start and endpoints
        int xDiff = endX - startX;
        int yDiff = endY - startY;

        // Generate new pairs
        startMove = new PairInt(shape.getStartPoint().getX() + xDiff,
                shape.getStartPoint().getY() + yDiff);
        endMove = new PairInt(shape.getEndPoint().getX() + xDiff,
                shape.getEndPoint().getY() + yDiff);

        // Generate new shape with updated start and end points
        return new Shape(startMove,endMove,shape.getShapeConfiguration());

    }
}
