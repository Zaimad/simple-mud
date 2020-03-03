package mud.gui;

import mud.Room;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ArrayList;

public class GraphicsHandler {

    private final static int PADDING = 10;
    private Rectangle canvas;
    private EntityList entities;
    ArrayList<Rectangle> entityShapes;

    public GraphicsHandler() {
        canvas = new Rectangle(PADDING,PADDING,600,400);
        entities = new EntityList(new ArrayList<>(), new ArrayList<>());
    }

    public void redraw() {
        canvas.draw();
        for (int i = 0; i < entities.size(); i++) {
            entityShapes.get(i).delete();
            entityShapes.get(i).fill();
        }

    }


}
