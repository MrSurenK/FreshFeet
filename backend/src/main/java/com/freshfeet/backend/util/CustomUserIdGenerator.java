package com.freshfeet.backend.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class CustomUserIdGenerator implements IdentifierGenerator {

    private String prefix;


    @Override
    public Serializable generate(
            SharedSessionContractImplementor session,
            Object object
    ) throws HibernateException {

        //https://www.youtube.com/watch?v=DkZr7_c9ry8&t=208s
        //Loop through all fields to find the one with custom annotation
        for (Field field: object.getClass().getDeclaredFields()){
            field.setAccessible(true); // Needed to access private field
            if (field.isAnnotationPresent(CustomUserId.class) && field.getType().equals(String.class)){
                CustomUserId annotation = field.getAnnotation(CustomUserId.class);
                prefix = annotation.prefix(); // Update the prefix
                break; // Assuming only 1 field with this annotation
            }
        }




//      String sql = "SELECT MAX(user_id) FROM user_account";
//      https://www.tutorialspoint.com/how-to-get-the-maximum-value-from-strings-with-integers-in-mysql
//        This sql query ensures that always the max id will be returned as it only extracts the integers away from the prefix given
        String sql =String.format("SELECT MAX(CAST(SUBSTRING(user_id, LENGTH('%s') + 1) AS UNSIGNED)) FROM user_account WHERE user_id LIKE '%s%%'", prefix,prefix);
//      Object result = session.createNativeQuery(sql, String.class).uniqueResult();
        Object result = session.createNativeQuery(sql,Integer.class).uniqueResult();


      int nextId = 1;
        if (result != null){
            String maxId = result.toString();
            nextId = Integer.parseInt(maxId) + 1;
        }



//        int nextId = 1;
//        if (result != null){
//            String maxId = result.toString();
//            nextId = Integer.parseInt(maxId.substring(6)) + 1;
//        }

        return prefix +
                IntStream.range(0,6 - String.valueOf(nextId).length())
                        .mapToObj(i -> "0")// -> is a lamda expression seperating params(left side) from implementation(right side)
                        .collect(Collectors.joining("")) + nextId;
    }


}
