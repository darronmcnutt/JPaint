package model.interfaces;

import java.awt.*;

public interface IFillStrategy {
    void draw (Shape shape, Color primaryColor,
                      Color secondaryColor, Graphics2D canvasGraphics);
}
