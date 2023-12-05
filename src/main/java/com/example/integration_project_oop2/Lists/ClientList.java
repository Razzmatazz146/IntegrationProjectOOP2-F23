package com.example.integration_project_oop2.Lists;


import com.example.integration_project_oop2.Classes.Client;
import com.example.integration_project_oop2.Classes.Client;
import com.example.integration_project_oop2.Classes.Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientList implements Serializable, Iterable<Client> {
    private List<Client> aClientList;

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

    public List<String> geClientUsernames(){
        List<String> clientUsernames = new ArrayList<>();
        for (Client client : aClientList){
            clientUsernames.add(client.getUsername());
        }
        return clientUsernames;
    }

    public Client getClientByIndex(int index) {
        if (index >= 0 && index < aClientList.size()) {
            return aClientList.get(index);
        }
        return null;
    }

    @Override
    public Iterator<Client> iterator() {
        return aClientList.iterator();
    }
}
