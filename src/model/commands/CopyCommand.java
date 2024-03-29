package model.commands;

import model.dataobjects.Shape;
import model.ShapeList;
import model.dataobjects.ShapeListManager;
import model.interfaces.ICommand;

import java.io.IOException;

public class CopyCommand implements ICommand {

    private final ShapeList selectedShapes;
    private final ShapeList clipboard;

    public CopyCommand(ShapeListManager shapeListManager) {
        this.selectedShapes = shapeListManager.getSelectedShapeList();
        this.clipboard = shapeListManager.getClipboard();
    }

    @Override
    public void run() throws IOException {

        // Remove all elements from the clipboard
        clipboard.clear();

        // Copy selected shapes to the clipboard
        for (Shape shape : selectedShapes) {
            clipboard.add(shape);
        }
    }
}
