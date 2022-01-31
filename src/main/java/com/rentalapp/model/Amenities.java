package com.rentalapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Amenities {
    @Id
    @GeneratedValue(generator = "amenities_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="amenities_seq",sequenceName = "amenities_sequence",initialValue = 101,allocationSize = 1)
    @Column(name = "amenitiesid")
    private Integer amenitiesId;
    String facilityName;
    String description;

    /**
     *
     * @param facilityName
     * @param description
     */
    public Amenities(String facilityName, String description) {
        this.facilityName = facilityName;
        this.description = description;
    }
}
