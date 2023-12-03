package com.example.integration_project_oop2.Classes;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ClientList implements Serializable, Iterable<Client> {
    private List<Client> aClientList;

    // Constructor
    public ClientList() {
        this.aClientList = new ArrayList<>();
    }

    public void addClient(Client client) {
        this.aClientList.add(client);
    }

    public void removeClient(Client client) { this.aClientList.remove(client); }

    public void editClient(Client oldClient, Client newClient) {
        if (aClientList.contains(oldClient)) {
            int index = aClientList.indexOf(oldClient);
            aClientList.set(index, newClient);
        }
    }

    public Client getClientByIndex(int index) {
        if (index >= 0 && index < aClientList.size()) {
            return aClientList.get(index);
        }
        return null; // Return null if the index is out of bounds
    }

    @Override
    public Iterator<Client> iterator() {
        return aClientList.iterator();
    }
}
