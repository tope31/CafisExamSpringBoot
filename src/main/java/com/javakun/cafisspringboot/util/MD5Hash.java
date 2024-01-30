package com.javakun.cafisspringboot.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.javakun.cafisspringboot.model.StaticUserList.users;


public class MD5Hash {
    public String toMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encoded = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : encoded) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to hash string with MD5", e);
        }
    }

    public boolean authenticate(String username, String password) {
        String hashedPassword = toMD5(password);
        return users.stream()
                .anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(hashedPassword));
    }
}
