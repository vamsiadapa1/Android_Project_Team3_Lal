package com.example.Endecryptmessanger;

public class AdminItem {
    private String itemName;
    private String itemDescription;


    public AdminItem(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;

    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }


}