package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class OptionTests {


    @Test
    public void makeNewOption() {
        //given
        //when
        Option option = new Option(0, "exit");
        //then
        assertThat(option, is(notNullValue()));
    }

    @Test
    public void displayOption() {
        //given
        Option option = new Option(0, "exit");
        //when
        String result = option.toString();
        //then
        assertThat(result, is("0: exit"));
    }
}
