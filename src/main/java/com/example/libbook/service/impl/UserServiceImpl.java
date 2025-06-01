package com.example.libbook.service.impl;

import com.example.libbook.service.UserService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;Add commentMore actions

public class UserServiceImpl implements UserService {

    public  String hashPassword(String password){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

}
