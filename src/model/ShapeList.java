package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeList {

    final private List<Shape> shapes;

    public ShapeList() {
        shapes = new ArrayList<Shape>();
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }


}
