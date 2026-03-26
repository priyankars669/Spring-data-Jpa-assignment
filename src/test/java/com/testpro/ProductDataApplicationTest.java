package com.testpro;

import com.testpro.Repository.ProductRepo;
import com.testpro.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductDataApplicationTest {

    @Autowired
    ProductRepo _repository;

    @Test
    public void contextLoads(){
    }

    @Test
    public void testCreate(){
        Product p = new Product();
        p.setId(4);
        p.setName("whirlpool");
        p.setDesc("AC");
        p.setPrice(30d);

        _repository.save(p);
    }

    @Test
    public void testRead(){
        Product p = _repository.findById(2).get();
        assertNotNull(p);
        assertEquals("Samsung",p.getName());
    }

    @Test
    public void testUpdate(){
        Product p = _repository.findById(2).get();
        p.setPrice(12d);
        _repository.save(p);
    }

    @Test
    public void testDelete(){
        Product p = _repository.findById(3).get();
        _repository.delete(p);
    }

    @Test
    public void testFindByName(){
        List<Product> products = _repository.findByName("whirlpool");
        products.forEach(p-> System.out.println(p.getDesc()));

    }

}
