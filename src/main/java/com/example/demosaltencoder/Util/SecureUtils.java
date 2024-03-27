package com.example.demosaltencoder.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
public class SecureUtils{
//    private static Random rand = new Random(new Date().getTime());
    public static byte[] getSaltedHashSHA512(String password,byte[] salt1){
        byte[] salt = salt1;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(salt);
        byte bytesdata[] = md.digest(password.getBytes());
        md.reset();
        return bytesdata;
//        String salt = BCrypt.gensalt();
//        String encodedPassword =
    }
    public static byte[] createSalt(){ //generating random salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
    public static byte[] fromHex(String hex){
        byte[] binary = new byte[hex.length()/2];
        for(int i = 0 ;i< binary.length;i++){
            binary[i] = (byte) Integer.parseInt(hex.substring(2*i,2*i+2),16);
        }
        return binary;
    }
    public static String toHex(byte[] array){
        BigInteger bi = new BigInteger(1,array);
        String hex = bi.toString(6);
        int paddingLength = (array.length*2) - hex.length();
        if(paddingLength > 0){
            return String.format("%0"+paddingLength+"d",0)+hex;
        }else{
            return hex;
        }
    }
}
