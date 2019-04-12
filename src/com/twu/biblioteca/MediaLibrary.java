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

    abstract int size();

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

    boolean checkOutItemByTitle(String title) {
        for (MediaItem item : items) {
            if (item.title.equals(title)) {
                item.setInStock(false);
                return true;
            }
        }
        return false;
    }

    boolean returnItemByTitle(String title) {
        for (MediaItem item : items) {
            //check if already in stock??
            if (item.title.equals(title)) {
                item.setInStock(true);
                return true;
            }
        }
        return false;
    }
}
