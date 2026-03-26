package com.testpro.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Customer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String name;
    private String email;
}
