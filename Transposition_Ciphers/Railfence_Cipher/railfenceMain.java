/*
 * Name: railfenceMain.java
 * Author: crayonthree / Abhiroop Yerramilli
 * Description: This class contains the functions to take user input, encrypt and decrypt the given text based on the
 *              input string, using the railfence cipher.
 */
package Transposition_Ciphers.Railfence_Cipher;

import java.util.Scanner;

public class railfenceMain {

    /*
     * Name: main
     * Parameters: String[]
     * Return: void
     * Description: This main function is used to take string from the user, and perform encryption and decryption using
     *              the railfence cipher.
     */
    public static void main(String[] args){

        //Scanner for user input
        Scanner keyboardInput = new Scanner(System.in);

        //Getting the input for the string to be encrypted.
        System.out.println("Enter the string to be encrypted (no special characters; spaces allowed): ");
        String textToBeEncrypted = keyboardInput.nextLine();

        //New playfair cipher object.
        railfenceCipher newCipher = new railfenceCipher();
        System.out.println("Entered String to encrypt is: " + textToBeEncrypted);

        //Encrypting and storing the input text
        String encryptedText = newCipher.railfenceEncryption(textToBeEncrypted);
        System.out.println("The encrypted text becomes: " + encryptedText);

        //Decrypting and storing the encrypted text
        String decryptedText = newCipher.railfenceDecryption(encryptedText);
        System.out.println("The decrypted text becomes: " + decryptedText);



        //Closing to avoid resource leaks.
        keyboardInput.close();

    }
    
}
