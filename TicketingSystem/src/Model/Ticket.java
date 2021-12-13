package Model;

import Enums.QueryType;
import Enums.TicketState;

import javax.annotation.Generated;

/**
 * @author gauravdhingra
 */
public class Ticket {
    private Integer id;
    private String desc;
//    private QueryType queryType;
    private User assignedTo;
    private TicketState ticketState;
    private String resolutionText;

//    public Ticket(int id) {
//        this.id = id;
//        this.assignedTo = null;
//        this.ticketState = TicketState.OPEN;
//        this.resolutionText = null;
//    }

    public Ticket( User assignedTo, TicketState ticketState, String resolutionText,String desc) {
        this.id = getId()==null?0:getId()+1;
        this.assignedTo = assignedTo;
        this.ticketState = ticketState;
        this.desc = desc;
        this.resolutionText = resolutionText;
    }

    public Integer getId() {
        return id;
    }


    public QueryType getQueryType() {
        return queryType;
    }

    public void setQueryType(QueryType queryType) {
        this.queryType = queryType;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public TicketState getTicketState() {
        return ticketState;
    }

    public void setTicketState(TicketState ticketState) {
        this.ticketState = ticketState;
    }

    public String getResolutionText() {
        return resolutionText;
    }

    public void setResolutionText(String resolutionText) {
        this.resolutionText = resolutionText;
    }
}


