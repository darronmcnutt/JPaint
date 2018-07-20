package model;

import model.interfaces.ICommand;

import java.io.IOException;

public class EmptyCommand implements ICommand {
    @Override
    public void run() throws IOException {

    }
}
