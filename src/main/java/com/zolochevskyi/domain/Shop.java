package com.zolochevskyi.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Shop {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "adress")
    private String adress;
    @OneToMany(mappedBy = "id")
    private List<Product> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(id, shop.id) && Objects.equals(country, shop.country) && Objects.equals(city, shop.city) && Objects.equals(adress, shop.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, adress);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
