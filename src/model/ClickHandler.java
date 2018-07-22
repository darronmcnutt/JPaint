package model;

import model.commands.CreateShape;
import model.commands.MoveShape;
import model.commands.SelectShape;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import view.gui.PaintCanvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ClickHandler extends MouseAdapter {

    private final PaintCanvas canvas;
    private final IApplicationState appState;
    private final ShapeListManager shapeListManager;
    private ShapeList masterShapeList;
    private PairInt clickPoint;
    private PairInt releasePoint;

    public ClickHandler(PaintCanvas canvas, IApplicationState appState, ShapeListManager shapeListManager) {
        this.appState = appState;
        this.shapeListManager = shapeListManager;
        this.masterShapeList = shapeListManager.getMasterShapeList();
        this.canvas = canvas;
        canvas.addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clickPoint = new PairInt(e.getX(), e.getY());
        if (e.getButton() == MouseEvent.BUTTON3) {
            System.out.println("Right click");
        }
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
                command = new CreateShape(clickPoint,releasePoint,shapeConfiguration,masterShapeList);
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
