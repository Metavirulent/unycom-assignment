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
import java.time.LocalDate;
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
        Customer customer = this.customerRepository.save(new Customer("Leanne Graham", "Kulas Light Apt. 556 Gwenborough", new Date(), false, Type.MAJOR));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Intelligent Fresh Mouse", new BigDecimal(529), Status.CONFIRMED, customer));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Generic Granite Cheese", new BigDecimal(691), Status.DELIVERED, customer));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Unbranded Concrete Pants", new BigDecimal(120), Status.IN_PROGRESS, customer));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Rustic Granite Ball", new BigDecimal(5000), Status.ORDERED, customer));

        Customer customer2 = this.customerRepository.save(new Customer("Ervin Howell", "Victor Plains Suite 879 Wisokyburgh", new Date(), true, Type.MINOR));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Awesome Frozen Pants", new BigDecimal(100), Status.CONFIRMED, customer2));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Licensed Rubber Car", new BigDecimal(2000), Status.DELIVERED, customer2));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Handcrafted Cotton Table", new BigDecimal(6000), Status.IN_PROGRESS, customer2));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Steel Towels", new BigDecimal(22000), Status.ORDERED, customer2));

        Customer customer3 = this.customerRepository.save(new Customer("Clementine Bauch", "Douglas Extension Suite 847 McKenziehaven", new Date(), true, Type.VIP));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Awesome Granite Mouse", new BigDecimal(150), Status.CONFIRMED, customer3));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Licensed Wooden Chair", new BigDecimal(3000), Status.DELIVERED, customer3));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Sleek Cotton Bacon", new BigDecimal(5100), Status.IN_PROGRESS, customer3));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Refined Fresh Table", new BigDecimal(16000), Status.ORDERED, customer3));

        Customer customer4 = this.customerRepository.save(new Customer("Patricia Lebsack", "Hoeger Mall Apt. 692 South Elvis", new Date(), true, Type.POOR));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Handcrafted Plastic Sausages", new BigDecimal(150), Status.CONFIRMED, customer4));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Ergonomic Steel Cheese", new BigDecimal(3000), Status.DELIVERED, customer4));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Refined Soft Keyboard", new BigDecimal(5100), Status.IN_PROGRESS, customer4));
        this.orderRepository.save(new Order(new Date(), new Date(), new Date(), "Gorgeous Wooden Pizza", new BigDecimal(16000), Status.ORDERED, customer4));
    }
}
