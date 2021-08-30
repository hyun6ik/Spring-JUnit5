package com.example.springjunit;

import com.example.springjunit.study.Study;
import com.example.springjunit.study.StudyStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

public class CustomTagTest {


    @FastTest
    @DisplayName("스터디 만들기 fast")
    void create_new_study() {
        final Study study = new Study(StudyStatus.ENDED, 100);
        assertThat(study.getLimit()).isGreaterThan(0);
    }
}
