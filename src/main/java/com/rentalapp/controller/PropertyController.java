package com.rentalapp.controller;

import com.rentalapp.exceptions.PropertyNotFoundException;
import com.rentalapp.model.Property;
import com.rentalapp.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("property-api")
@CrossOrigin("http://localhost:4200")
public class PropertyController {

    private IPropertyService propertyService;

    @Autowired
    public void setPropertyService(IPropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/properties")
    void addProperty(@RequestBody Property property) {    //if using postman add requestbody
        propertyService.addProperty(property);
    }

    @PutMapping("/properties")
    void updateProperty(@RequestBody Property property) {
        propertyService.updateProperty(property);
    }

    @GetMapping("/properties/id/{propertyId}")
    Property getPropertyById(@PathVariable("propertyId") int propertyId) {
        return propertyService.getPropertyById(propertyId);
    }

    @DeleteMapping("/properties/{propertyId}")
    void deleteProperty(@PathVariable("propertyId") int propertyId) {
        propertyService.deleteProperty(propertyId);
    }

    @GetMapping("/properties")
    List<Property> getAll() {
        return propertyService.getAll();
    }

    @GetMapping("/properties/type/{type}")
    List<Property> getByType(@PathVariable("type") String type) {
        return propertyService.getByType(type);
    }

    @GetMapping("/properties/furnishing/{furnishing}")
    List<Property> getByFurnishing(@PathVariable("furnishing") String furnishing) {
        return propertyService.getByFurnishing(furnishing);
    }

    @GetMapping("/properties/type/{type}/furnishing/{furnishing}")
    List<Property> getByTypeAndFurnishing(@PathVariable("type") String type, @PathVariable("furnishing") String furnishing) {
        return propertyService.getByTypeAndFurnishing(type, furnishing);
    }

    @GetMapping("/properties/rent/{start}/{end}")
    List<Property> getByRentRange(@PathVariable("start") double start, @PathVariable("end") double end) {
        return propertyService.getByRentRange(start, end);
    }

    @GetMapping("/properties/deposit/{deposit}")
    List<Property> getByLesserDeposit(@PathVariable("deposit") double deposit) {
        return propertyService.getByLesserDeposit(deposit);
    }

    @GetMapping("/properties/bedrooms/{bedrooms}")
    List<Property> getByBedroomCount(@PathVariable("bedrooms") String count) {
        return propertyService.getByBedroomCount(count);
    }

    @GetMapping("/properties/type/{type}/bedrooms/{bedrooms}")
    List<Property> getByTypeAndBedrooms(@PathVariable("type") String type, @PathVariable("bedrooms") String count) {
        return propertyService.getByTypeAndBedrooms(type, count);
    }

    @GetMapping("/properties/{amenities/{amenities}")
    List<Property> getByAmenities(@PathVariable("facilityName") String facilityName) {
        return propertyService.getByAmenities(facilityName);
    }

    @GetMapping("/properties/location/{location}")
    List<Property> getByLocation(@PathVariable("location") String location) {
        return propertyService.getByLocation(location);
    }

    @GetMapping("/properties/buildingName/{buildingName}")
    List<Property> getByBuildingName(@PathVariable("buildingName") String buildingName) {
        return propertyService.getByBuildingName(buildingName);
    }

    @GetMapping("/properties/buildingName/{buildingName}/bedrooms/{bedrooms}")
    List<Property> getByBuildingBedrooms(@PathVariable("buildingName") String buildingName, @PathVariable("bedrooms") String roomCount) {
        return propertyService.getByBuildingBedrooms(buildingName, roomCount);
    }

    @GetMapping("/properties/buildingName/{buildingName}/category/{categoryName}")
    List<Property> getByBuildingAndCategory(@PathVariable("buildingName") String buildingName, @PathVariable("categoryName") String categoryName) {
        return propertyService.getByBuildingAndCategory(buildingName, categoryName);
    }

    @GetMapping("properties/city/{city}")
    List<Property> getByCity(@PathVariable("city") String city) {
        return propertyService.getByCity(city);
    }

    @GetMapping("/properties/category/{categoryName}")
    List<Property> getByCategory(@PathVariable("categoryName") String categoryName) {
        return propertyService.getByCategory(categoryName);
    }

    @GetMapping("/properties/location/{location}/category/{categoryName}/type/{type}")
    List<Property> getByLocCategoryType(@PathVariable("location") String location, @PathVariable("categoryName") String category, @PathVariable("type") String type) {
        return propertyService.getByLocCategoryType(location, category, type);
    }

}
