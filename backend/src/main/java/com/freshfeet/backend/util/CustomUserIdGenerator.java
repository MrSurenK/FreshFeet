package com.freshfeet.backend.util;

import org.hibernate.boot.model.relational.Sequence;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.factory.spi.CustomIdGeneratorCreationContext;

import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class CustomUserIdGenerator implements IdentifierGenerator {

//    public CustomUserIdGenerator(Sequence config, Member annotatedMember, CustomIdGeneratorCreationContext context){
//
//
//    }

    @Override
    public Serializable generate(
            SharedSessionContractImplementor session,
            Object object
    ){
        String sql = "SELECT max(id) FROM user_account";
        Object result = session.createNativeQuery(sql, String.class).uniqueResult();

        int nextId = 1;
        if (result != null){
            String maxId = result.toString();
            nextId = Integer.parseInt(maxId.substring(6)) + 1;
        }

        return "user_" +
                IntStream.range(0,6 - String.valueOf(nextId).length())
                        .mapToObj(i -> "0")// -> is a lamda expression seperating params(left side) from implementation(right side)
                        .collect(Collectors.joining("")) + nextId;
    }


}
