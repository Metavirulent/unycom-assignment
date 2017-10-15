package com.alioktay;

import com.alioktay.entity.Customer;
import com.alioktay.entity.Order;
import com.alioktay.entity.Status;
import com.alioktay.entity.Type;
import com.alioktay.repository.CustomerRepository;
import com.alioktay.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class LoadInitialData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public LoadInitialData(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Customer customer = this.customerRepository.save(new Customer("John Doe", "Graz / Austria", new Date(), false, Type.MAJOR));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "product 1", new BigDecimal(100.0d), Status.CONFIRMED, customer));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "product 2", new BigDecimal(2000.0d), Status.DELIVERED, customer));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "product 3", new BigDecimal(3000.0d), Status.IN_PROGRESS, customer));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "product 4", new BigDecimal(5000.0d), Status.ORDERED, customer));

        Customer customer2 = this.customerRepository.save(new Customer("Ali Oktay", "Istanbul / Turkey", new Date(), true, Type.MINOR));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "product 1", new BigDecimal(100.0d), Status.CONFIRMED, customer2));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "product 2", new BigDecimal(2000.0d), Status.DELIVERED, customer2));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "product 3", new BigDecimal(6000.0d), Status.IN_PROGRESS, customer2));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "product 4", new BigDecimal(22000.0d), Status.ORDERED, customer2));

        Customer customer3 = this.customerRepository.save(new Customer("Nikola Tesla", "Belgrade / Serbia", new Date(), true, Type.VIP));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "product 1", new BigDecimal(150.0d), Status.CONFIRMED, customer3));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "product 2", new BigDecimal(3000.0d), Status.DELIVERED, customer3));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "product 3", new BigDecimal(5100.0d), Status.IN_PROGRESS, customer3));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "product 4", new BigDecimal(16000.0d), Status.ORDERED, customer3));

    }
}
