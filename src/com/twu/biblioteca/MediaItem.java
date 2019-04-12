package com.twu.biblioteca;

public abstract class MediaItem {

    String title;
    String year;
    boolean inStock;

    String getTitle() {
        return title;
    }

    boolean isInStock() {
        return inStock;
    }

    void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public abstract String toString();
}
