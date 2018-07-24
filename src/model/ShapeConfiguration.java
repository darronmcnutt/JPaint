package model;

public class ShapeConfiguration {
    private final ShapeType shapeType;
    private final ShapeColor primaryColor;
    private final ShapeColor secondaryColor;
    private final ShapeShadingType shadingType;

    public ShapeConfiguration(ShapeType shapeType, ShapeColor primaryColor, ShapeColor secondaryColor,
                              ShapeShadingType shadingType) {
        this.shapeType = shapeType;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shadingType = shadingType;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }

    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    public ShapeShadingType getShadingType() {
        return shadingType;
    }
}
