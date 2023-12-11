package com.example.integration_project_oop2.Lists;

import com.example.integration_project_oop2.Classes.Ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class representing a list of tickets in the Movie Theater application.
 * This list allows adding, removing, editing, and retrieving ticket information.
 */
public class TicketList implements Serializable, Iterable<Ticket> {
    private List<Ticket> aTicketList;

    /**
     * Constructs a new TicketList.
     */
    public TicketList() {
        this.aTicketList = new ArrayList<>();
    }

    /**
     * Adds a ticket to the list.
     *
     * @param pTicket The ticket to add.
     */
    public void addTicket(Ticket pTicket) {
        this.aTicketList.add(pTicket);
    }

    /**
     * Removes a ticket from the list.
     *
     * @param pTicket The ticket to remove.
     */
    public void removeTicket(Ticket pTicket) {
        this.aTicketList.remove(pTicket);
    }

    /**
     * Edits an existing ticket in the list.
     *
     * @param pTicket The ticket to be edited.
     * @param aTicket The new ticket details.
     */
    public void editTicket(Ticket pTicket, Ticket aTicket) {
        if (aTicketList.contains(pTicket)) {
            int index = aTicketList.indexOf(pTicket);
            aTicketList.set(index, aTicket);
        }
    }

    /**
     * Retrieves a ticket from the list by its index.
     *
     * @param index The index of the ticket to retrieve.
     * @return The ticket at the specified index, or null if the index is out of bounds.
     */
    public Ticket getTicketByIndex(int index) {
        if (index >= 0 && index < aTicketList.size()) {
            return aTicketList.get(index);
        }
        return null;
    }

    /**
     * Returns an iterator over the tickets in the list.
     *
     * @return An iterator over the tickets.
     */
    @Override
    public Iterator<Ticket> iterator() {
        return aTicketList.iterator();
    }
}
