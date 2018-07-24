package model.actions;

import model.ShapeListManager;
import model.commands.PasteCommand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class PasteAction extends AbstractAction {

    ShapeListManager shapeListManager;

    public PasteAction(ShapeListManager shapeListManager) {
        this.shapeListManager = shapeListManager;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        PasteCommand pasteCommand = new PasteCommand(shapeListManager);

        try {
            pasteCommand.run();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
