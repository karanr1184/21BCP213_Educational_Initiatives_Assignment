public class CancelCommand implements Command {
    private Room room;

    public CancelCommand(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        room.cancelBooking();
    }
}
