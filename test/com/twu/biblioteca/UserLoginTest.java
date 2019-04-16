package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserLoginTest {


    private UserSession session;

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
    public void validUserLoginTest() {
        //given
        setUp();
        //when
        session.executeLibraryApplication("login 123-1234 password123");
        //then
        assertThat(session.isLoggedIn(), is(true));
    }

    @Test
    public void validUserPassword() {
        //given
        User user = new User("123-1234", "password123", "John Doe", "john@tw.com", "012345");
        //when
        boolean result = user.validPassword("password123");
        //then
        assertThat(result, is(true));
    }

    @Test
    public void invalidUserPassword() {
        //given
        User user = new User("123-1234", "password123", "John Doe", "john@tw.com", "012345");
        //when
        boolean result = user.validPassword("password");
        //then
        assertThat(result, is(false));
    }

    @Test
    public void listContactDetailsTest() {
        //given
        setUp();
        User user = new User("123-1234", "password123", "John Doe", "john@tw.com", "012345");
        session.setUser(user);
        String fakeResult = "John Doe, john@tw.com, 012345\n";
        //when
        session.executeLibraryApplication("mycontact");
        //then
        assertThat(outContent.toString(), is(fakeResult));
    }

    @Test
    public void listContactDetailsNotLoggedInTest() {
        //given
        setUp();
        session.setUser(null);
        String fakeResult = "Please log in with command \"login\"\n";
        //when
        session.executeLibraryApplication("mycontact");
        //then
        assertThat(outContent.toString(), is(fakeResult));

    }
}
