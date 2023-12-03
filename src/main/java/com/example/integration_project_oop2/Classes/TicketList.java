package com.example.integration_project_oop2.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TicketList implements Serializable {
    private List<Ticket> aTicketList;

    public TicketList() { this.aTicketList = new ArrayList<>(); }

    public void addTicket(Ticket ticket) { this.aTicketList.add(ticket); }

    public void removeTicket(Ticket ticket) { this.aTicketList.remove(ticket); }

    public void editTicket(Ticket oldTicket, Ticket newTicket) {
        if (aTicketList.contains(oldTicket)) {
            int index = aTicketList.indexOf(oldTicket);
            aTicketList.set(index, newTicket);
        }
    }

    public Ticket getTicketByIndex(int index) {
        if (index >= 0 && index < aTicketList.size()) {
            return aTicketList.get(index);
        }
        return null; // Return null if the index is out of bounds
    }

    public List<Ticket> getAllTickets() { return new ArrayList<>(aTicketList); }
}
