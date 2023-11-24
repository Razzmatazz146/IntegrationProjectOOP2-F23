package com.example.integration_project_oop2.Classes;

import java.util.ArrayList;
import java.util.List;

public class ShowroomList {
    private List<Showrooms> aShowroomList;

    public ShowroomList() { this.aShowroomList = new ArrayList<>(); }

    public List<Showrooms> getShowroomsList() { return new ArrayList<>(aShowroomList); }
}
