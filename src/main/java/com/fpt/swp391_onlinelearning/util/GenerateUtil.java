/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.util;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class GenerateUtil {
    public static String generateOTP(){
        String alphebet="qsxwdcefvrgbthnyjmuk,il.o;/";
        StringBuilder sb = new StringBuilder();
        
        Random rd = new Random();
        
        for(int i = 0; i < 50; i++){
            int index = rd.nextInt(alphebet.length());
            sb.append(alphebet.charAt(index));
        }
        return sb.toString();
    }
}
