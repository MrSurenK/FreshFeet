package com.freshfeet.backend.controller;
import com.freshfeet.backend.model.UserAccount;

import com.freshfeet.backend.repository.UserAccountRepository;
import com.freshfeet.backend.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path="test")
public class UserAccountController {
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private StorageService storageService;


    @PostMapping(path="add")
    public @ResponseBody String addNewUser (@RequestParam String name) {

        try {
            UserAccount n = new UserAccount();
            n.setName(name);
            n.setDisplayPic(storageService.getDefaultImage());
            userAccountRepository.save(n);

            return "Saved";
        } catch (Exception e){
//          System.out.println("Compressed image size:" + storageService.getDefaultImage().length);
            return "Error: " + e.getMessage();
        }

    }

}

