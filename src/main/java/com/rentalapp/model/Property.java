package com.rentalapp.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Property {
    @Column(length = 30)
    private String name;
    @Id
    @GeneratedValue(generator = "property_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="property_seq",sequenceName = "property_sequence",initialValue = 1,allocationSize = 1)
    @Column(name = "propertyid")
    private Integer propertyId;
    @Enumerated(EnumType.STRING)
    private Type type; // apartment/independent house/ villa
    private String bedrooms; // 2 BHK/ 3 BHK // 5BHK, 1 BHK
    @Enumerated(EnumType.STRING)
    private Furnishing furnishing; // semi, fully, un
    @Column(length = 20)
    private String area;    //1900 sqft
    @Column(name="expectedrent")
    private double expectedRent;
    @Column(name = "securitydeposit")
    private double securityDeposit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")//to rename the foreign key column
    private Address address;

    @OneToMany(cascade =  CascadeType.ALL)
    //this is the foreign key that will be added to amenities table
    @JoinColumn(name="property_id")//to prevent creating a new junction/common table
    private Set<Amenities> amenities;

    @ManyToMany
    @JoinTable(name="property_category",
            joinColumns = @JoinColumn(name="property_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories; //All,family,Boys, Girls, Commercial,Office Space

    /**
     *
     * @param name
     * @param type
     * @param bedrooms
     * @param furnishing
     * @param area
     * @param expectedRent
     * @param securityDeposit
     * @param address
     * @param amenities
     * @param categories
     */
    public Property(String name, Type type, String bedrooms, Furnishing furnishing, String area, double expectedRent, double securityDeposit, Address address, Set<Amenities> amenities, Set<Category> categories) {
        this.name = name;
        this.type = type;
        this.bedrooms = bedrooms;
        this.furnishing = furnishing;
        this.area = area;
        this.expectedRent = expectedRent;
        this.securityDeposit = securityDeposit;
        this.address = address;
        this.amenities = amenities;
        this.categories = categories;
    }

}
