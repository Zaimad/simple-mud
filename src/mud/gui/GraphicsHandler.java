package mud.gui;

import mud.Room;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ArrayList;

public class GraphicsHandler extends Room {

    private final static int PADDING = 10;
    private Rectangle canvas;
    private EntityList entities;

    public GraphicsHandler() {
        canvas = new Rectangle(PADDING,PADDING,600,400);
        entities = new EntityList(new ArrayList<>(), new ArrayList<>());
    }

    public void redraw() {
        canvas.draw();
        for (Rectangle shape : entities) {
            shape.delete();
            shape.fill();
        }
    }


}
