package com.freshfeet.backend.repository;

import com.freshfeet.backend.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;




public interface UserAccountRepository extends JpaRepository<UserAccount, String> {

    }
