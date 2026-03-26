package com.testpro.Repository;

import com.testpro.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    List<Customer> findByEmailAndName(String email, String name);
    List<Customer> findByEmailLike(String exp);
    List<Customer> findByIdIn(List<Integer> Ids);
}
