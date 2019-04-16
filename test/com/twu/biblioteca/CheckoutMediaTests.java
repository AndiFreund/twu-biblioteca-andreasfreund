package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class CheckoutMediaTests {


    UserSession session;
    //https://stackoverflow.com/a/1119559
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        session = new UserSession();
        session.setUp();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    private String generateBookResultString(int from, int to) {
        StringBuilder builder = new StringBuilder();
        for(int i = from; i <= to; i++) {
            builder.append("book").append(i).append("\t\tauthor").append(i).append("\t\t200").append(i).append("\n");
        }
        return builder.toString();
    }

    private String generateMovieResultString(int from, int to) {
        StringBuilder builder = new StringBuilder();
        for(int i = from; i <= to; i++) {
            builder.append("movie").append(i).append("\t\tdirector").append(i).append("\t\t200").append(i).append("\t\t").append(i).append("\n");
        }
        return builder.toString();
    }

    @Test
    public void checkoutbookExecutionTest() {
        //given
        setUp();
        session.setUser(new User("123-1234", "password123", "John Doe", "john@tw.com", "012345"));
        String result = generateBookResultString(2, 3);
        //when
        session.executeLibraryApplication("checkoutbook book1");
        //then
        assertThat(session.getBookLibrary().listAvailableItems(), is(result));
    }

    @Test
    public void checkoutbookSuccessfulTest() {
        //given
        setUp();
        session.setUser(new User("123-1234", "password123", "John Doe", "john@tw.com", "012345"));
        String result = "Thank you! Enjoy the book\n";
        //when
        session.executeLibraryApplication("checkoutbook book1");
        //then
        assertThat(outContent.toString(), is(result));
    }

    @Test
    public void checkoutbookFailedTest() {
        //given
        setUp();
        session.setUser(new User("123-1234", "password123", "John Doe", "john@tw.com", "012345"));
        String result = "Sorry, that book is not available\n";
        //when
        session.executeLibraryApplication("checkoutbook book0");
        //then
        assertThat(outContent.toString(), is(result));
    }

    @Test
    public void checkoutmovieExecutionTest() {
        //given
        setUp();
        session.setUser(new User("123-1234", "password123", "John Doe", "john@tw.com", "012345"));
        String result = generateMovieResultString(2, 3);
        //when
        session.executeLibraryApplication("checkoutmovie movie1");
        //then
        assertThat(session.getMovieLibrary().listAvailableItems(), is(result));
    }

    @Test
    public void checkoutMovieSuccessfulTest() {
        //given
        setUp();
        session.setUser(new User("123-1234", "password123", "John Doe", "john@tw.com", "012345"));
        String result = "Thank you! Enjoy the movie\n";
        //when
        session.executeLibraryApplication("checkoutmovie movie1");
        //then
        assertThat(outContent.toString(), is(result));
    }

    @Test
    public void checkoutmovieFailedTest() {
        //given
        setUp();
        session.setUser(new User("123-1234", "password123", "John Doe", "john@tw.com", "012345"));
        String result = "Sorry, that movie is not available\n";
        //when
        session.executeLibraryApplication("checkoutmovie movie");
        //then
        assertThat(outContent.toString(), is(result));
    }

    @Test
    public void checkoutNotLoggedinBookTest() {
        //given
        setUp();
        session.setUser(null);
        //when
        session.executeLibraryApplication("checkoutbook book1");
        //then
        assertThat(outContent.toString(), is(not("Thank you! Enjoy the book\n")));
    }

    @Test
    public void checkoutNotLoggedinMovieTest() {
        //given
        setUp();
        session.setUser(null);
        //when
        session.executeLibraryApplication("checkoutmovie movie1");
        //then
        assertThat(outContent.toString(), is(not("Thank you! Enjoy the movie\n")));
    }

    @Test
    public void checkoutUserAccountableTest() {
        //given
        setUp();
        session.setUser(new User("123-1234", "password123", "John Doe", "john@tw.com", "012345"));
        Book item = null;
        try {
            item = (Book) session.getBookLibrary().getByTitle("book1");
        } catch (MediaUnknownException e) {
            e.printStackTrace();
        }
        assertThat(item, is(notNullValue()));
        assertThat(item.customer, is(nullValue()));
        //when
        session.executeLibraryApplication("checkoutbook book1");
        //then
        assertThat(item.customer, is(not(nullValue())));
    }
}
