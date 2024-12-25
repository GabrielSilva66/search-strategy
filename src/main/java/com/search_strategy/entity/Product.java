package com.search_strategy.entity;

import java.util.concurrent.ThreadLocalRandom;

public class Product {

    private int id;
    private String name;
    private Double price;
    private int quantity;

    public Product() {
        this.id = ThreadLocalRandom.current().nextInt(1_000_000, 10_000_000);
    }

    public Product(String name, Double price, int quantity) {
        this.id = ThreadLocalRandom.current().nextInt(1_000_000, 10_000_000);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
