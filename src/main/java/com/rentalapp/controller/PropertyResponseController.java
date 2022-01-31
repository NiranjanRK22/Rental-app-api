package com.rentalapp.controller;

import com.rentalapp.model.Property;
import com.rentalapp.service.IPropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("property-response-api")
public class PropertyResponseController {

    private IPropertyService propertyService;
    private Logger logger = LoggerFactory.getLogger(PropertyResponseController.class);

    @Autowired
    public void setPropertyService(IPropertyService propertyService) {
        this.propertyService = propertyService;
    }

    /**
     *
     * @param property
     * @return
     */
    @PostMapping("/properties")
    public ResponseEntity<Void> addProperty(@RequestBody Property property) {    //if using postman add requestbody
        logger.debug("inside add property");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding new property");
        propertyService.addProperty(property);
        logger.info("Got all property " +property);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }

    /**
     *
     * @param property
     * @return
     */
    @PutMapping("/properties")
    public ResponseEntity<Void> updateProperty(@RequestBody Property property) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updating a property");
        propertyService.updateProperty(property);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    /**
     *
     * @param propertyId
     * @return
     */
    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity<String> deleteProperty(@PathVariable("propertyId") int propertyId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting a property");
        propertyService.deleteProperty(propertyId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }

    /**
     *
     * @return
     */
    @GetMapping("/properties")
    public ResponseEntity<List<Property>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all properties");
        headers.add("info", "property details");
        List<Property> properties = propertyService.getAll();
        ResponseEntity<List<Property>> propertyResponse = new ResponseEntity(properties, headers, HttpStatus.OK);
        return propertyResponse;
    }

    /**
     *
     * @param propertyId
     * @return
     */
    @GetMapping("/properties/id/{propertyId}")
    public ResponseEntity<Property> getPropertyById(@PathVariable("propertyId") int propertyId) {
        logger.debug("inside get property by id");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting property by id");
        Property property = propertyService.getPropertyById(propertyId);
        logger.info("Got one property " +property);
        return ResponseEntity.ok().headers(headers).body(property);
    }

    /**
     *
     * @param type
     * @return
     */
    @GetMapping("/properties/type/{type}")
    public ResponseEntity<List<Property>> getByType(@PathVariable("type") String type) {
        logger.debug("inside get property by type");
        List<Property> properties = propertyService.getByType(type);
        logger.info("Get  properties by type " +properties);
        return ResponseEntity.ok(properties);
    }

    /**
     *
     * @param furnishing
     * @return
     */
    @GetMapping("/properties/furnishing/{furnishing}")
    public ResponseEntity<List<Property>> getByFurnishing(@PathVariable("furnishing") String furnishing) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting property by furnishing");
        List<Property> properties = propertyService.getByFurnishing(furnishing);
        return ResponseEntity.ok().headers(headers).body(properties);
    }

    /**
     *
     * @param type
     * @param furnishing
     * @return
     */
    @GetMapping("/properties/type/{type}/furnishing/{furnishing}")
    public ResponseEntity<List<Property>> getByTypeAndFurnishing(@PathVariable("type") String type, @PathVariable("furnishing") String furnishing) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting properties by type and furnishing");
        List<Property> properties = propertyService.getByTypeAndFurnishing(type, furnishing);
        return ResponseEntity.ok().headers(headers).body(properties);
    }

    /**
     *
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/properties/rent/{start}/{end}")
    public ResponseEntity<List<Property>> getByRentRange(@PathVariable("start") double start, @PathVariable("end") double end) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting properties by rent range");
        List<Property> properties = propertyService.getByRentRange(start, end);
        return ResponseEntity.ok().headers(headers).body(properties);
    }

    /**
     *
     * @param deposit
     * @return
     */
    @GetMapping("/properties/deposit/{deposit}")
    public ResponseEntity<List<Property>> getByLesserDeposit(@PathVariable("deposit") double deposit) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting properties by lesser deposit");
        List<Property> properties = propertyService.getByLesserDeposit(deposit);
        return ResponseEntity.ok().headers(headers).body(properties);
    }

    /**
     *
     * @param count
     * @return
     */
    @GetMapping("/properties/bedrooms/{bedrooms}")
    public ResponseEntity<List<Property>> getByBedroomCount(@PathVariable("bedrooms") String count) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting properties by bedrooms");
        List<Property> properties = propertyService.getByBedroomCount(count);
        return ResponseEntity.ok().headers(headers).body(properties);
    }

    /**
     *
     * @param type
     * @param count
     * @return
     */
    @GetMapping("/properties/type/{type}/bedrooms/{bedrooms}")
    public ResponseEntity<List<Property>> getByTypeAndBedrooms(@PathVariable("type") String type, @PathVariable("bedrooms") String count) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting properties by type and bedrooms");
        List<Property> properties = propertyService.getByTypeAndBedrooms(type, count);
        return ResponseEntity.ok().headers(headers).body(properties);
    }

    /**
     *
     * @param facilityName
     * @return
     */
    @GetMapping("/properties/{amenities/{amenities}")
    public ResponseEntity<List<Property>> getByAmenities(@PathVariable("facilityName") String facilityName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting properties by amenities");
        List<Property> properties = propertyService.getByAmenities(facilityName);
        return ResponseEntity.ok().headers(headers).body(properties);
    }

    /**
     *
     * @param location
     * @return
     */
    @GetMapping("/properties/location/{location}")
    public ResponseEntity<List<Property>> getByLocation(@PathVariable("location") String location) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting properties by location");
        List<Property> properties = propertyService.getByLocation(location);
        return ResponseEntity.ok().headers(headers).body(properties);
    }

    /**
     *
     * @param buildingName
     * @return
     */
    @GetMapping("/properties/buildingName/{buildingName}")
    public ResponseEntity<List<Property>> getByBuildingName(@PathVariable("building") String buildingName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting properties by building name");
        List<Property> properties = propertyService.getByBuildingName(buildingName);
        return ResponseEntity.ok().headers(headers).body(properties);
    }

    /**
     *
     * @param buildingName
     * @param roomCount
     * @return
     */
    @GetMapping("/properties/buildingName/{buildingName}/bedrooms/{bedrooms}")
    public ResponseEntity<List<Property>> getByBuildingBedrooms(@PathVariable("buildingName") String buildingName, @PathVariable("bedrooms") String roomCount) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting properties by building name and bedrooms");
        List<Property> properties = propertyService.getByBuildingBedrooms(buildingName, roomCount);
        return ResponseEntity.ok().headers(headers).body(properties);
    }

    /**
     *
     * @param buildingName
     * @param categoryName
     * @return
     */
    @GetMapping("/properties/buildingName/{buildingName}/category/{categoryName}")
    public ResponseEntity<List<Property>> getByBuildingAndCategory(@PathVariable("buildingName") String buildingName, @PathVariable("categoryName") String categoryName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting properties by building name and category");
        List<Property> properties = propertyService.getByBuildingAndCategory(buildingName, categoryName);
        return ResponseEntity.ok().headers(headers).body(properties);
    }

    /**
     *
     * @param city
     * @return
     */
    @GetMapping("properties/city/{city}")
    public ResponseEntity<List<Property>> getByCity(@PathVariable("city") String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting properties by city");
        List<Property> properties = propertyService.getByCity(city);
        return ResponseEntity.ok().headers(headers).body(properties);
    }

    /**
     *
     * @param categoryName
     * @return
     */
    @GetMapping("/properties/category/{categoryName}")
    public ResponseEntity<List<Property>> getByCategory(@PathVariable("categoryName") String categoryName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting properties by category");
        List<Property> properties = propertyService.getByCategory(categoryName);
        return ResponseEntity.ok().headers(headers).body(properties);
    }

    /**
     *
     * @param location
     * @param category
     * @param type
     * @return
     */
    @GetMapping("/properties/location/{location}/category/{categoryName}/type/{type}")
    public ResponseEntity<List<Property>> getByLocCategoryType(@PathVariable("location") String location, @PathVariable("categoryName") String category, @PathVariable("type") String type) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting properties by location, category, type");
        List<Property> properties = propertyService.getByLocCategoryType(location, category, type);
        return ResponseEntity.ok().headers(headers).body(properties);
    }

}
