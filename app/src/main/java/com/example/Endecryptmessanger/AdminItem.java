package com.example.Endecryptmessanger;

import com.google.firebase.auth.FirebaseUser;

public class AdminItem {
    private String itemName;
    private String itemAge;

    private String itemGender;
    private String itemAdmin;

    private String blocked;


    private String id;

    public String getItemGender() {
        return itemGender;
    }

    public String getItemAdmin() {
        return itemAdmin;
    }

    public AdminItem(String itemName, String itemAge, String itemGender, String itemAdmin, String blocked, String id) {
        this.itemName = itemName;
        this.itemAge = itemAge;
        this.itemGender=itemGender;
        this.itemAdmin=itemAdmin;
        this.id=id;

    }

    public String getItemName() {
        return itemName;
    }

    public String getItemAge() {
        return itemAge;
    }

    public String getItemUserId() {
        return id;
    }
}