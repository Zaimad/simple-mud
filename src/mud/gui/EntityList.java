package mud.gui;

import mud.entities.Entity;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;

public class EntityList implements Iterable<String> {

    ArrayList<String> entityNames;
    ArrayList<Rectangle> entityShapes;
    ArrayList<Entity> entityObjects;

    public EntityList(ArrayList<String> entityNames, ArrayList<Rectangle> entityShapes, ArrayList<Entity> entity) {
        this.entityNames = entityNames;
        this.entityShapes = entityShapes;
        this.entityObjects = entity;
    }

    public boolean removeEntity(String name) {
        int index = entityNames.indexOf(name);
        if (index < 0) return false;
        entityNames.remove(index);
        entityShapes.remove(index);
        entityObjects.remove(index);
        return true;
    }

    /**
     * This method assumes that the ArrayList.add(Object) method is consistent in its placement for indexing purposes.
     * Also, it checks if the name is already in the list before adding anything.
     */
    public boolean addEntity(String name, Rectangle shape, Entity entity) {
        if (entityNames.contains(name)) return false;
        entityNames.add(name);
        entityShapes.add(shape);
        entityObjects.add(entity);
        return true;
    }

    @Override
    public Iterator<String> iterator() {
        return entityNames.iterator();
    }

    public EntityList clone() {
        return new EntityList(entityNames,entityShapes,entityObjects);
    }

}
