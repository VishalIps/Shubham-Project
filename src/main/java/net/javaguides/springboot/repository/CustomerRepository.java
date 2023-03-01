package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(nativeQuery = true, value = "select * from customer ")
    List<Customer> search();

}
