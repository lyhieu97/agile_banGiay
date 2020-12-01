package com.fpoly.agile.model;

public class Item {

    private Products products;

    public Item(){
    }

    public Item(Products products) {
        this.products = products;
    }


    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
