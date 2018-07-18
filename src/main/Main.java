package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ClickHandler;
import model.ShapeDrawer;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        PaintCanvas canvas = new PaintCanvas();
        ShapeList shapeList = new ShapeList();
        ShapeDrawer drawer = new ShapeDrawer(shapeList, canvas);
        shapeList.registerObserver(drawer);
        IGuiWindow guiWindow = new GuiWindow(canvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        ClickHandler clickHandler = new ClickHandler(canvas, appState, shapeList);
        controller.setup();
    }
}
