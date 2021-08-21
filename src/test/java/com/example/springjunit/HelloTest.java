package com.example.springjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTest {

    @Test
    public void helloTest() throws Exception {
        //given
        Hello hello = new Hello();
        //then
        assertNotNull(hello);
        
    }
}