package com.example.integration_project_oop2.Classes;

import java.util.ArrayList;
import java.util.List;

public class ClientList {
    private List<Client> aClientList;

    public ClientList() { this.aClientList = new ArrayList<>(); }

    public void addClient(Client client) { this.aClientList.add(client); }

    public void removeClient(Client client) { this.aClientList.remove(client); }

    public void editClient(Client oldClient, Client newClient) {
        if (aClientList.contains(oldClient)) {
            int index = aClientList.indexOf(oldClient);
            aClientList.set(index, newClient);
        }
    }

}
