package model;

import view.gui.PaintCanvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickDragHandler extends MouseAdapter {

    private final PaintCanvas canvas;
    private PairInt clickPoint;
    private PairInt releasePoint;

    public ClickDragHandler(PaintCanvas canvas) {
        this.canvas = canvas;
        canvas.addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clickPoint = new PairInt(e.getX(), e.getY());
        System.out.println(getClickPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        releasePoint = new PairInt(e.getX(), e.getY());
        System.out.println(getReleasePoint());
    }

    public PairInt getClickPoint() {
        return clickPoint;
    }

    public PairInt getReleasePoint() {
        return releasePoint;
    }
}
