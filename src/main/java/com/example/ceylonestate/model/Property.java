package com.example.ceylonestate.model;

public class Property extends PropertyBase {

    private String propertyType;
    private double price;
    private String status;

    public Property() {
        super();
    }

    public Property(int propertyId, String propertyName, String location,
                    String propertyType, double price, String status) {

        super(propertyId, propertyName, location);

        this.propertyType = propertyType;
        this.price = price;
        this.status = status;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return propertyId + "," + propertyName + "," + location + ","
                + propertyType + "," + price + "," + status;
    }
}