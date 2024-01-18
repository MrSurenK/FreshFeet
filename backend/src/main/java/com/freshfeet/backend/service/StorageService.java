package com.freshfeet.backend.service;

import com.freshfeet.backend.model.UserAccount;
import com.freshfeet.backend.repository.UserAccountRepository;
import com.freshfeet.backend.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StorageService {
    @Autowired
    private UserAccountRepository repository;


    //Method to upload image
    public String uploadDp(MultipartFile file, String userName) throws IOException {


        //Create a new User Instance
        UserAccount userAccount = new UserAccount();
        userAccount.setName(userName);
        // compress the byte data of the image and set it to display pic
        userAccount.setDisplayPic(ImageUtils.compressImage(file.getBytes()));


        try{
            //Save the UserAccount object
            UserAccount image = repository.save(userAccount);
            return "Upload Successful!";

        } catch (Exception e){
            return "Upload failed: " + e.getMessage();
        }

    }

}
