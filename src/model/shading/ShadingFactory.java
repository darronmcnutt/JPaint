package model.shading;

import model.ShapeShadingType;
import model.interfaces.IShading;

public class ShadingFactory {
    public static IShading getShading(ShapeShadingType shadingType) {

        IShading shading = null;

        switch (shadingType) {
            case FILLED_IN:
                shading = new FilledIn();
                break;
            case OUTLINE:
                shading = new Outline();
                break;
            case OUTLINE_AND_FILLED_IN:
                shading = new OutlineFilledIn(new FilledIn());
                break;
        }
        return shading;
    }
}
