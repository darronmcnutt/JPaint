package model.dataobjects;

import model.ShapeShadingType;
import model.ShapeType;
import model.utilities.RectangleGenerator;
import model.utilities.ShapeColorMap;

import java.awt.*;

public class Shape {

    // Start and end point captured from mouse
    private final PairInt startPoint;
    private final PairInt endPoint;

    // Shape configuration from UI
    private final ShapeConfiguration shapeConfiguration;
    private final ShapeType type;
    private final Color primaryColor;
    private final Color secondaryColor;
    private final ShapeShadingType shading;

    // Shape boundary rectangle
    private final Rectangle boundary;

    public Shape(PairInt startPoint, PairInt endPoint, ShapeConfiguration shapeConfiguration) {

        // Initialize fields
        this.startPoint = startPoint;
        this.endPoint = endPoint;

        // Configure shape boundary rectangle
        this.boundary = RectangleGenerator.generate(startPoint,endPoint);

        // Unpack shapeConfiguration into fields and convert enum to Color
        this.shapeConfiguration = shapeConfiguration;
        this.type = shapeConfiguration.getShapeType();
        this.primaryColor = ShapeColorMap.get(shapeConfiguration.getPrimaryColor());
        this.secondaryColor = ShapeColorMap.get(shapeConfiguration.getSecondaryColor());
        this.shading = shapeConfiguration.getShadingType();
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

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public ShapeShadingType getShading() {
        return shading;
    }

    public Rectangle getBoundary() { return boundary; }

    public ShapeConfiguration getShapeConfiguration() { return shapeConfiguration; }
}
