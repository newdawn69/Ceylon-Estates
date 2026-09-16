package com.example.ceylonestate.controller;

import com.example.ceylonestate.model.Property;
import com.example.ceylonestate.service.PropertyService;
import com.example.ceylonestate.service.PropertyServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PropertyController {

    private final PropertyService propertyService =
            new PropertyServiceImpl();

    // VIEW ALL PROPERTIES
    @GetMapping("/properties")
    public String getAllProperties(Model model) {

        model.addAttribute(
                "properties",
                propertyService.getAllProperties()
        );

        return "property-list";
    }

    // SHOW ADD PROPERTY PAGE
    @GetMapping("/properties/add")
    public String showAddPropertyPage() {

        return "property-add";
    }

    // ADD PROPERTY
    @PostMapping("/properties")
    public String addProperty(
            @RequestParam int propertyId,
            @RequestParam String propertyName,
            @RequestParam String location,
            @RequestParam String propertyType,
            @RequestParam double price,
            @RequestParam String status) {

        Property property = new Property(
                propertyId,
                propertyName,
                location,
                propertyType,
                price,
                status
        );

        propertyService.addProperty(property);

        return "redirect:/properties";
    }

    // SHOW EDIT PAGE
    @GetMapping("/properties/edit/{id}")
    public String showEditPage(
            @PathVariable int id,
            Model model) {

        Property property =
                propertyService.getPropertyById(id);

        model.addAttribute("property", property);

        return "property-edit";
    }

    // UPDATE PROPERTY
    @PostMapping("/properties/update")
    public String updateProperty(
            @RequestParam int propertyId,
            @RequestParam String propertyName,
            @RequestParam String location,
            @RequestParam String propertyType,
            @RequestParam double price,
            @RequestParam String status) {

        Property property = new Property(
                propertyId,
                propertyName,
                location,
                propertyType,
                price,
                status
        );

        propertyService.updateProperty(property);

        return "redirect:/properties";
    }

    // DELETE PROPERTY
    @GetMapping("/properties/delete/{id}")
    public String deleteProperty(@PathVariable int id) {

        propertyService.deleteProperty(id);

        return "redirect:/properties";
    }
}