package com.example.ceylonestate.model;

public class PropertyBase {

    protected int propertyId;
    protected String propertyName;
    protected String location;

    public PropertyBase() {
    }

    public PropertyBase(int propertyId, String propertyName, String location) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.location = location;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}