package model;

import model.actions.*;
import view.gui.PaintCanvas;

import javax.swing.*;


public class KeyboardHandler {

    public KeyboardHandler(PaintCanvas canvas, ShapeListManager shapeListManager) {

        // Create action wrappers for commands
        AbstractAction copyAction = new CopyAction(shapeListManager);
        AbstractAction pasteAction = new PasteAction(shapeListManager);
        AbstractAction undoAction = new UndoAction();
        AbstractAction redoAction = new RedoAction();
        AbstractAction deleteAction = new DeleteAction(shapeListManager);

        // Generate input and action maps for key bindings
        canvas.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control C"), "Copy");
        canvas.getActionMap().put("Copy", copyAction);

        canvas.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control V"), "Paste");
        canvas.getActionMap().put("Paste", pasteAction);

        canvas.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control Z"), "Undo");
        canvas.getActionMap().put("Undo", undoAction);

        canvas.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control Y"), "Redo");
        canvas.getActionMap().put("Redo", redoAction);

        canvas.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DELETE"), "Delete");
        canvas.getActionMap().put("Delete", deleteAction);

    }
}
