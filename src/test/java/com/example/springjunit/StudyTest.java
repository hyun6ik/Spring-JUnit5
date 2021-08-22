package com.example.springjunit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("테스트 제목 만들기 \uD83D\uDE31")
    void create1_this_underscore_maybe_delete() {
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