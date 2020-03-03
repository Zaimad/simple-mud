package mud.gui;

import mud.entities.Entity;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;

public class EntityList implements Iterable<String> {

    ArrayList<String> entityNames;
    ArrayList<Entity> entityObjects;

    public EntityList(ArrayList<String> entityNames, ArrayList<Entity> entity) {
        this.entityNames = entityNames;
        //this.entityShapes = entityShapes;
        this.entityObjects = entity;
    }

    public boolean removeEntity(String name) {
        int index = entityNames.indexOf(name);
        if (index < 0) return false;
        entityNames.remove(index);
        //entityShapes.remove(index);
        entityObjects.remove(index);
        return true;
    }

    public int size() {
        return entityNames.size();
    }

    public ArrayList<String> getEntityNames() {
        return entityNames;
    }

    public ArrayList<Entity> getEntityObjects() {
        return entityObjects;
    }

    /**
     * This method assumes that the ArrayList.add(Object) method is consistent in its placement for indexing purposes.
     * Also, it checks if the name is already in the list before adding anything.
     */
    public boolean addEntity(String name, Entity entity) {
        if (entityNames.contains(name)) return false;
        entityNames.add(name);
        //entityShapes.add(shape);
        entityObjects.add(entity);
        return true;
    }

    @Override
    public Iterator<String> iterator() {
        return entityNames.iterator();
    }

    public EntityList clone() {
        return new EntityList(entityNames,entityObjects);
    }

}
