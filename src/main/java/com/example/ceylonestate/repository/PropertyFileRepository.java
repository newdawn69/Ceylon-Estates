package com.example.ceylonestate.repository;

import com.example.ceylonestate.model.Property;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyFileRepository implements PropertyRepository {

    private final String filePath = "data/properties.txt";

    @Override
    public void addProperty(Property property) {
        try {
            File file = new File(filePath);

            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(property.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Property> getAllProperties() {
        List<Property> properties = new ArrayList<>();

        File file = new File(filePath);

        if (!file.exists()) {
            return properties;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                if (data.length == 6) {
                    Property property = new Property(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2],
                            data[3],
                            Double.parseDouble(data[4]),
                            data[5]
                    );

                    properties.add(property);
                }
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return properties;
    }

    @Override
    public Property getPropertyById(int propertyId) {

        for (Property property : getAllProperties()) {

            if (property.getPropertyId() == propertyId) {
                return property;
            }
        }

        return null;
    }

    @Override
    public void updateProperty(Property updatedProperty) {

        List<Property> properties = getAllProperties();

        for (int i = 0; i < properties.size(); i++) {

            if (properties.get(i).getPropertyId()
                    == updatedProperty.getPropertyId()) {

                properties.set(i, updatedProperty);
                break;
            }
        }

        saveAllProperties(properties);
    }

    @Override
    public void deleteProperty(int propertyId) {

        List<Property> properties = getAllProperties();

        properties.removeIf(property ->
                property.getPropertyId() == propertyId);

        saveAllProperties(properties);
    }

    private void saveAllProperties(List<Property> properties) {

        try {
            File file = new File(filePath);

            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            try (BufferedWriter writer =
                         new BufferedWriter(new FileWriter(file))) {

                for (Property property : properties) {
                    writer.write(property.toString());
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}