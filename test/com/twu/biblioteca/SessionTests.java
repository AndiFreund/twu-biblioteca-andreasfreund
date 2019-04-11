package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class SessionTests {

    Session session = new Session();

    @Before
    public void setUp() {
        session.setUp();
    }

    @Test
    public void testSetUp() {
        //given
        Session testSession = new Session();
        assertThat("", is(equalTo(testSession.displayOptions())));
        assertThat("", is(equalTo(testSession.displayBooks())));
        //when
        testSession.setUp();
        //then
        assertThat("", is(not(equalTo(testSession.displayOptions()))));
        assertThat("", is(not(equalTo(testSession.displayBooks()))));
    }

    @Test
    public void welcomeMessage() {
        //given
        //when
        String message = session.displayWelcomeMessage();
        //then
        assertThat("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!", is(equalTo(message)));
    }

    @Ignore
    @Test
    public void listOfBooks() {
        //given
        String fakeList = "book1\nbook2\nbook3\n";
        //when
        String message = session.displayBooks();
        //then
        assertThat(fakeList, is(equalTo(message)));
    }

    @Test
    public void listOfBooksWithAdditionalData() {
        //given
        String fakeList = new String();
        for(int i = 1; i <= 3; i++) {
            fakeList += "book" + i + "\t\tauthor" + i + "\t\t200" + i + "\n";
        }
        //when
        String message = session.displayBooks();
        //then
        assertThat(fakeList, is(equalTo(message)));
    }

    @Test
    public void listOfOptions() {
        //given
        String fakeListOfOptions = "0: exit\n1: list of books\n";
        //when
        String message = session.displayOptions();
        //then
        assertThat(fakeListOfOptions, is(equalTo(message)));
    }
}
