package com.freshfeet.backend.util;

import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.id.enhanced.Optimizer;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@IdGeneratorType(CustomUserIdGenerator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface CustomUserId {

    String name();//Mandatory parameter in annotation
    String prefix(); //Mandatory parameter in annotation
    int startWith() default 1;
    int incrementBy() default 1;
    Class<? extends Optimizer>optimizer() default Optimizer.class;
}

