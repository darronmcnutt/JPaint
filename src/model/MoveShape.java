package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.io.IOException;

public class MoveShape implements ICommand, IUndoable {
    @Override
    public void run() throws IOException {

    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
