package com.example.hindpolymers;

public class NavigationDrawerDataModel {

    public int icon;
    public int name;

    // Constructor.
    public NavigationDrawerDataModel(int icon, int name) {

        this.icon = icon;
        this.name = name;
    }

    public int getDrawerListItemIcon() {
        return icon;
    }

    public int getDrawerListItemName() {
        return name;
    }

}
