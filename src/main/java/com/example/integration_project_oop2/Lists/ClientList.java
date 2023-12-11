package com.example.integration_project_oop2.Lists;


import com.example.integration_project_oop2.Classes.Client;
import com.example.integration_project_oop2.Classes.ExceptionAlert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class representing a list of clients in the Movie Theater application.
 * This list allows adding, removing, and editing client information.
 */
public class ClientList implements Serializable, Iterable<Client> {
    private List<Client> aClientList;

    /**
     * Constructs a new ClientList.
     */
    public ClientList() {
        this.aClientList = new ArrayList<>();
    }

    /**
     * Adds a client to the list, ensuring that the username and email are not already in use.
     *
     * @param pClient The client to add.
     * @throws IllegalArgumentException If the username or email is already in use.
     */
    public void addClient(Client pClient) {
        for (Client aClient : aClientList)
            if (aClient.getUsername().equals(pClient.getUsername()))
                ExceptionAlert.alertIllegalArgumentException("This username is already in use.");
            else if (aClient.getEmail().equals((pClient.getEmail())))
                ExceptionAlert.alertIllegalArgumentException("This e-mail is already in use.");
        this.aClientList.add(pClient);
    }

    /**
     * Removes a client from the list.
     *
     * @param pClient The client to remove.
     */
    public void removeClient(Client pClient) { this.aClientList.remove(pClient); }

    /**
     * Edits an existing client in the list.
     *
     * @param pClient The client to be edited.
     * @param aClient The new client details.
     */
    public void editClient(Client pClient, Client aClient) {
        if (aClientList.contains(pClient)) {
            int index = aClientList.indexOf(pClient);
            aClientList.set(index, aClient);
        }
    }

    /**
     * Retrieves a list of client usernames.
     *
     * @return A list of client usernames.
     */
    public List<String> geClientUsernames(){
        List<String> clientUsernames = new ArrayList<>();
        for (Client pClient : aClientList){
            clientUsernames.add(pClient.getUsername());
        }
        return clientUsernames;
    }

    /**
     * Retrieves a client from the list by its index.
     *
     * @param index The index of the client to retrieve.
     * @return The client at the specified index, or null if the index is out of bounds.
     */
    public Client getClientByIndex(int index) {
        if (index >= 0 && index < aClientList.size()) {
            return aClientList.get(index);
        }
        return null;
    }

    /**
     * Returns an iterator over the clients in the list.
     *
     * @return An iterator over the clients.
     */
    @Override
    public Iterator<Client> iterator() {
        return aClientList.iterator();
    }
}
