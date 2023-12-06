package com.example.integration_project_oop2.Lists;

import com.example.integration_project_oop2.Classes.Ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TicketList implements Serializable, Iterable<Ticket> {
    private List<Ticket> aTicketList;

    public TicketList() { this.aTicketList = new ArrayList<>(); }

    public void addTicket(Ticket pTicket) { this.aTicketList.add(pTicket); }

    public void removeTicket(Ticket pTicket) { this.aTicketList.remove(pTicket); }

    public void editTicket(Ticket pTicket, Ticket aTicket) {
        if (aTicketList.contains(pTicket)) {
            int index = aTicketList.indexOf(pTicket);
            aTicketList.set(index, aTicket);
        }
    }

    public Ticket getTicketByIndex(int index) {
        if (index >= 0 && index < aTicketList.size()) {
            return aTicketList.get(index);
        }
        return null;
    }

    @Override
    public Iterator<Ticket> iterator() {
        return aTicketList.iterator();
    }
}
