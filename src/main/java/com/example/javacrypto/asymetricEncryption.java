package com.example.javacrypto;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.crypto.*;

public class asymetricEncryption  {
     private SecretKey secretKey;

    public asymetricEncryption() throws Exception {
        this.secretKey = generaSecretKey();
    }

    private SecretKey generaSecretKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        return keyGen.generateKey();
    }

    public byte[] encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
        return cipher.doFinal(plainText.getBytes());
    }

    public byte[] encrypt(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
        return cipher.doFinal(data);
    }

    public String decrypt(byte[] cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, this.secretKey);
        byte[] decryptedBytes = cipher.doFinal(cipherText);
        return new String(decryptedBytes);
    }

    public void encryptFile(String filePath, String outputFilePath) throws Exception {
        byte[] fileContent = Files.readAllBytes(Paths.get(filePath));
        byte[] encryptedContent = encrypt(fileContent);
        Files.write(Paths.get(outputFilePath), encryptedContent);
    }

    // end class
}
