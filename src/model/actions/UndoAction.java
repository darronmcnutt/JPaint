package model.actions;

import model.commands.UndoCommand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class UndoAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {

        UndoCommand undoCommand = new UndoCommand();

        try {
            undoCommand.run();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
