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
            builder.append("book" + i + "\t\tauthor" + i + "\t\t200" + i + "\n");
        }
        return builder.toString();
    }

    @Ignore
    @Test
    public void testSetUpTest() {
        //given
        UserSession testSession = new UserSession();
        assertThat(session.getBookLibrary().listAvailableItems(), is(""));
        //when
        testSession.setUp();
        //then
        assertThat(testSession.displayOptions(), is(not("")));
        assertThat(session.getBookLibrary().listAvailableItems(), is(not("")));
    }

    @Test
    public void welcomeMessageTest() {
        //given
        //when
        String message = session.displayWelcomeMessage();
        //then
        assertThat(message, is("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!"));
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

    @Ignore
    @Test
    public void returnBookSuccessTest() {
        //given
        setUp();
        String fakeResult = generateBookResultString(1, 3);
        //session.getBooks().get(0).setInStock(false);
        //when
        session.executeLibraryApplication("return book1");
        //then
        String result = session.getBookLibrary().listAvailableItems();
        assertThat(result, is(fakeResult));
    }
}
