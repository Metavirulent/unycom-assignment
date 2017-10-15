package com.alioktay.repository;

import com.alioktay.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin
public interface CustomerRepository extends CrudRepository<Customer, String> {

}
