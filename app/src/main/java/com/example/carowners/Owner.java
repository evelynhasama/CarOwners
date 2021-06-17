package com.example.carowners;

public class Owner {
    private String owner;
    private String make;
    private String model;
    private String ownertel;

    public Owner(String owner, String make, String model, String ownertel) {
        this.owner = owner;
        this.make = make;
        this.model = model;
        this.ownertel = ownertel;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwnertel() {
        return ownertel;
    }

    public void setOwnertel(String ownertel) {
        this.ownertel = ownertel;
    }
}
