package com.rentalapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {
    @Column(length=10)
    private String doorno;
    @Id
    @GeneratedValue(generator = "address_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="address_seq",sequenceName = "address_sequence",initialValue = 51,allocationSize = 1)
    @Column(name = "addressid")
    private Integer addressId;
    @Column(name="buildingname", length=30)
    private String buildingName;
    @Column(name="streetname", length=30)
    private String streetName;
    @Column(length = 20)
    private String location;
    @Column(length = 10)
    private String city;
    @Column(length = 10)
    private String state;
    private int zipcode;

    /**
     *
     * @param doorno
     * @param buildingName
     * @param streetName
     * @param location
     * @param city
     * @param state
     * @param zipcode
     */
    public Address(String doorno, String buildingName, String streetName, String location, String city, String state, int zipcode) {
        this.doorno = doorno;
        this.buildingName = buildingName;
        this.streetName = streetName;
        this.location = location;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Address{" +
                "doorno='" + doorno + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", location='" + location + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
