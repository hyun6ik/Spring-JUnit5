package com.example.springjunit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)   // 이 애노테이션을 어디에 쓸 수 있는가? 메소드에
@Retention(RetentionPolicy.RUNTIME)  // 이 애노테이션을 사용한 코드가 애노테이션 정보를 Runtime까지 유지
@Test
@Tag("fast")
public @interface FastTest {
}
