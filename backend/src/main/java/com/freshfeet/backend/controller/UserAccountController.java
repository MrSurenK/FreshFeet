package com.freshfeet.backend.controller;
import com.freshfeet.backend.model.UserAccount;

import com.freshfeet.backend.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="test")
public class UserAccountController {
    @Autowired
    private UserAccountRepository userAccountRepository;


    @PostMapping(path="add")
    public @ResponseBody String addNewUser (@RequestParam String name){

//        @ResponseBody
//        @RequestParam
        UserAccount n = new UserAccount();
        n.setName(name);
        userAccountRepository.save(n);
        return "Saved";
    }

}

