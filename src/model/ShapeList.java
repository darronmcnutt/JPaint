package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShapeList implements Iterable<Shape> {

    private List<Shape> shapes;
    private ShapeDrawer drawer;

    public ShapeList() {
        shapes = new ArrayList<Shape>();
    }

    public void registerObserver(ShapeDrawer drawer) {
        this.drawer = drawer;
    }

    public void add(Shape shape) {
        shapes.add(shape);
        if (drawer != null) { drawer.update(); }
    }

    public void remove(Shape shape) {
        shapes.remove(shape);
        if (drawer != null) { drawer.update(); }
    }

    public void clear() {
        shapes.clear();
        if (drawer != null) { drawer.update(); }
    }

    @Override
    public Iterator<Shape> iterator() {
        return shapes.iterator();
    }
}
