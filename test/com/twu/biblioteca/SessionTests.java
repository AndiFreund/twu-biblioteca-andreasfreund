package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class SessionTests {

    Session session;

    //https://stackoverflow.com/a/1119559
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setUp() {
        session = new Session();
        session.setUp();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    private String generateBookResultString(int from, int to) {
        String result = "";
        for(int i = from; i <= to; i++) {
            result += "book" + i + "\t\tauthor" + i + "\t\t200" + i + "\n";
        }
        return result;
    }

    @Test
    public void testSetUpTest() {
        //given
        Session testSession = new Session();
        assertThat(testSession.displayOptions(), is(""));
        assertThat(testSession.displayAvailableBooks(), is(""));
        //when
        testSession.setUp();
        //then
        assertThat(testSession.displayOptions(), is(not("")));
        assertThat(testSession.displayAvailableBooks(), is(not("")));
    }

    @Test
    public void welcomeMessageTest() {
        //given
        //when
        String message = session.displayWelcomeMessage();
        //then
        assertThat(message, is("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!"));
    }

    @Ignore
    @Test
    public void listOfBooksTest() {
        //given
        String fakeList = "book1\nbook2\nbook3\n";
        //when
        String message = session.displayAvailableBooks();
        //then
        assertThat(message, is(fakeList));
    }

    @Test
    public void listOfBooksWithAdditionalDataTest() {
        //given
        String fakeList = generateBookResultString(1, 3);
        //when
        String message = session.displayAvailableBooks();
        //then
        assertThat(message, is(fakeList));
    }

    @Test
    public void listOfOptionsTest() {
        //given
        String fakeListOfOptions = "quit\nlist\ncheckout\nreturn\n";
        //when
        String message = session.displayOptions();
        //then
        assertThat(message, is(fakeListOfOptions));
    }

    @Test
    public void invalidOptionInputTest() {
        //given
        String fakeMessage = "Please select a valid option!\nquit\nlist\ncheckout\nreturn\n\n";
        //when
        session.executeLibraryApplication("-1");
        //then
        assertThat(outContent.toString(), is(fakeMessage));
    }

    @Test
    public void invalidFormatInputTest() {
        //given
        String fakeMessage = "Please select a valid option!\nquit\nlist\ncheckout\nreturn\n\n";
        //when
        session.executeLibraryApplication("abc");
        //then
        assertThat(outContent.toString(), is(fakeMessage));
    }

    @Test
    public void exitExecutionTest() {
        //TODO
    }

    @Test
    public void listExecutionTest() {
        //given
        String fakeList = generateBookResultString(1, 3);
        fakeList += "\n";
        //when
        session.executeLibraryApplication("list");
        //then
        assertThat(outContent.toString(), is(fakeList));
    }

    @Ignore
    @Test
    public void argumentTest() {
        session.executeLibraryApplication("checkout test");
        assertThat(outContent.toString(), is("test\n"));
    }

    @Test
    public void checkoutExecutionTest() {
        //given
        setUp();
        String result = generateBookResultString(2, 3);
        //when
        session.executeLibraryApplication("checkout book1");
        //then
        assertThat(session.displayAvailableBooks(), is(result));
    }

    @Test
    public void checkoutSuccessfulTest() {
        //given
        setUp();
        String result = "Thank you! Enjoy the book\n";
        //when
        session.executeLibraryApplication("checkout book1");
        //then
        assertThat(outContent.toString(), is(result));
    }

    @Test
    public void checkoutFailedTest() {
        //given
        setUp();
        String result = "Sorry, that book is not available\n";
        //when
        session.executeLibraryApplication("checkout book0");
        //then
        assertThat(outContent.toString(), is(result));
    }

    @Test
    public void returnBookSuccessTest() {
        //given
        setUp();
        String fakeResult = generateBookResultString(1, 3);
        session.getBooks().get(0).setInStock(false);
        //when
        session.executeLibraryApplication("return book1");
        //then
        String result = session.displayAvailableBooks();
        assertThat(result, is(fakeResult));
    }

    @Test
    public void returnBookSuccessMessageTest() {
        //given
        setUp();
        String result = "Thank you for returning the book\n";
        session.getBooks().get(0).setInStock(false);
        //when
        session.executeLibraryApplication("return book1");
        //then
        assertThat(outContent.toString(), is(result));
    }

    @Test
    public void returnInvalidBookTest() {
        //given
        setUp();
        String result = "That is not a valid book to return\n";
        //when
        session.executeLibraryApplication("return book4");
        //then
        assertThat(outContent.toString(), is(result));
    }
}
