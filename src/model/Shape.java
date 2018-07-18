package model;

public class Shape {
    private PairInt startPoint;
    private PairInt endPoint;
    private ShapeType type;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shading;

    public Shape(PairInt startPoint, PairInt endPoint, ShapeConfiguration shapeConfiguration) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;

        //Unpack shapeConfiguration into fields
        this.type = shapeConfiguration.getShapeType();
        this.primaryColor = shapeConfiguration.getPrimaryColor();
        this.secondaryColor = shapeConfiguration.getSecondaryColor();
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

    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }

    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    public ShapeShadingType getShading() {
        return shading;
    }
}
