package model;

import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import view.gui.PaintCanvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ClickHandler extends MouseAdapter {

    private final PaintCanvas canvas;
    private final IApplicationState appState;
    private final ShapeList shapeList;
    private PairInt clickPoint;
    private PairInt releasePoint;

    public ClickHandler(PaintCanvas canvas, IApplicationState appState, ShapeList shapeList) {
        this.appState = appState;
        this.shapeList = shapeList;
        this.canvas = canvas;
        canvas.addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clickPoint = new PairInt(e.getX(), e.getY());
        System.out.println(clickPoint);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        releasePoint = new PairInt(e.getX(), e.getY());
        System.out.println(releasePoint);

        StartAndEndPointMode startAndEndPointMode =
                appState.getActiveStartAndEndPointMode();

        ICommand command;

        switch(startAndEndPointMode) {
            case DRAW:
                ShapeConfiguration shapeConfiguration = appState.getCurrentShapeConfiguration();
                command = new CreateShape(clickPoint,releasePoint,shapeConfiguration,shapeList);
                break;
            case MOVE:
                command = new MoveShapes();
                break;
            case SELECT:
                command = new SelectShapes();
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
