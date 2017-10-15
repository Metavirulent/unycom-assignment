package com.alioktay.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer implements Serializable {

    @Id
    @Column(length = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String code;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @Column
    private boolean isActive;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private Type type;


    //TODO: solve this problem
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer" )
    private Set<Order> orders = new HashSet<>();

    public Customer() {
    }

    public Customer(String name, String location, Date registrationDate, boolean isActive, Type type) {
        this.name = name;
        this.location = location;
        this.registrationDate = registrationDate;
        this.isActive = isActive;
        this.type = type;
    }

    public Customer(String name, String location, Date registrationDate, boolean isActive, Type type, Set<Order> orders) {
        this.name = name;
        this.location = location;
        this.registrationDate = registrationDate;
        this.isActive = isActive;
        this.type = type;
        this.orders = orders;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", registrationDate=" + registrationDate +
                ", isActive=" + isActive +
                ", type='" + type + '\'' +
                ", orders=" + orders +
                '}';
    }
}