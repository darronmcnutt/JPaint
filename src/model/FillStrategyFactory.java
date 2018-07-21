package model;

import model.interfaces.IFillStrategy;

public class FillStrategyFactory {
    public static IFillStrategy getStrategy(ShapeShadingType shadingType) {

        IFillStrategy strategy = null;

        switch (shadingType) {
            case FILLED_IN:
                strategy = new FilledInStrategy();
                break;
            case OUTLINE:
                strategy = new OutlineStrategy();
                break;
            case OUTLINE_AND_FILLED_IN:
                strategy = new OutlineFilledStrategy();
                break;
        }
        return strategy;
    }
}
