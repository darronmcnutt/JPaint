package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.*;
import model.dataobjects.ShapeListManager;
import model.inputhandlers.ClickHandler;
import model.inputhandlers.KeyboardHandler;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){

        // Initialize paint canvas
        PaintCanvas canvas = new PaintCanvas();

        // Initialize shape lists
        ShapeList masterShapeList = new ShapeList();
        ShapeList selectedShapes = new ShapeList();
        ShapeList clipboard = new ShapeList();

        // Initialize shape list manager
        ShapeListManager shapeListManager = new ShapeListManager(masterShapeList,selectedShapes,clipboard);

        // Initialize shape drawer
        ShapeDrawer drawer = new ShapeDrawer(masterShapeList, canvas);

        // Add observer to the master shape list
        masterShapeList.registerObserver(drawer);

        // Initialize gui
        IGuiWindow guiWindow = new GuiWindow(canvas);
        IUiModule uiModule = new Gui(guiWindow);

        // Initialize application state and register observer
        ApplicationState appState = new ApplicationState(uiModule);
        ShapeConfigObserver shapeConfigObserver = new ShapeConfigObserver(shapeListManager);
        appState.registerObserver(shapeConfigObserver);

        // Initialize the controller
        IJPaintController controller = new JPaintController(uiModule, appState, shapeListManager);

        // Initialize input handlers
        ClickHandler clickHandler = new ClickHandler(canvas, appState, shapeListManager);
        KeyboardHandler keyboardHandler = new KeyboardHandler(canvas,shapeListManager);

        // Start the controller
        controller.setup();
    }
}
