package com.example.gee.assignment;

import java.util.ArrayList;

/**
 * Created by Gee on 12/28/2016.
 */

public class ExpandListGroup {
    private String Name;
    private ArrayList<ExpandListChild> Items;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public ArrayList<ExpandListChild> getItems() {
        return Items;
    }

    public void setItems(ArrayList<ExpandListChild> Items) {
        this.Items = Items;
    }

}
