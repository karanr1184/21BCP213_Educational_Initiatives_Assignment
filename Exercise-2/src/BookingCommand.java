public class BookingCommand implements Command {
    private Room room;

    // Booking command constructor
    public BookingCommand(Room room) {
        this.room = room;
    }

    // override interface method
    @Override
    public void execute() {
        room.bookRoom();
    }
}
