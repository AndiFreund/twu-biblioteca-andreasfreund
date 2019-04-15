package com.twu.biblioteca;

public abstract class MediaItem {

    String title;
    String year;
    boolean inStock;
    User customer;

    String getTitle() {
        return title;
    }

    boolean isInStock() {
        return inStock;
    }

    void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public abstract String toString();
}
