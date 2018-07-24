package model;

import model.dataobjects.Shape;
import model.interfaces.IShapeListObserver;
import model.interfaces.IShapeListSubject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShapeList implements Iterable<Shape>, IShapeListSubject {

    private List<Shape> shapes;
    private List<IShapeListObserver> observers;

    public ShapeList() {
        shapes = new ArrayList<Shape>();
        observers = new ArrayList<IShapeListObserver>();
    }

    public void registerObserver(IShapeListObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IShapeListObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (IShapeListObserver observer : observers) {
            observer.update();
        }
    }

    public void add(Shape shape) {
        shapes.add(shape);
        notifyObservers();
    }

    public void remove(Shape shape) {
        shapes.remove(shape);
        notifyObservers();
    }

    public void clear() {
        shapes.clear();
        notifyObservers();
    }

    @Override
    public Iterator<Shape> iterator() {
        return shapes.iterator();
    }
}
