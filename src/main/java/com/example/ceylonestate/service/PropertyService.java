package com.example.ceylonestate.service;

import com.example.ceylonestate.model.Property;
import java.util.List;

public interface PropertyService {

    void addProperty(Property property);

    List<Property> getAllProperties();

    Property getPropertyById(int propertyId);

    void updateProperty(Property property);

    void deleteProperty(int propertyId);
}