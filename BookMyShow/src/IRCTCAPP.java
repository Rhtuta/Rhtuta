import java.util.List;
import java.util.Scanner;

public class IRCTCAPP {
    private final Scanner sc= new Scanner(System.in);

    private final BookingService bookingService = new BookingService();

    private final UserService userService = new UserService();

    public static void main(String[] args) {
        new IRCTCAPP().start();
    }

    private void start()
    {

        while (true)
        {

            if (!userService.isLoggedIn())
            {
                System.out.println();
                System.out.println("----Welcome to IRCTC APP!----");
                System.out.println();
                System.out.println("1 -> Register");
                System.out.println("2 -> Login");
                System.out.println("3 -> Exit");
                System.out.print("\nEnter your choice: ");
                int choice = sc.nextInt();
                switch (choice)
                {
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> Exit();
                    default -> System.out.println("Invalid choice");
                }
            }
            else
            {
                showUserMenu();
            }
        }
    }

    private void register()
    {
        System.out.print("Enter your username: ");
        String username = sc.next();
        System.out.print("Enter your password: ");
        String password = sc.next();
        System.out.print("Enter your fullname: ");
        String fullname = sc.next();
        System.out.print("Enter your contact no: ");
        String contact = sc.next();
        userService.registerUser(username,password,fullname,contact);
    }

    private void login(){
        System.out.print("Enter your username: ");
        String username = sc.next();
        System.out.print("Enter your password: ");
        String password = sc.next();
        userService.loginUser(username,password);
    }
    private void Exit()
    {
        System.out.println("Thank for using IRCTC APP!");
        System.exit(0);
    }

    private void showUserMenu(){
        while (userService.isLoggedIn())
        {
            System.out.println();
            System.out.println("----User Menu----");
            System.out.println("1 -> Search Train");
            System.out.println("2 -> Book Ticket");
            System.out.println("3 -> view all Trains");
            System.out.println("4 -> view my tickets");
            System.out.println("5 -> cancel ticket");
            System.out.println("6 -> logout");
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1 -> searchTrain();
                case 2 -> bookTicket();
                case 3 -> bookingService.listAllTrains();
                case 4 -> viewMyTickets();
                case 5 -> cancelTicket();
                case 6 -> userService.logOutUser();
                default -> System.out.println("Invalid choice");
            }
        }
    }
    private void searchTrain()
    {
        System.out.print("\nEnter your source station: ");
        String source = sc.next();
        System.out.print("Enter your destination station: ");
        String destination = sc.next();
        List<Train> trains  = bookingService.searchTrain(source,destination);
        if (trains.isEmpty())
        {
            System.out.println("No trains found between "+source+" and "+destination);
            return;
        }
        System.out.println("Train found!");
        for (Train train: trains)
        {
            System.out.println(train);
        }
        System.out.print("\nDo you want to book ticket: yes/no: ");
        String choice = sc.next();
        if (choice.equalsIgnoreCase("yes"))
        {
            System.out.print("\nEnter your train Id to book: ");
            int trainId = sc.nextInt();
            System.out.print("Enter no of seats to book ticket: ");
            int seat = sc.nextInt();
            Ticket ticket = bookingService.bookTicket(userService.getCurrentUser(),trainId,seat);
            if (ticket!= null)
            {
                System.out.println("Booked succesfully!");
                System.out.println(ticket);
            }
            else
            {
                System.out.println("Seats not available for this train!");
            }
        }
        else
        {
            System.out.println("Returning to main menu!");
        }
    }

    private void bookTicket(){
        System.out.print("\nEnter your source station: ");
        String source = sc.next();
        System.out.print("Enter your destination station: ");
        String destination = sc.next();
        List<Train> trains  = bookingService.searchTrain(source,destination);
        if (trains.isEmpty())
        {
            System.out.println("No trains available for booking between "+source+" and "+destination);
            return;
        }
        System.out.println("Available trains!");
        for (Train train: trains)
        {
            System.out.println(train);
        }
        System.out.print("\nEnter your train Id to book: ");
        int trainId = sc.nextInt();
        System.out.print("Enter no of seats to book ticket: ");
        int seat = sc.nextInt();
        Ticket ticket = bookingService.bookTicket(userService.getCurrentUser(),trainId,seat);
        if (ticket!= null)
        {
            System.out.println("Ticket Booked succesfully!");
            System.out.println(ticket);
        }
        else
        {
            System.out.println("Seats not available for this train!");
        }
    }

    private void viewMyTickets(){
        System.out.println();
        List<Ticket> tickets = bookingService.getTicketByUser(userService.getCurrentUser());
        if (tickets.isEmpty()){
            System.out.println("No tickets booked yet!");
        }
        else
        {
            for (Ticket ticket: tickets)
            {
                System.out.println(ticket);
            }
        }
    }

    private void cancelTicket()
    {
        System.out.print("\nEnter ticketId to cancel: ");
        int ticketId = sc.nextInt();
        boolean isCancelled=bookingService.cancelTicket(ticketId,userService.getCurrentUser());
    }

}
