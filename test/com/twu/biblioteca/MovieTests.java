package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieTests {

    UserSession session;

    @Before
    public void setUp() {
        session = new UserSession();
        session.setUp();
    }

    private String generateMovieResultString(int from, int to) {
        StringBuilder builder = new StringBuilder();
        for(int i = from; i <= to; i++) {
            builder.append("movie").append(i).append("\t\tdirector").append(i).append("\t\t200").append(i).append("\t\t").append(i).append("\n");
        }
        return builder.toString();
    }

    @Test
    public void listMoviesTest() {
        //given
        String fakeResult = generateMovieResultString(1, 3);
        //when
        String result = session.getMovieLibrary().listAvailableItems();
        //then
        assertThat(result, is(fakeResult));
    }
}
