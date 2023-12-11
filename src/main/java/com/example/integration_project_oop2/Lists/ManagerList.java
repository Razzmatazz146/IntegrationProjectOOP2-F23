package com.example.integration_project_oop2.Lists;

import com.example.integration_project_oop2.Classes.Manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class representing a list of managers in the Movie Theater application.
 * This list allows adding and retrieving manager information.
 */
public class ManagerList implements Serializable, Iterable<Manager> {
    private List<Manager> aManagerList;

    /**
     * Constructs a new ManagerList.
     */
    public ManagerList() {
        this.aManagerList = new ArrayList<>();
    }

    /**
     * Adds a manager to the list.
     *
     * @param manager The manager to add.
     */
    public void addManager(Manager manager) {
        this.aManagerList.add(manager);
    }

    /**
     * Returns an iterator over the managers in the list.
     *
     * @return An iterator over the managers.
     */
    @Override
    public Iterator<Manager> iterator() {
        return aManagerList.iterator();
    }
}
