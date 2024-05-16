package com.zolochevskyi.domain;

import com.zolochevskyi.domain.Delivery;
import com.zolochevskyi.domain.Product;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class DeliveryProducts {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @Basic
    @Column(name = "weight")
    private Double weight;
    @Basic
    @Column(name = "price")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product_id;
    @ManyToOne
    @JoinColumn(name = "delivery_id", referencedColumnName = "id", nullable = false)
    private Delivery delivery_id;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.zolochevskyi.domain.DeliveryProducts that = (com.zolochevskyi.domain.DeliveryProducts) o;
        return Objects.equals(product_id, that.product_id) && Objects.equals(delivery_id, that.delivery_id) && Objects.equals(quantity, that.quantity) && Objects.equals(weight, that.weight) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, weight, price);
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public Delivery getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(Delivery delivery_id) {
        this.delivery_id = delivery_id;
    }
}