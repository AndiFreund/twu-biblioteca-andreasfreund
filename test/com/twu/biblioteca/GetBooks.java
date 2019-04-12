package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class GetBooks {

    private String generateBookResultString(int from, int to) {
        StringBuilder builder = new StringBuilder();
        for(int i = from; i <= to; i++) {
            builder.append("book" + i + "\t\tauthor" + i + "\t\t200" + i + "\n");
        }
        return builder.toString();
    }

    @Test
    public void setUpTest() {
        //given
        //when
        MediaLibrary bookLibrary = new BookLibrary();
        //then
        assertThat(bookLibrary.size(), is(not(0)));
    }

    @Test
    public void getBookByTitle() {
        //given
        String result = "book1";
        //when
        MediaLibrary bookLibrary = new BookLibrary();
        String title = null;
        try {
            title = bookLibrary.getByTitle("book1").getTitle();
        } catch (MediaUnknownException e) {
            e.printStackTrace();
        }
        //then
        assertThat(title, is(result));
    }

    @Test (expected = MediaUnknownException.class)
    public void getUnknownBookTest() throws MediaUnknownException {
        //given
        //when
        MediaLibrary bookLibrary = new BookLibrary();
        bookLibrary.getByTitle("book");
        //then
    }

    @Test
    public void listAvailableItems() {
        //given
        String fakeResult = generateBookResultString(1, 3);
        //when
        MediaLibrary bookLibrary = new BookLibrary();
        String result = bookLibrary.listAvailableItems();
        //then
        assertThat(result, is(fakeResult));
    }
}
