package com.example.springjunit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

    @Test
    void create1() {
        //given
        final Study study = new Study();
        //then
        assertNotNull(study);
        System.out.println("create1");
    }

    @Test
    @Disabled
    void create2() {
        //given
        System.out.println("create2");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
        System.out.println();
    }

    @AfterAll
    static void afterAll() {
        System.out.println();
        System.out.println("afterAll");

    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }

}