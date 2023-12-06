package com.example.integration_project_oop2.Lists;

import com.example.integration_project_oop2.Classes.Manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManagerList implements Serializable, Iterable<Manager> {
    private List<Manager> aManagerList;

    // Constructor
    public ManagerList() {
        this.aManagerList = new ArrayList<>();
    }

    public void addManager(Manager manager) {
        this.aManagerList.add(manager);
    }

    @Override
    public Iterator<Manager> iterator() {
        return aManagerList.iterator();
    }
}