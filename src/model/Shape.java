package model;

import java.awt.*;

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
    private int rectX;
    private int rectY;
    private int rectWidth;
    private int rectHeight;

    public Shape(PairInt startPoint, PairInt endPoint, ShapeConfiguration shapeConfiguration) {

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

        this.rectX = startX;
        this.rectY = startY;
        this.rectWidth = endX - startX;
        this.rectHeight = endY - startY;

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

    public int getRectX() { return rectX; }

    public int getRectY() { return rectY; }

    public int getRectWidth() { return rectWidth; }

    public int getRectHeight() { return rectHeight; }
}
