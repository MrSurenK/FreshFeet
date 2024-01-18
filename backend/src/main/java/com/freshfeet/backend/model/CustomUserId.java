package com.freshfeet.backend.model;

import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.id.enhanced.Optimizer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@IdGeneratorType(CustomUserIdGenerator.class)
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface CustomUserId {

    String name();
    int startWith() default 1;
    int incrementBy() default 1;
    Class<? extends Optimizer>optimizer() default Optimizer.class;
}
