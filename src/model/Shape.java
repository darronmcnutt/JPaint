package model;

import java.awt.Rectangle;

public class Shape {

    // Start and end point captured from mouse
    private PairInt startPoint;
    private PairInt endPoint;

    // Shape configuration from UI
    private ShapeType type;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shading;

    // Boundary rectangle
    Rectangle boundary;

    public Shape(PairInt startPoint, PairInt endPoint, ShapeConfiguration shapeConfiguration) {

        // Initialize fields
        this.startPoint = startPoint;
        this.endPoint = endPoint;

        // Configure shape boundary rectangle
        configureBoundaryRectangle(startPoint, endPoint);

        // Unpack shapeConfiguration into fields
        this.type = shapeConfiguration.getShapeType();
        this.primaryColor = shapeConfiguration.getPrimaryColor();
        this.secondaryColor = shapeConfiguration.getSecondaryColor();
        this.shading = shapeConfiguration.getShadingType();
    }

    private void configureBoundaryRectangle (PairInt startPoint, PairInt endPoint) {

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

        this.boundary = new Rectangle(startX,startY,width,height);

    }

    public PairInt getStartPoint() {
        return startPoint;
    }

    public PairInt getEndPoint() {
        return endPoint;
    }

    public ShapeType getType() {
        return type;
    }

    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }

    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    public ShapeShadingType getShading() {
        return shading;
    }

    public Rectangle getBoundary() { return boundary; }
}
