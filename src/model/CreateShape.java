package model;

import model.interfaces.ICommand;

import java.io.IOException;

public class CreateShape implements ICommand {
    private final PairInt startPoint;
    private final PairInt endPoint;
    private final ShapeConfiguration shapeConfiguration;
    private final ShapeList shapeList;

    public CreateShape(PairInt startPoint, PairInt endPoint, ShapeConfiguration shapeConfiguration, ShapeList shapeList) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeConfiguration = shapeConfiguration;
        this.shapeList = shapeList;
    }

    @Override
    public void run() throws IOException {
        Shape shape = new Shape(startPoint,endPoint,shapeConfiguration);
        shapeList.add(shape);
    }
}
