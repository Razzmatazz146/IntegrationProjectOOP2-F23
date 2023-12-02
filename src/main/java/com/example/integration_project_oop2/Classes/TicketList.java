package com.example.integration_project_oop2.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TicketList implements Serializable {
    private List<Ticket> aTicketSales;

    public TicketList() { this.aTicketSales = new ArrayList<>(); }

    public void addTicket(Ticket ticket) { this.aTicketSales.add(ticket); }

    public void removeTicket(Ticket ticket) { this.aTicketSales.remove(ticket); }

    public void editTicket(Ticket oldTicket, Ticket newTicket) {
        if (aTicketSales.contains(oldTicket)) {
            int index = aTicketSales.indexOf(oldTicket);
            aTicketSales.set(index, newTicket);
        }
    }

    public List<Ticket> getAllTickets() { return new ArrayList<>(aTicketSales); }
}
