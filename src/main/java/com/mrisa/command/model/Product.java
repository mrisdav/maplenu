package com.mrisa.command.model;

import com.mrisa.command.generic.MaplenuGeneric;

public class Product extends MaplenuGeneric {
    private double unitPrice;
    private int quantity;
    private int limit;
    private Category category;
    private Spokes spokes;

    public Product(String code, String wording, double unitPrice, int quantity, int limit, Category category, Spokes spokes) {
        super(code, wording);
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.limit = limit;
        this.category = category;
        this.spokes = spokes;
    }

    public Product(String wording, double unitPrice, int quantity, int limit, Category category, Spokes spokes) {
        super(wording);
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.limit = limit;
        this.category = category;
        this.spokes = spokes;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Spokes getSpokes() {
        return spokes;
    }

    public void setSpokes(Spokes spokes) {
        this.spokes = spokes;
    }
}
