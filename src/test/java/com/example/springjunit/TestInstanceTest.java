package com.example.springjunit;

import com.example.springjunit.study.Study;
import com.example.springjunit.study.StudyStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestInstanceTest {

    @BeforeAll
    void beforeAll() {

    }

    @AfterAll
    void afterAll() {

    }

    int value = 0;

    @FastTest
    @DisplayName("스터디 만들기 fast")
    void create_new_study() {
        System.out.println(this);
        System.out.println(value++);
        final Study study = new Study(StudyStatus.ENDED,1);
        assertThat(study.getLimit()).isGreaterThan(0);

    }

    @SlowTest
    @DisplayName("스터디 만들기 slow")
    void create_new_study_slow() {
        System.out.println(this);
        System.out.println("Slow " + value++);
    }
}
