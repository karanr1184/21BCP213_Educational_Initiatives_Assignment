import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Room {
    private final String roomId;
    private boolean isBooked;
    private boolean isOccupied;
    private final List<Observer> observers;

    public Room(String roomId) {
        this.roomId = roomId;
        this.isBooked = false;
        this.isOccupied = false;
        this.observers = new ArrayList<>();
    }

    public void bookRoom() {
        if (!isBooked) {
            this.isBooked = true;
            System.out.println(roomId + " has been booked.");
            // Automatically release booking if not occupied within 5 minutes
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (!isOccupied) {
                        cancelBooking();
                    }
                }
            }, 300000); // 5 minutes in milliseconds
        } else {
            System.out.println(roomId + " is already booked.");
        }
    }

    public void cancelBooking() {
        if (isBooked) {
            this.isBooked = false;
            System.out.println(roomId + " booking has been canceled.");
            notifyObservers("Room is unoccupied. Lights and AC turned off.");
        } else {
            System.out.println(roomId + " is not booked.");
        }
    }

    public void occupyRoom() {
        if (isBooked && !isOccupied) {
            this.isOccupied = true;
            System.out.println(roomId + " is now occupied.");
            notifyObservers("Room is occupied. Lights and AC turned on.");
        } else {
            System.out.println("Room cannot be occupied without a booking.");
        }
    }

    public void vacateRoom() {
        if (isOccupied) {
            this.isOccupied = false;
            System.out.println(roomId + " is now vacant.");
            notifyObservers("Room is vacant. Lights and AC turned off.");
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    @Override
    public String toString() {
        return roomId + " - " + (isBooked ? "Booked" : "Available") + " - " + (isOccupied ? "Occupied" : "Vacant");
    }
}
