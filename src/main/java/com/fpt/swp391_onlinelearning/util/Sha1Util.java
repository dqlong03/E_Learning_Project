/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tran Hoang Phuc
 */
public class Sha1Util {

    public static String toSHA1(String password) {
        String salt = "qwerwjknaasr3912e'';'lafdanbm";
        String result = null;
        try {
            String saltPassword = password + salt;
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(saltPassword.getBytes("UTF-8"));
            byte[] hashBytes = md.digest();
            result = Base64.getEncoder().encodeToString(hashBytes);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(Sha1Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
