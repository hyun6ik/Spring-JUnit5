package com.example.springjunit;

import com.example.springjunit.study.Study;
import com.example.springjunit.study.StudyStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatTest {

    @DisplayName("반복실행 테스트")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println("RepeatTest " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("ParameterizedTest")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "풀리고", "있네요."})
    void parameterizedTest(String message) {
        System.out.println(message);
    }

    @DisplayName("ParameterizedTest")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "풀리고", "있네요."})
    @EmptySource
    @NullSource
    void parameterizedTest2(String message) {
        System.out.println(message);
    }

    @DisplayName("ParameterizedTest")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(ints = {10,20,40})
    void parameterizedTest3(Integer limit) {
        System.out.println(limit);
    }

    @DisplayName("ParameterizedTest")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(ints = {10,20,40})
    void parameterizedTest3(@ConvertWith(StudyConverter.class) Study study) {
        System.out.println(study.getLimit());
    }

    public static class StudyConverter extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "Study 객체로만 변환 가능");
            return new Study(StudyStatus.ENDED, Integer.parseInt(source.toString()));
        }
    }


    @DisplayName("ParameterizedTest")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"홍길동, 100", "아아아,200"})
    void parameterizedTest4(String name, Integer age) {
        final Person person = new Person(name, age);
        System.out.println(person);
    }

    @DisplayName("ParameterizedTest")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"홍길동, 100", "아아아,200"})
    void parameterizedTest5(ArgumentsAccessor argumentsAccessor) {
        final Person person = new Person(argumentsAccessor.getString(0), argumentsAccessor.getInteger(1));
        System.out.println(person);
    }

    @DisplayName("ParameterizedTest")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"홍길동, 100", "아아아,200"})
    void parameterizedTest5(@AggregateWith(PersonAggregator.class) Person person) {
        System.out.println(person);
    }

    public static class PersonAggregator implements ArgumentsAggregator {

        @Override
        public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
           return new Person(accessor.getString(0), accessor.getInteger(1));

        }
    }
}
