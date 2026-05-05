import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingService {
    private List<Train> trainList=new ArrayList<>();

    private List<Ticket> ticketList = new ArrayList<>();

    public BookingService(){
        trainList.add(new Train(101,"Shalimar Express    ","Delhi","Goa",100));
        trainList.add(new Train(102,"Golden Temple Mail  ","Yamunanagar","faridabad",100));
        trainList.add(new Train(103,"Golden Temple Mail  ","Faridabad","yamunanagar",100));
        trainList.add(new Train(104,"Chattisgarh Express ","Ambala City","Mathura",100));
        trainList.add(new Train(105,"Una Himachal Express","Balabhgarh","Meerut City",100));
        trainList.add(new Train(106,"madurai SF Express  ","Yamunanagar","faridabad",100));
        trainList.add(new Train(107,"Una Himachal        ","Yamunanagar","faridabad",100));
        trainList.add(new Train(108,"Intercity Express   ","Faridabad","yamunanagar",100));
        trainList.add(new Train(109,"Indore Express      ","Faridabad","yamunanagar",100));
    }

    public List<Train> searchTrain(String source, String destination)
    {
        List<Train> res = new ArrayList<>();
        for(Train train:trainList)
        {
            if (train.getSource().equalsIgnoreCase(source) &&
                    train.getDestination().equalsIgnoreCase(destination))
            {
                res.add(train);
            }
        }
        return res;
    }

    public Ticket bookTicket(User user, int trainId, int seatCount)
    {
        for(Train train : trainList)
        {
            if (train.getTrainId() == trainId)
            {
                if (train.bookSeats(seatCount))
                {
                    Ticket ticket = new Ticket(user,train,seatCount);
                    ticketList.add(ticket);
                    return ticket;
                }
                else
                {
                    System.out.println("not enough seats available!");
                    return null;
                }
            }
        }
        System.out.println("train Id not found!");
        return null;
    }

    public List<Ticket> getTicketByUser(User user)
    {
        List<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket: ticketList)
        {
            if(ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername()))
            {
                tickets.add(ticket);
            }
        }
        return tickets;
    }

    public boolean cancelTicket(int ticketId, User user)
    {
        Iterator<Ticket> ticketIterator = ticketList.listIterator();
        while(ticketIterator.hasNext())
        {
            Ticket ticket = ticketIterator.next();
            if(ticket.getTicketId()==ticketId &&
            ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername()))
            {
                Train train = ticket.getTrain();
                train.cancelSeats(ticket.getSeatBooked());
                ticketIterator.remove();
                System.out.println("Ticket id: "+ticketId+" cancelled successfully!");
                return true;
            }
        }
        System.out.println("Ticket not found or does not belong to current user!");
        return false;
    }

    public void listAllTrains()
    {
        System.out.println();
        System.out.println("list of all trains");
        for (Train train:trainList)
        {
            System.out.println(train);
        }
    }
}
