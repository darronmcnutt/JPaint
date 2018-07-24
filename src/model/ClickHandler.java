package model;

import model.commands.CreateShape;
import model.commands.MoveShape;
import model.commands.SelectShape;
import model.interfaces.IApplicationState;
import model.interfaces.IClickState;
import model.interfaces.ICommand;
import model.states.LeftClickState;
import model.states.RightClickState;
import view.gui.PaintCanvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ClickHandler extends MouseAdapter {

    private final PaintCanvas canvas;
    private final IApplicationState appState;
    private final ShapeListManager shapeListManager;

    private PairInt clickPoint;
    private PairInt releasePoint;

    private IClickState leftClickState = new LeftClickState();
    private IClickState rightClickState = new RightClickState();
    private IClickState clickState;

    public ClickHandler(PaintCanvas canvas, IApplicationState appState, ShapeListManager shapeListManager) {
        this.appState = appState;
        this.shapeListManager = shapeListManager;
        this.canvas = canvas;
        canvas.addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {

        clickPoint = new PairInt(e.getX(), e.getY());

        // Set state based on right/left mouse button click
        if (e.getButton() == MouseEvent.BUTTON3) {
            clickState = rightClickState;
        } else {
            clickState = leftClickState;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        releasePoint = new PairInt(e.getX(), e.getY());

        StartAndEndPointMode startAndEndPointMode =
                appState.getActiveStartAndEndPointMode();

        ICommand command;

        switch(startAndEndPointMode) {

            case DRAW:
                ShapeConfiguration shapeConfiguration = clickState.getConfiguration(appState);
                command = new CreateShape(clickPoint,releasePoint,shapeConfiguration,shapeListManager);
                break;

            case MOVE:
                command = new MoveShape(clickPoint,releasePoint,shapeListManager);
                break;

            case SELECT:
                command = new SelectShape(clickPoint,releasePoint,shapeListManager);
                break;

            default:
                throw new IllegalStateException();
        }

        try {
            command.run();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

}
