package com.rentalapp;

import com.rentalapp.model.*;
import com.rentalapp.service.ICategoryService;
import com.rentalapp.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringRentalappRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringRentalappRestapiApplication.class, args);
	}
    @Autowired
	private IPropertyService propertyService;

	@Autowired
	private ICategoryService categoryService;
	@Override
	public void run(String... args) throws Exception {
		//one to one
//		Address address = new Address("A12", "shoba enclave","premnagar", "khairatabad", "hyderabad", "telangana", 500004);
//		//one to many
//		Amenities amenities1 = new Amenities(Facility.play.facilityName, "play area for kids");
//		Amenities amenities2 = new Amenities(Facility.lift.facilityName, "max 8 allowed");
//		Amenities amenities3 = new Amenities(Facility.backup.facilityName, "power backup available");
//		Set<Amenities> amenities = new HashSet<>(Arrays.asList(amenities1, amenities2, amenities3));
//		//many to many
//		//Category category1 = new Category("office space");
//		//categoryService.addCategory(category1);
//		Category category1 = categoryService.getCategoryById(151);
//		Category category2 = categoryService.getCategoryById(152);
//		//Category category3 = new Category("Girls");
//		Set<Category> categories = new HashSet<>(Arrays.asList(category1, category2));
//
//		Property property = new Property("4 BHK Independent", Type.INDEPENDENTHOUSE, Bedrooms.THREE.count,
//                   Furnishing.SEMIFURNISHED, "1900 sqft", 30000, 5000, address, amenities, categories
//				);
//
//		propertyService.addProperty(property);

		//propertyService.updateProperty();
	}
}
