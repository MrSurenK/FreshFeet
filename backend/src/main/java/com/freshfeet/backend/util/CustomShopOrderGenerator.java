package com.freshfeet.backend.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomShopOrderGenerator implements IdentifierGenerator {

    private static String prefix;

    public Serializable generate(
            SharedSessionContractImplementor session,
            Object object
    ) throws HibernateException {


        // Access class field via reflection
        for (Field field: object.getClass().getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(CustomOrderId.class) && field.getType().equals(String.class)){
                CustomOrderId annotation = field.getAnnotation(CustomOrderId.class);
                prefix = annotation.prefix();
                break;
            }
        }

        String sql = String.format("SELECT MAX(CAST(SUBSTRING(order_id, LENGTH('%s') + 1) AS UNSIGNED)) FROM shop_order WHERE order_id LIKE '%s%%'", prefix, prefix);
        Object result = session.createNativeQuery(sql,Integer.class).uniqueResult();

        int nextId = 50;
            if(result!=null){
                String maxId = result.toString();
                nextId = Integer.parseInt(maxId) + 50;
            }

        return  prefix +
                IntStream.range(0,8 - String.valueOf(nextId).length())
                        .mapToObj(i -> "0")
                        .collect(Collectors.joining(""))+ nextId;
    }


}
