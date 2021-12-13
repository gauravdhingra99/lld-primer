package Repository;

import Enums.TicketState;
import Model.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author gauravdhingra
 */
public class TicketRepo {
private Map<Integer, Ticket> ticketMap = new HashMap<>();

    public void save(Ticket ticket){
        ticketMap.put(ticket.getId(),ticket);
    }

    public Ticket getUnassignedTicket(){
        for(Map.Entry<Integer, Ticket> ticket : ticketMap.entrySet()){
            if( ticket.getValue().getAssignedTo()==null){
                return ticket.getValue();
            }
        }
    }
}
