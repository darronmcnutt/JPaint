package model.commands;

import model.CommandHistory;
import model.interfaces.ICommand;

import java.io.IOException;

public class RedoCommand implements ICommand {

    @Override
    public void run() throws IOException {
        CommandHistory.redo();
    }
}
