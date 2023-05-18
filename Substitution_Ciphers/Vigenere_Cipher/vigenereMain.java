/*
 * Name: vigenereMain.java
 * Author: crayonthree / Abhiroop Yerramilli
 * Description: This class contains the functions to take user input, encrypt and decrypt the given text based on the
 *              input string and the key, using the vigenere cipher.
 */
package Substitution_Ciphers.Vigenere_Cipher;

import java.util.Scanner;

public class vigenereMain {

    /*
     * Name: main
     * Parameters: String[]
     * Return: void
     * Description: This main function is used to take string and the key from the user, and perform encryption and decryption using
     *              the vigenere cipher.
     */
    public static void main(String[] args){
        //Scanner for user input
        Scanner keyboardInput = new Scanner(System.in);

        //Getting the input for the string to be encrypted.
        System.out.println("Enter the string to be encrypted (special characters and spaces would be removed): ");
        String textToBeEncrypted = keyboardInput.nextLine();

        //Getting the key to use to encrypt.
        System.out.println("Enter the key to use to encrypt the string: ");
        String key = keyboardInput.nextLine();

        //New vigenere cipher object.
        vigenereCipher newCipher = new vigenereCipher(key);
        System.out.println("Entered String to encrypt is: " + textToBeEncrypted);

        //Encrypting and storing the input text
        String encryptedText = newCipher.vigenereEncryption(textToBeEncrypted);
        System.out.println("The encrypted text becomes: " + encryptedText);

        //Decrypting and storing the encrypted text
        String decryptedText = newCipher.vigenereDecryption(encryptedText);
        System.out.println("The decrypted text becomes: " + decryptedText);

        //Closing to avoid resource leaks.
        keyboardInput.close();
    }
    
}
