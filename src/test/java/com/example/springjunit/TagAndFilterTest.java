package com.example.springjunit;

import com.example.springjunit.study.Study;
import com.example.springjunit.study.StudyStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TagAndFilterTest {

    @Test
    @DisplayName("스터디 만들기 fast")
    @Tag("fast")
    void create_new_study() {
        //given
        final Study study = new Study(StudyStatus.ENDED, 100);
        //then
        assertThat(study.getLimit()).isGreaterThan(0);
    }

    @Test
    @DisplayName("스터디 만들기 slow")
    @Tag("slow")
    void create_new_study_again() {
        //given
        final Study study = new Study(StudyStatus.ENDED, 100);
        //then
        assertThat(study.getLimit()).isLessThan(200);
    }
}
