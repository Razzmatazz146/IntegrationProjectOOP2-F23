package com.example.integration_project_oop2.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShowroomList implements Serializable {
    private List<Showroom> aShowroomList;

    public ShowroomList() { this.aShowroomList = new ArrayList<>(); }

    public List<Showroom> getShowroomsList() { return new ArrayList<>(aShowroomList); }

    public void addShowroom(Showroom showroom) { this.aShowroomList.add(showroom); }

    public void removeShowroom(Showroom showroom) { this.aShowroomList.remove(showroom); }

    public void editShowroom(Showroom oldShowroom, Showroom newShowroom) {
        if (aShowroomList.contains(oldShowroom)) {
            int index = aShowroomList.indexOf(oldShowroom);
            aShowroomList.set(index, newShowroom);
        }
    }
}
