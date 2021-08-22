package com.example.springjunit;

import com.example.springjunit.study.Study;
import com.example.springjunit.study.StudyStatus;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("테스트 제목 만들기 \uD83D\uDE31")
    void create1_this_underscore_maybe_delete() {
        //given
        final Study study = new Study(StudyStatus.ENDED, -10);
        //then
        assertAll(
                () ->   assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 " +  StudyStatus.DRAFT + " 상태여야 한다."),
                () -> assertTrue(study.getLimit() > 0, () -> "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
        );


    }

    @Test
    void assertThrowsTest() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Study(StudyStatus.DRAFT, -10));

        assertEquals("limit은 0보다 커야한다.", exception.getMessage());

    }

    @Test
    void timeOutTest() {
        assertTimeout(Duration.ofSeconds(10), () -> new Study(StudyStatus.DRAFT, 10));
    }

    @Test
    void timeOutTest2() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(StudyStatus.DRAFT, 10);
            Thread.sleep(300);
        });
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