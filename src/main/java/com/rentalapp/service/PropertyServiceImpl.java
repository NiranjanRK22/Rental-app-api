package com.rentalapp.service;

import com.rentalapp.exceptions.PropertyNotFoundException;
import com.rentalapp.model.*;
import com.rentalapp.repository.IPropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.Proxy;
import java.util.List;

@Service
public class PropertyServiceImpl implements IPropertyService{

    private Logger logger = LoggerFactory.getLogger(PropertyServiceImpl.class);

    private IPropertyRepository propertyRepository;
    @Autowired
    public void setPropertyRepository(IPropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public void addProperty(Property property) {
        propertyRepository.save(property);
    }

    @Override
    public void updateProperty(Property property) {

        propertyRepository.save(property);
    }

    /**
     *
     * @param propertyId
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public Property getPropertyById(int propertyId) throws PropertyNotFoundException {
        logger.debug("inside get property by id method in service layer");
        logger.info("calling get property by id method");
        return propertyRepository.findById(propertyId)
                .orElseThrow(() -> {
                        logger.error("Property not found exception");
                        throw new PropertyNotFoundException("invalid id");
                });

    }

    /**
     *
     * @param propertyId
     */
    @Override
    public void deleteProperty(int propertyId) {
        propertyRepository.deleteById(propertyId);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Property> getAll() {
        return propertyRepository.findAll();
    }

    /**
     *
     * @param type
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public List<Property> getByType(String type) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByType(Type.valueOf(type));
        logger.debug("inside get property by type method");
        logger.info("calling get property by type");
        if (properties.isEmpty()) {
            logger.warn("property not found");
            logger.error("no type");
            throw new PropertyNotFoundException("Property not found in this type");
        }
        return properties;
    }

    /**
     *
     * @param furnishing
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public List<Property> getByFurnishing(String furnishing) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByFurnishing(Furnishing.FULLYFURNISHED.valueOf(furnishing));
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Property not found");
        return properties;
    }

    /**
     *
     * @param type
     * @param furnishing
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public List<Property> getByTypeAndFurnishing(String type, String furnishing) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByTypeAndFurnishing(Type.valueOf(type), Furnishing.valueOf(furnishing));
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Property not found");
        return properties;
    }

    /**
     *
     * @param start
     * @param end
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public List<Property> getByRentRange(double start, double end) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByRentRange(start, end);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Property not found");
        return properties;
    }

    /**
     *
     * @param deposit
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public List<Property> getByLesserDeposit(double deposit) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByLesserDeposit(deposit);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Property not found");
        return properties;
    }

    /**
     *
     * @param count
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public List<Property> getByBedroomCount(String count) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByBedrooms(count);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Property not found");
        return properties;
    }

    /**
     *
     * @param type
     * @param count
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public List<Property> getByTypeAndBedrooms(String type, String count) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByTypeAndBedrooms(Type.valueOf(type), count);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Property not found");
        return properties;
    }

    /**
     *
     * @param facilityName
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public List<Property> getByAmenities(String facilityName) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByAmenities(facilityName);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Property not found with these amenities");
        return properties;
    }

    /**
     *
     * @param location
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public List<Property> getByLocation(String location) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByLocation(location);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Property not found in this location");
        return properties;
    }

    /**
     *
     * @param buildingName
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public List<Property> getByBuildingName(String buildingName) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByBuildingName(buildingName);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Property not found with this building");
        return properties;
    }

    /**
     *
     * @param buildingName
     * @param roomCount
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public List<Property> getByBuildingBedrooms(String buildingName, String roomCount) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByBuildingBedrooms(buildingName, roomCount);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Property not found");
        return properties;
    }

    /**
     *
     * @param buildingName
     * @param categoryName
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public List<Property> getByBuildingAndCategory(String buildingName, String categoryName) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByBuildingAndCategory(buildingName, categoryName);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Property not found with this builiding and category");
        return properties;
    }

    /**
     *
     * @param city
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public List<Property> getByCity(String city) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByCity(city);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Property not found in this city");
        return properties;
    }

    /**
     *
     * @param category
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public List<Property> getByCategory(String category) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByCategory(category);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Property not found in this category");
        return properties;
    }

    /**
     *
     * @param location
     * @param category
     * @param type
     * @return
     * @throws PropertyNotFoundException
     */
    @Override
    public List<Property> getByLocCategoryType(String location, String category, String type) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByLocCategoryType(location, category, Type.valueOf(type));
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Property not found");
        return properties;
    }


}
