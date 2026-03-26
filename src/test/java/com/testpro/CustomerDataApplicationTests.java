package com.testpro;

import com.testpro.Repository.CustomerRepo;
import com.testpro.Repository.ProductRepo;
import com.testpro.entities.Customer;
import com.testpro.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerDataApplicationTests {

    

    @Autowired
    CustomerRepo _repository;

    @Test
    public void contextLoads(){
    }

    @Test
    public void testCreate(){
        Customer c = new Customer();
        c.setId(1);
        c.setName("Priya");
        c.setEmail("Priya@gmail.com");
        _repository.save(c);
    }

    @Test
    public void testRead(){
        Customer c = _repository.findById(1).get();
        assertNotNull(c);
        assertEquals("Pika",c.getName());
    }

    @Test
    public void testUpdate(){
        Customer c = _repository.findById(1).get();
        c.setName("Pika");
        _repository.save(c);
    }

    @Test
    public void testDelete(){
        Customer c = _repository.findById(1).get();
        _repository.delete(c);
    }
}
