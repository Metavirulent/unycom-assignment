package com.alioktay.repository;


import com.alioktay.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin
public interface OrderRepository extends CrudRepository<Order, Long> {
}
