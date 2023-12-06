package com.example.integration_project_oop2.Lists;


import com.example.integration_project_oop2.Classes.Client;
import com.example.integration_project_oop2.Classes.Client;
import com.example.integration_project_oop2.Classes.Movie;
import javafx.scene.control.Alert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientList implements Serializable, Iterable<Client> {
    private List<Client> aClientList;

    public ClientList() {
        this.aClientList = new ArrayList<>();
    }

    public void addClient(Client pClient) {
        for (Client aClient : aClientList)
            if (aClient.getUsername().equals(pClient.getUsername()))
                throw new IllegalArgumentException("Username already exists.");
            else if (aClient.getEmail().equals((pClient.getEmail())))
                throw new IllegalArgumentException("E-mail is already in use.");
        this.aClientList.add(pClient);
    }

    public void removeClient(Client pClient) { this.aClientList.remove(pClient); }

    public void editClient(Client pClient, Client aClient) {
        if (aClientList.contains(pClient)) {
            int index = aClientList.indexOf(pClient);
            aClientList.set(index, aClient);
        }
    }

    public List<String> geClientUsernames(){
        List<String> clientUsernames = new ArrayList<>();
        for (Client pClient : aClientList){
            clientUsernames.add(pClient.getUsername());
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
