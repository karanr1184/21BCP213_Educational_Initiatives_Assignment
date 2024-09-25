import java.util.HashMap;
import java.util.Map;

public class OfficeManager {
    private static OfficeManager instance;
    private final Map<String, Room> rooms;

    private OfficeManager() {
        rooms = new HashMap<>();
    }

    public static synchronized OfficeManager getInstance() {
        if (instance == null) {
            instance = new OfficeManager();
        }
        return instance;
    }

    public void configureOffice(int numberOfRooms) {
        for (int i = 1; i <= numberOfRooms; i++) {
            String roomId = "Room" + i;
            rooms.put(roomId, new Room(roomId));
        }
    }

    public Room getRoom(String roomId) {
        return rooms.get(roomId);
    }

    public void showRoomUsage() {
        for (Room room : rooms.values()) {
            System.out.println(room);
        }
    }
}
