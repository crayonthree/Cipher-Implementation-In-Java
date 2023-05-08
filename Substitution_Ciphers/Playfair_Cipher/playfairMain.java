/*
 * Name: playfairMain.java
 * Author: crayonthree / Abhiroop Yerramilli
 * Description: This class contains the functions to take user input, encrypt and decrypt the given text based on the
 *              input string, using the playfair cipher.
 */
package Substitution_Ciphers.Playfair_Cipher;

import java.util.Scanner;

public class playfairMain {

    /*
     * Name: main
     * Parameters: String[]
     * Return: void
     * Description: This main function is used to take string and the key from the user, and perform encryption and decryption using
     *              the playfair cipher.
     */
    public static void main(String[] args){

        //Scanner for user input
        Scanner keyboardInput = new Scanner(System.in);

        //Getting the input for the string to be encrypted.
        System.out.println("Enter the string to be encrypted (special characters and spaces would be removed): ");
        String textToBeEncrypted = keyboardInput.nextLine();

        //Getting the key to use to encrypt.
        System.out.println("Enter the key to use to encrypt the string.");
        String key = keyboardInput.nextLine();

        //New playfair cipher object.
        playfairCipher newCipher = new playfairCipher(key);

        //Encrypting and storing the input text
        String encryptedText = newCipher.playfairEncryption(textToBeEncrypted);

        //Decrypting and storing the encrypted text
        String decryptedText = newCipher.playfairDecryption(encryptedText);

        //Closing to avoid resource leaks.
        keyboardInput.close();

    }
    
}
