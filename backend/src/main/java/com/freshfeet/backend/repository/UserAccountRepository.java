package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserAccountRepository extends JpaRepository<UserAccount, String> {

    }
