// Smart Office Facility Programming Exercise
import java.util.Scanner;

public class SmartOfficeApp {
    public static void main(String[] args) {
        OfficeManager officeManager = OfficeManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        // Office configuration
        System.out.print("Enter the number of rooms in the office: ");
        int numberOfRooms = scanner.nextInt();
        officeManager.configureOffice(numberOfRooms);

        // Add lights and air conditioning as observers to rooms
        for (int i = 1; i <= numberOfRooms; i++) {
            Room room = officeManager.getRoom("Room" + i);
            room.addObserver(new Lights());
            room.addObserver(new AirConditioning());
        }

        while (true) {
            System.out.println("\nSmart Office Management:");
            System.out.println("1. Book a room");
            System.out.println("2. Cancel room booking");
            System.out.println("3. Occupy room");
            System.out.println("4. Vacate room");
            System.out.println("5. Show room usage statistics");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter room number to book: ");
                    String bookRoomId = scanner.next();
                    Room bookRoom = officeManager.getRoom("Room" + bookRoomId);
                    new BookingCommand(bookRoom).execute();
                    break;
                case 2:
                    System.out.print("Enter room number to cancel booking: ");
                    String cancelRoomId = scanner.next();
                    Room cancelRoom = officeManager.getRoom("Room" + cancelRoomId);
                    new CancelCommand(cancelRoom).execute();
                    break;
                case 3:
                    System.out.print("Enter room number to occupy: ");
                    String occupyRoomId = scanner.next();
                    Room occupyRoom = officeManager.getRoom("Room" + occupyRoomId);
                    occupyRoom.occupyRoom();
                    break;
                case 4:
                    System.out.print("Enter room number to vacate: ");
                    String vacateRoomId = scanner.next();
                    Room vacateRoom = officeManager.getRoom("Room" + vacateRoomId);
                    vacateRoom.vacateRoom();
                    break;
                case 5:
                    officeManager.showRoomUsage();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
