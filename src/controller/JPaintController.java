package controller;

import model.commands.RedoCommand;
import model.commands.UndoCommand;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

import java.io.IOException;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    private final UndoCommand undoCommand = new UndoCommand();
    private final RedoCommand redoCommand = new RedoCommand();

    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
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
    }
}
