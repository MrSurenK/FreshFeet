package com.freshfeet.backend.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(
            SharedSessionContractImplementor session,
            Object object
    ){
        String prefix = "prefix_"; //Default prefix

        //Loop through all fields to find the one with custom annotation
        for (Field field: object.getClass().getDeclaredFields()){
            field.setAccessible(true); // Needed to access private field
            if (field.isAnnotationPresent(CustomId.class) && field.getType().equals(String.class)){
                CustomId annotation = field.getAnnotation(CustomId.class);
                prefix = annotation.prefix(); // Update the prefix
                break; // Assuming only 1 field with this annotation
            }
        }

        String sql = "SELECT max(id) FROM user_account";
        Object result = session.createNativeQuery(sql, String.class).uniqueResult();

        int nextId = 1;
        if (result != null){
            String maxId = result.toString();
            nextId = Integer.parseInt(maxId.substring(6)) + 1;
        }

        return prefix +
                IntStream.range(0,6 - String.valueOf(nextId).length())
                        .mapToObj(i -> "0")// -> is a lamda expression seperating params(left side) from implementation(right side)
                        .collect(Collectors.joining("")) + nextId;
    }


}
