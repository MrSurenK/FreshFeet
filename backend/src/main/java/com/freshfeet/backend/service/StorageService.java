package com.freshfeet.backend.service;

import com.freshfeet.backend.model.UserAccount;
import com.freshfeet.backend.repository.UserAccountRepository;
import com.freshfeet.backend.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private UserAccountRepository repository;


    //Method to upload image
    public String uploadDp(MultipartFile file, String userId) throws IOException {

        // Get hold of the account
        Optional<UserAccount> findUser = repository.findById(userId);
        if (findUser.isPresent()) {
            UserAccount userAccount = findUser.get();


            // compress the byte data of the image and set it to display pic
            byte[] compressedImg = ImageUtils.compressImage(file.getBytes());

                userAccount.setDisplayPic(compressedImg);

                try {
                    repository.save(userAccount);
                    return "Upload Successful";
                } catch (Exception e) {
                    return "Upload failed: " + e.getMessage();
                }

        } else {
            return "User not found";
        }
    }

    public byte[] downloadImage(String userId){
        Optional<UserAccount> findUser = repository.findById(userId);
        if (findUser.isPresent()){
            UserAccount userAccount = findUser.get();

            //download the image from the user account to be served to front-end
            return ImageUtils.decompressImage(userAccount.getDisplayPic());

        }
        return null;
    }

    public byte[] getDefaultImage(){
        try {
            //Load the image as a Resource
            ClassPathResource imgFile = new ClassPathResource(("defaultdp/img.png"));
            byte[] imageBytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
            //Convert the image to a byte array
            return ImageUtils.compressImage(imageBytes);
        } catch(IOException e){
            throw new RuntimeException("Failed to load default image", e);
        }

    }

}





