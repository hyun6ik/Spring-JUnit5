package com.example.springjunit;

import com.example.springjunit.study.Study;
import com.example.springjunit.study.StudyStatus;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

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
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "local")
    void EnableIfEnvironmentVariableTest() {
        //given
        final Study study = new Study(StudyStatus.ENDED, 10);
        //then
        assertThat(study.getLimit()).isGreaterThan(9);
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "TEST_ENV", matches = "prod")
    void DisableEnableIfEnvironmentVariableTest() {
        //given
        final Study study = new Study(StudyStatus.ENDED, 10);
        //then
        assertThat(study.getLimit()).isGreaterThan(9);
    }


    @Test
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_11, JRE.JAVA_13})
    void EnabledOnJRE_JAVA11() {
        //given
        final Study study = new Study(StudyStatus.ENDED, 10);
        //then
        assertThat(study.getLimit()).isGreaterThan(9);

    }

    @Test
    @DisabledOnJre(JRE.JAVA_11)
    void DisabledOnJRE_JAVA11() {
        //given
        final Study study = new Study(StudyStatus.ENDED, 10);
        //then
        assertThat(study.getLimit()).isGreaterThan(9);
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void EnabledOnOs_OS_WINDOWS() {
        //given
        final Study study = new Study(StudyStatus.ENDED, 10);
        //then
        assertThat(study.getLimit()).isGreaterThan(9);

    }

    @Test
    @EnabledOnOs(OS.MAC)
    void EnabledOnOs_OS_MAC() {
        //given
        final Study study = new Study(StudyStatus.ENDED, 10);
        //then
        assertThat(study.getLimit()).isGreaterThan(9);
    }
    @Test
    @DisabledOnOs(OS.WINDOWS)
    void DisabledOnOs_OS_WINDOWS() {
        //given
        final Study study = new Study(StudyStatus.ENDED, 10);
        //then
        assertThat(study.getLimit()).isGreaterThan(9);

    }

    @Test
    @DisabledOnOs(OS.MAC)
    void DisabledOnOs_OS_MAC() {
        //given
        final Study study = new Study(StudyStatus.ENDED, 10);
        //then
        assertThat(study.getLimit()).isGreaterThan(9);
    }

    @Test
    void assumeTrue() {
        //given
        Assumptions.assumeTrue("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")));

        final Study study = new Study(StudyStatus.ENDED, -10);
        //then
        assertAll(
                () ->   assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 " +  StudyStatus.DRAFT + " 상태여야 한다."),
                () -> assertTrue(study.getLimit() > 0, () -> "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
        );
    }

    @Test
    void assumingThatTest() {
        //given
        final Study study = new Study(StudyStatus.ENDED, 10);

        //then
        assumingThat("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")), () -> {
            assertEquals(StudyStatus.ENDED, study.getStatus());
        });

        assumingThat("ENV".equalsIgnoreCase(System.getenv("TEST_ENV")), () -> {
            assertEquals(StudyStatus.ENDED, study.getStatus());
        });
        assumingThat("PROD".equalsIgnoreCase(System.getenv("TEST_ENV")), () -> {
            assertEquals(StudyStatus.ENDED, study.getStatus());
        });
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
        assertTimeoutPreemptively(Duration.ofMillis(400), () -> {
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