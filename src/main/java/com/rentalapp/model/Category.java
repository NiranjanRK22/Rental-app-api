package com.rentalapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(generator = "category_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="category_seq",sequenceName = "category_sequence",initialValue = 151,allocationSize = 1)
    @Column(name = "categoryid")
    Integer categoryId;
    @Column(name="categoryname")
    String categoryName;
    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    Set<Property> properties;

    /**
     *
     * @param categoryName
     */
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                '}';
    }
}
