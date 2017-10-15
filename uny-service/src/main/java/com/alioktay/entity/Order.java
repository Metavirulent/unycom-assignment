package com.alioktay.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ORDER_TABLE") // Because ORDER is reserved key in sql
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmationDate;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date completionDate;

    @Column
    private String product;

    @Column
    private BigDecimal price;

    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private Status status;

    @ManyToOne(optional = false)
    private Customer customer;

    public Order() {
    }

    public Order(Date orderDate, Date confirmationDate, Date completionDate, String product, BigDecimal price, Status status, Customer customer) {
        this.orderDate = orderDate;
        this.confirmationDate = confirmationDate;
        this.completionDate = completionDate;
        this.product = product;
        this.price = price;
        this.status = status;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
