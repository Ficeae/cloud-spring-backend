package com.zolochevskyi.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "manufacturer", length = 50, nullable = false)
    private String manufacturer;
    @Basic
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Basic
    @Column(name = "category", length = 50)
    private String category;
    @Basic
    @Column(name = "price")
    private Double price;
    @Basic
    @Column(name = "arrived", nullable = false)
    private Timestamp arrived;
    @Basic
    @Column(name = "expired")
    private Date expired;
    @Basic
    @Column(name = "is_available")
    private Boolean is_available;

    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private Shop shop;

    @OneToMany(mappedBy = "product_id")
    private List<DeliveryProducts> deliveryProducts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Timestamp getArrived() {
        return arrived;
    }

    public void setArrived(Timestamp arrived) {
        this.arrived = arrived;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public Boolean getIs_available() {
        return is_available;
    }

    public void setIs_available(Boolean is_available) {
        this.is_available = is_available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(manufacturer, product.manufacturer)
                && Objects.equals(name, product.name) && Objects.equals(category, product.category)
                && Objects.equals(price, product.price) && Objects.equals(arrived, product.arrived);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manufacturer, name, category, price, arrived, expired, is_available);
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
