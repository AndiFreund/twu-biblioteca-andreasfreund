package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ListBooksTests {

    UserSession session;

    @Before
    public void setUp() {
        session = new UserSession();
        session.setUp();
    }

    private String generateBookResultString(int from, int to) {
        StringBuilder builder = new StringBuilder();
        for(int i = from; i <= to; i++) {
            builder.append("book").append(i).append("\t\tauthor").append(i).append("\t\t200").append(i).append("\n");
        }
        return builder.toString();
    }

    @Ignore
    @Test
    public void listOfBooksTest() {
        //given
        String fakeList = "book1\nbook2\nbook3\n";
        //when
        String message = session.getBookLibrary().listAvailableItems();
        //then
        assertThat(message, is(fakeList));
    }

    @Test
    public void listOfBooksWithAdditionalDataTest() {
        //given
        String fakeList = generateBookResultString(1, 3);
        //when
        String message = session.getBookLibrary().listAvailableItems();
        //then
        assertThat(message, is(fakeList));
    }
}
