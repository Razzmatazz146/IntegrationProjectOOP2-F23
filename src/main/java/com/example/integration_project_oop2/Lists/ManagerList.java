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

    public void removeManager(Manager manager) { this.aManagerList.remove(manager); }

    public void editManager(Manager oldManager, Manager newManager) {
        if (aManagerList.contains(oldManager)) {
            int index = aManagerList.indexOf(oldManager);
            aManagerList.set(index, newManager);
        }
    }

    public Manager getManagerByIndex(int index) {
        if (index >= 0 && index < aManagerList.size()) {
            return aManagerList.get(index);
        }
        return null; // Return null if the index is out of bounds
    }

    @Override
    public Iterator<Manager> iterator() {
        return aManagerList.iterator();
    }
}
