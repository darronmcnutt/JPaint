package model.actions;

import model.ShapeListManager;
import model.commands.CopyCommand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class CopyAction extends AbstractAction {

    ShapeListManager shapeListManager;

    public CopyAction(ShapeListManager shapeListManager) {
        this.shapeListManager = shapeListManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        CopyCommand copyCommand = new CopyCommand(shapeListManager);

        try {
            copyCommand.run();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
