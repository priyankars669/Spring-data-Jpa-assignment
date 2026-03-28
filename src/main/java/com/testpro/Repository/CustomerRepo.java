package com.testpro.Repository;

import com.testpro.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    List<Customer> findByEmailAndName(String email, String name);
    List<Customer> findByEmailLike(String exp);


    List<Customer> findByIdIn(List<Integer> Ids, Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.email=:email where c.id=:id")
    int updateEmailById(@Param("id") int id, @Param("email") String email);
}
