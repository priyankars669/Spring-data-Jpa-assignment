package com.testpro;

import com.testpro.Repository.CustomerRepo;
import com.testpro.entities.Address;
import com.testpro.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;




import java.util.Arrays;
import java.util.List;

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
        c.setName("Parul");
        c.setEmail("Parul@gmail.com");
        c.setAddress(new Address("203","siwan","bihar","India","841226"));
        _repository.save(c);
    }

    @Test
    public void testRead(){
        Customer c = _repository.findById(1).get();
        assertNotNull(c);
        assertEquals("Prikesh",c.getName());
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

    @Test
    public void testFindByEmailAndName(){
        List<Customer> c = _repository.findByEmailAndName("Parul@gmail.com","Parul");
        c.forEach(c1-> System.out.println(c1.getId()+" "+c1.getName()));
    }

    @Test
    public void testFindByEmailLike(){
        List<Customer> c = _repository.findByEmailLike("%.com%");
        c.forEach(c1-> System.out.println(c1.getId()+" "+c1.getName()+" "+c1.getEmail()));
    }

    @Test
    public void testFindByIdIn(){
        List<Customer> c = _repository.findByIdIn(Arrays.asList(2,52,102,152),
                PageRequest.of(0, 2, Sort.Direction.ASC, "id"));
        c.forEach(c1-> System.out.println(c1.getId()+" "+c1.getName()+" "+c1.getEmail()));
    }

    @Test
    public void updateEmailById(){
        int id= _repository.updateEmailById(2, "prikesh@gmail.com");
        System.out.println(id);
    }
}
