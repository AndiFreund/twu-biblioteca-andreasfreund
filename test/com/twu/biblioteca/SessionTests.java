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
        String fakeList = new String();
        for(int i = 1; i <= 3; i++) {
            fakeList += "book" + i + "\t\tauthor" + i + "\t\t200" + i + "\n";
        }
        //when
        String message = session.displayAvailableBooks();
        //then
        assertThat(message, is(fakeList));
    }

    @Test
    public void listOfOptionsTest() {
        //given
        String fakeListOfOptions = "quit\nlist\ncheckout\n";
        //when
        String message = session.displayOptions();
        //then
        assertThat(message, is(fakeListOfOptions));
    }

    @Test
    public void invalidOptionInputTest() {
        //given
        String fakeMessage = "Please select a valid options!\nquit\nlist\ncheckout\n\n";
        //when
        session.executeLibraryApplication("-1");
        //then
        assertThat(outContent.toString(), is(fakeMessage));
    }

    @Test
    public void invalidFormatInputTest() {
        //given
        String fakeMessage = "Please select a valid options!\nquit\nlist\ncheckout\n\n";
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
        String fakeList = new String();
        for(int i = 1; i <= 3; i++) {
            fakeList += "book" + i + "\t\tauthor" + i + "\t\t200" + i + "\n";
        }
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
        String result = new String();
        for(int i = 2; i <= 3; i++) {
            result += "book" + i + "\t\tauthor" + i + "\t\t200" + i + "\n";
        }
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
}
