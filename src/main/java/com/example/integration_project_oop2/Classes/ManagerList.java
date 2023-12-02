package com.example.integration_project_oop2.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ManagerList implements Serializable {
    private List<Manager> aManagerList;

    public ManagerList() { this.aManagerList = new ArrayList<>(); }

    public void addManager(Manager manager) { this.aManagerList.add(manager); }

    public void removeManager(Manager manager) { this.aManagerList.remove(manager); }

    public void editManager(Manager oldManager, Manager newManager) {
        if (aManagerList.contains(oldManager)) {
            int index = aManagerList.indexOf(oldManager);
            aManagerList.set(index, newManager);
        }
    }
}
