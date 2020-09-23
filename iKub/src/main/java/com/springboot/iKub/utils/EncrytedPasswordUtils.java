package com.springboot.iKub.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
 
    // Encrypte Password with BCryptPasswordEncoder
    public static String encryptePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
 
    public static void main(String[] args) {
        String password = "123";
        String encryptedPassword = encryptePassword(password);
 
        System.out.println("Encrypted Password: " + encryptedPassword);
    }
     
}