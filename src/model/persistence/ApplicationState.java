package model.persistence;

import model.*;
import model.dataobjects.ShapeConfiguration;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import model.interfaces.IApplicationStateObserver;
import model.interfaces.IApplicationStateSubject;
import view.interfaces.IUiModule;

import java.util.ArrayList;
import java.util.List;

import static model.StartAndEndPointMode.SELECT;

public class ApplicationState implements IApplicationState, IApplicationStateSubject {
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;

    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private StartAndEndPointMode activeStartAndEndPointMode;

    private List<IApplicationStateObserver> stateObservers;

    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        this.stateObservers = new ArrayList<>();
        setDefaults();
    }

    @Override
    public void registerObserver(IApplicationStateObserver observer) {
        stateObservers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (IApplicationStateObserver stateObserver : stateObservers) {
            stateObserver.update(getCurrentShapeConfiguration());
        }
    }

    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
        if (activeStartAndEndPointMode == SELECT) {
            notifyObservers();
        }
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
        if (activeStartAndEndPointMode == SELECT) {
            notifyObservers();
        }
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
        if (activeStartAndEndPointMode == SELECT) {
            notifyObservers();
        }
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeStartAndEndPointMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public StartAndEndPointMode getActiveStartAndEndPointMode() {
        return activeStartAndEndPointMode;
    }

    @Override
    public ShapeConfiguration getCurrentShapeConfiguration() {
        return new ShapeConfiguration(activeShapeType, activePrimaryColor, activeSecondaryColor, activeShapeShadingType);
    }


    private void setDefaults() {
        activeShapeType = ShapeType.ELLIPSE;
        activePrimaryColor = ShapeColor.YELLOW;
        activeSecondaryColor = ShapeColor.BLACK;
        activeShapeShadingType = ShapeShadingType.OUTLINE_AND_FILLED_IN;
        activeStartAndEndPointMode = StartAndEndPointMode.DRAW;
    }


}
