package mud.locations;

import mud.actions.Action;
import mud.gui.EntityList;
import mud.items.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Room implements Serializable {

    private String uniqueRoomId;
    private String roomName;

    private EntityList entities;
    private ArrayList<Item> items;
    private ArrayList<Room> connectingRooms;
    private ArrayList<Action> connectingRoomsEntryActions;


    public Room(String uniqueRoomId,
                String roomName,
                EntityList entities,
                ArrayList<Item> items,
                ArrayList<Room> connectingRooms,
                ArrayList<Action> connectingRoomsEntryActions) {

        this.uniqueRoomId = uniqueRoomId;
        this.roomName = roomName;

        this.entities = entities;
        this.items = items;
        this.connectingRooms = connectingRooms;
        this.connectingRoomsEntryActions = connectingRoomsEntryActions;

    }

    public String getUniqueRoomId() {
        return uniqueRoomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public EntityList getEntities() {
        return entities;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Room> getConnectingRooms() {
        return connectingRooms;
    }

    public ArrayList<Action> getConnectingRoomsEntryActions() {
        return connectingRoomsEntryActions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return Objects.equals(uniqueRoomId, room.uniqueRoomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueRoomId);
    }

}
