package com.example.integration_project_oop2.Lists;

import com.example.integration_project_oop2.Classes.Movie;
import com.example.integration_project_oop2.Classes.Showroom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowroomList implements Serializable, Iterable<Showroom> {
    private List<Showroom> aShowroomList;

    public ShowroomList() { this.aShowroomList = new ArrayList<>(); }

    public void addShowroom(Showroom pShowroom) { this.aShowroomList.add(pShowroom); }

    public void removeShowroom(Showroom pShowroom) { this.aShowroomList.remove(pShowroom); }

    public void editShowroom(Showroom pShowroom, Showroom aShowroom) {
        if (aShowroomList.contains(pShowroom)) {
            int index = aShowroomList.indexOf(pShowroom);
            aShowroomList.set(index, aShowroom);
        }
    }

    public Showroom getShowroomByIndex(int index) {
        if (index >= 0 && index < aShowroomList.size()) {
            return aShowroomList.get(index);
        }
        return null;
    }

    public List<Integer> getShowroomNumberList(){
        List<Integer> showroomList = new ArrayList<>();
        for (Showroom showroom : aShowroomList){
            showroomList.add(showroom.getRoomNumber());
        }
        return showroomList;
    }

    @Override
    public Iterator<Showroom> iterator() {
        return aShowroomList.iterator();
    }
}
