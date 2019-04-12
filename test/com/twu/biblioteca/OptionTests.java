package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class OptionTests {

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

    @Test
    public void makeNewOption() {
        //given
        //when
        Option option = new Option("quit");
        //then
        assertThat(option, is(notNullValue()));
    }

    @Test
    public void displayOption() {
        //given
        Option option = new Option("quit");
        //when
        String result = option.toString();
        //then
        assertThat(result, is("quit"));
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
}
