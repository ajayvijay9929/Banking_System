package bank_management;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JTextField;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class EncryptionData {

    String originalData;
  

     private static SecretKey generateAESKey() throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        byte[] keyBytes = new byte[16];
        secureRandom.nextBytes(keyBytes);

        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        keyBytes = sha.digest(keyBytes);
        
        return new SecretKeySpec(keyBytes, "AES");
    }

    public String enterEncrypt(String data) throws Exception{
       SecretKey key =  generateAESKey();
       byte byteArray[]= encrypt(data,key);

    //    two mwthod of encoding 

       String utf8String = new String(byteArray, StandardCharsets.UTF_8);

      // Convert byte array to string using another encoding (e.g., ISO-8859-1)
       String isoString = new String(byteArray, StandardCharsets.ISO_8859_1);

       System.out.println("UTF-8 String: " + utf8String);
       return utf8String;
    }

    // Encrypt data using AES
    private static byte[] encrypt(String data, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
    }

    // Decrypt data using AES
    private static String decrypt(byte[] encryptedData, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedData);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public  void main(String[] args) throws Exception {
       
        String originalData="vijay";
        // Generate a secure encryption key
        SecretKey secretKey = generateAESKey();

        // Encrypt the data
        byte[] encryptedData = encrypt(originalData, secretKey);

        // Decrypt the data
        String decryptedData = decrypt(encryptedData, secretKey);

        // Display the results
        System.out.println("Original Data: " + originalData);
        System.out.println("Encrypted Data (Base64): " + java.util.Base64.getEncoder().encodeToString(encryptedData));
        System.out.println("Decrypted Data: " + decryptedData);
    }

    // Generate a secure AES encryption key
   
}

