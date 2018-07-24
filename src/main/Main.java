package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.*;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        // Initialize paint canvas
        PaintCanvas canvas = new PaintCanvas();

        // Initialize shape lists
        ShapeList masterShapeList = new ShapeList();
        ShapeList selectedShapes = new ShapeList();
        ShapeList clipboard = new ShapeList();

        // Initialize shape drawer
        ShapeDrawer drawer = new ShapeDrawer(masterShapeList, canvas);

        // Add observer to the master shape list
        masterShapeList.registerObserver(drawer);

        // Initialize shape list manager
        ShapeListManager shapeListManager = new ShapeListManager(masterShapeList,selectedShapes,clipboard);

        IGuiWindow guiWindow = new GuiWindow(canvas);
        IUiModule uiModule = new Gui(guiWindow);

        ApplicationState appState = new ApplicationState(uiModule);
        StateObserver stateObserver = new StateObserver(appState,shapeListManager);
        appState.registerObserver(stateObserver);

        IJPaintController controller = new JPaintController(uiModule, appState, shapeListManager);
        ClickHandler clickHandler = new ClickHandler(canvas, appState, shapeListManager);
        KeyboardHandler keyboardHandler = new KeyboardHandler(canvas,shapeListManager);
        controller.setup();
    }
}
