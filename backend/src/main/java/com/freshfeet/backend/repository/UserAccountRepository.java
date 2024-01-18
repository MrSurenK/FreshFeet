package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.UserAccount;
import org.springframework.data.repository.CrudRepository;


public interface UserAccountRepository extends CrudRepository<UserAccount, Integer>{

    }
