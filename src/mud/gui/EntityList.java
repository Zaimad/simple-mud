package mud.gui;

import mud.entities.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class EntityList implements Iterable<String> {

    private ArrayList<String> entityNames;
    private ArrayList<Entity> entityObjects;

    public EntityList(ArrayList<String> entityNames, ArrayList<Entity> entity) {
        this.entityNames = entityNames;
        this.entityObjects = entity;
    }

    public boolean removeEntity(String name) {
        int index = entityNames.indexOf(name);
        if (index < 0) return false;
        entityNames.remove(index);
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
        entityObjects.add(entity);
        return true;
    }

    @Override
    public Iterator<String> iterator() {
        return entityNames.iterator();
    }

    /**
     * This method is correctly implemented, afaik.
     * @return a new EntityList with cloned properties
     */
    public EntityList clone() {
        ArrayList<String> namesList = new ArrayList<>();
        Collections.copy(namesList,entityNames);
        ArrayList<Entity> entitiesList = new ArrayList<>();
        Collections.copy(entitiesList,entityObjects);
        return new EntityList(namesList,entitiesList);
    }

}
