package com.testpro.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String houseNo;
    private String city;
    private String state;
    private String country;
    private String pincode;
}
