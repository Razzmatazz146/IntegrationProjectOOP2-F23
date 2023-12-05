package com.example.integration_project_oop2.Lists;

import com.example.integration_project_oop2.Classes.Showroom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowroomList implements Serializable, Iterable<Showroom> {
    private List<Showroom> aShowroomList;

    public ShowroomList() { this.aShowroomList = new ArrayList<>(); }

    public void addShowroom(Showroom showroom) { this.aShowroomList.add(showroom); }

    public void removeShowroom(Showroom showroom) { this.aShowroomList.remove(showroom); }

    public void editShowroom(Showroom oldShowroom, Showroom newShowroom) {
        if (aShowroomList.contains(oldShowroom)) {
            int index = aShowroomList.indexOf(oldShowroom);
            aShowroomList.set(index, newShowroom);
        }
    }
    public Showroom getShowroomByIndex(int index) {
        if (index >= 0 && index < aShowroomList.size()) {
            return aShowroomList.get(index);
        }
        return null;
    }

    @Override
    public Iterator<Showroom> iterator() {
        return aShowroomList.iterator();
    }
}
