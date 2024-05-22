package com.example.javacrypto;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@SpringBootApplication
public class JavacryptoApplication {

	public static void main(String[] args) throws Exception {
		asymetricEncryption asymetricEncryption = new asymetricEncryption();

        String plainText = "Hello SECRET TEXT";

        byte[] ecryptedText = asymetricEncryption.encrypt(plainText);
        System.out.println("La clef est : " + Base64.getEncoder().encodeToString(ecryptedText));

        String inputFilePath = "src/main/resources/static/MonMessageSecret.txt";
        String outputFilePath = "src/main/resources/static/MonMessageSecretEncrypted.txt";

        asymetricEncryption.encryptFile(inputFilePath, outputFilePath);
        System.out.println("Le fichier chiffrer est :" + outputFilePath);
        
        byte[] encryptedFileContent = Files.readAllBytes(Paths.get(outputFilePath));
        System.out.println("Contenu chiffré du fichier : " + Base64.getEncoder().encodeToString(encryptedFileContent));
	}
}
