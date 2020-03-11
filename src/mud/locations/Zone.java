package mud.locations;

import java.util.HashMap;
import java.util.Set;

public class Zone {

    private HashMap<String,Room> rooms;





    public boolean addRoomToZone(Room adding) {
        if (rooms.containsKey(adding.getUniqueRoomId())) return false;
        rooms.put(adding.getUniqueRoomId(),adding);
        return true;
    }

    public Set<String> getAllUniqueRoomIds() {
        return rooms.keySet();
    }

    public boolean deleteRoomFromZone(Room room) {
        return rooms.remove(room.getUniqueRoomId(),room);
    }



}
