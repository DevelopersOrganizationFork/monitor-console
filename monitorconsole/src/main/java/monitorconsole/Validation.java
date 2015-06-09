/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorconsole;

import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author akis
 */
public class Validation {

    public static boolean isLoginProper(JTextField jLogin) {
        if (jLogin.getText().equals("")) {
            jLogin.setForeground(Color.red);
            jLogin.setText("* Required field!");
            return false;
        } else {
            if (jLogin.getForeground().getRed() == 255) {
                jLogin.setText("* Required field!");
                return false;
            }
        }
        return true;
    }

    public static boolean ifPasswordsExist(JPasswordField... jPasswordField1) {
        int i = 0;
        String mask = "";
        boolean proper = true;
        System.out.println("Rozmiar kolejki: " + jPasswordField1.length);
        for (int k = 0; k < jPasswordField1.length; ++k) {
            if ((jPasswordField1[k].getPassword().length == 0)) {
                i++;
                jPasswordField1[k].setForeground(Color.red);
                for (int j = 0; j < i; ++j) {
                    mask += "*";
                }
                jPasswordField1[k].setText(mask);
                proper = false;
            }
        }
        return proper;
    }
    
//TODO dopisac czy login ma minimum 5 znakow

    public static boolean ifStrongPassword(JPasswordField jPasswordField1) {
//dopisac reszte sprawdzania hasla czy jest litera cyfra i znak specjalny        
        if (jPasswordField1.getPassword().length < 8) {
            return false;
        }
        return true;
    }

    static public boolean checkIfPasswordsMatches(JPasswordField jPasswordField1, JPasswordField jPasswordField2) {
        if (Arrays.equals(jPasswordField1.getPassword(), jPasswordField2.getPassword())) {
            //zakoduj md5 i wystaw RESTA
            byte[] bytesOfMessage = null;
            try {
                bytesOfMessage = Arrays.toString(jPasswordField1.getPassword()).getBytes("UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(NewAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(NewAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Zakodowane to MD5 " + md.digest(bytesOfMessage));
            return false;
        }
        return true;
    }
}
