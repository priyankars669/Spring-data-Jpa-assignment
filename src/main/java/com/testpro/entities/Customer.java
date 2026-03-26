package com.testpro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Customer {
    @Id
    private int id;
    private String name;
    private String email;
}
