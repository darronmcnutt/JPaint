package controller;

import model.dataobjects.ShapeListManager;
import model.commands.*;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

import java.io.IOException;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private final ShapeListManager shapeListManager;

    private final UndoCommand undoCommand = new UndoCommand();
    private final RedoCommand redoCommand = new RedoCommand();

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeListManager shapeListManager) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeListManager = shapeListManager;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());

        uiModule.addEvent(EventName.UNDO, () -> {
            try {
                undoCommand.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        uiModule.addEvent(EventName.REDO, () -> {
            try {
                redoCommand.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        uiModule.addEvent(EventName.COPY, () -> {
            try {
                new CopyCommand(shapeListManager).run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        uiModule.addEvent(EventName.PASTE, () -> {
            try {
                new PasteCommand(shapeListManager).run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        uiModule.addEvent(EventName.DELETE, () -> {
            try {
                new DeleteCommand(shapeListManager).run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
