package com.example.ceylonestate.service;

import com.example.ceylonestate.model.Property;
import com.example.ceylonestate.repository.PropertyFileRepository;
import com.example.ceylonestate.repository.PropertyRepository;

import java.util.List;

public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyServiceImpl() {
        propertyRepository = new PropertyFileRepository();
    }

    @Override
    public void addProperty(Property property) {
        propertyRepository.addProperty(property);
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.getAllProperties();
    }

    @Override
    public Property getPropertyById(int propertyId) {
        return propertyRepository.getPropertyById(propertyId);
    }

    @Override
    public void updateProperty(Property property) {
        propertyRepository.updateProperty(property);
    }

    @Override
    public void deleteProperty(int propertyId) {
        propertyRepository.deleteProperty(propertyId);
    }
}