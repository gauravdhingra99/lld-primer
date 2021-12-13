package Service;

import Enums.QueryType;
import Enums.TicketState;
import Model.Ticket;
import Model.User;
import Repository.TicketRepo;
import Repository.UserRepo;

import java.util.HashMap;
import java.util.Map;

import static javafx.scene.input.KeyCode.T;

/**
 * @author gauravdhingra
 */
public class TicketService {

    TicketRepo ticketRepo = new TicketRepo();
    UserRepo userRepo = new UserRepo();

    public int createTicket(String type,String desc){
        if(type.equals(QueryType.CHECK_WALLET_BALANCE.getType())){
            System.out.println("sending sms");
            Ticket ticket = new Ticket(null, TicketState.RESOLVED,"sent automatic SMS to customer",null);
            ticketRepo.save(ticket);
            return ticket.getId();
        }else if(type.equals(QueryType.CHANGE_LANGUAGE.getType())){
            Ticket ticket = new Ticket(null, TicketState.RESOLVED,"automatic IVR call made to the" +
                    "customer",null);
            ticketRepo.save(ticket);
            System.out.println("Calling IVR");
            return ticket.getId();
        }else if(type.equals(QueryType.OTHERS.getType())){
            Ticket ticket = new Ticket(null, TicketState.OPEN,null,desc);
            ticketRepo.save(ticket);
            return ticket.getId();
        }else {
            throw new RuntimeException("Please enter correct query");
        }
    }

    public HashMap<Integer,String> assignTicket(String name){
        Map<String , User> usermap = userRepo.getUser();
        Ticket ticket = ticketRepo.getUnassignedTicket();
        if (usermap.containsKey(name) &&
                (name.equalsIgnoreCase("tom") || name.equalsIgnoreCase("Sam"))) {
//if
            ticket.setAssignedTo(usermap.get(name));
            return new HashMap<Integer,String>(ticket.getId(),name);
        }else if(usermap.containsKey(name) && name.equalsIgnoreCase("harry")){
            if(ticket.getTicketState().equals(TicketState.RESOLVED)){
                ticket.setAssignedTo(usermap.get(name));
            }
            return new HashMap<Integer,String>(ticket.getId(),name);
        }else {
            System.out.println("Please user predefined user");
        }
        return new HashMap<Integer,String>(ticket.getId(),name);
    }
}
