package com.example.supplychainzeba17dec;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.ResultSet;

public class Login {
    private static byte[] getSHA(String input){
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private String getEncryptedPassword(String password){
        try {
            BigInteger number = new BigInteger(1, getSHA(password));
            StringBuilder hexString = new StringBuilder(number.toString(16));
            return hexString.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean customerLogin(String email, String password){
        String query = String.format("SELECT * FROM customer WHERE email= '%s' AND password= '%s'", email, password);
        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            ResultSet rs = dbCon.getQueryTable(query);
            if (rs !=null && rs.next()) {
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

//    public static void main(String[] args) {
//        Login login = new Login();
//        System.out.println(login.customerLogin("shagufa@gmail.com", "mysql123"));
//    }
     public static void main(String[] args) {
       Login login = new Login();
         System.out.println(login.getEncryptedPassword("mysql123")); //uniqueness of hexString as password is attained & length of hexString obtained will be same.
     }
}
