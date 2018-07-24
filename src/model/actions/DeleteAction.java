package model.actions;

import model.ShapeListManager;
import model.commands.DeleteCommand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class DeleteAction extends AbstractAction {

    private final ShapeListManager shapeListManager;

    public DeleteAction(ShapeListManager shapeListManager) {
        this.shapeListManager = shapeListManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        DeleteCommand deleteCommand = new DeleteCommand(shapeListManager);

        try {
            deleteCommand.run();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
