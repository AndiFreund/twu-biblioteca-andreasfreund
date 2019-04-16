package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public abstract class MediaLibrary {

    List<MediaItem> items = new ArrayList<>();

    MediaItem getByTitle(String title) throws MediaUnknownException {
        for (MediaItem item : items) {
            if (item.title.equals(title)) {
                return item;
            }
        }
        throw new MediaUnknownException();
    }

    int size() {
        return items.size();
    }

    String listAvailableItems() {
        StringBuilder builder = new StringBuilder();
        for (MediaItem item : items) {
            if (item.isInStock()) {
                builder.append(item.toString());
                builder.append("\n");
            }
        }

        return builder.toString();
    }

    boolean checkOutItemByTitle(User user, String title) {
        for (MediaItem item : items) {
            if (item.title.equals(title)) {
                itemTransition(user, item, false);
                return true;
            }
        }
        return false;
    }

    boolean returnItemByTitle(String title) {
        for (MediaItem item : items) {
            //check if already in stock??
            if (item.title.equals(title)) {
                itemTransition(null, item, true);
                return true;
            }
        }
        return false;
    }

    private void itemTransition(User customer, MediaItem item, boolean returnToLibrary) {
        item.setInStock(returnToLibrary);
        item.setCustomer(customer);
    }
}
