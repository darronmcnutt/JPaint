package model;

public class ShapeListManager {
    private final ShapeList masterShapeList;
    private final ShapeList selectedShapeList;
    private final ShapeList clipboard;

    public ShapeListManager(ShapeList masterShapeList, ShapeList selectedShapeList, ShapeList clipboard) {
        this.masterShapeList = masterShapeList;
        this.selectedShapeList = selectedShapeList;
        this.clipboard = clipboard;
    }

    public ShapeList getMasterShapeList() {
        return masterShapeList;
    }

    public ShapeList getSelectedShapeList() {
        return selectedShapeList;
    }

    public ShapeList getClipboard() {
        return clipboard;
    }
}
