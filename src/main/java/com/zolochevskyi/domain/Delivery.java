package com.zolochevskyi.domain;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Delivery {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "ordered_time", nullable = false)
    private Timestamp ordered_time;
    @Basic
    @Column(name = "arrival", nullable = false)
    private Time arrival;
    @Basic
    @Column(name = "urgency_price")
    private Double urgency_price;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "delivery_id")
    private List<DeliveryProducts> deliveryProducts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getOrdered_time() {
        return ordered_time;
    }

    public void setOrdered_time(Timestamp ordered_time) {
        this.ordered_time = ordered_time;
    }

    public Time getArrival() {
        return arrival;
    }

    public void setArrival(Time arrival) {
        this.arrival = arrival;
    }

    public Double getUrgency_price() {
        return urgency_price;
    }

    public void setUrgency_price(Double urgency_price) {
        this.urgency_price = urgency_price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(id, delivery.id) && Objects.equals(ordered_time, delivery.ordered_time) && Objects.equals(arrival, delivery.arrival) && Objects.equals(urgency_price, delivery.urgency_price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ordered_time, arrival, urgency_price);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
