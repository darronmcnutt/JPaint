package model.actions;

import model.commands.RedoCommand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class RedoAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {

        RedoCommand redoCommand = new RedoCommand();

        try {
            redoCommand.run();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
