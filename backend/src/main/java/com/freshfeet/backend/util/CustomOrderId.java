package com.freshfeet.backend.util;

import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.id.enhanced.Optimizer;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@IdGeneratorType(CustomShopOrderGenerator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface CustomOrderId {

    String name();

    String prefix();

    int startWith() default 1000;

    int incrementBy() default 50;

    Class<? extends Optimizer> optimizer() default Optimizer.class;

}
