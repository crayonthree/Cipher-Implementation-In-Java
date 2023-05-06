/*
 * Name: caesarMain.java
 * Author: crayonthree / Abhiroop Yerramilli
 * Description: This class contains the functions to take user input, encrypt and decrypt the given text based on the
 *              input string and key, using the caesar cipher.
 */
package Substitution_Ciphers.Caesar_Cipher;

import java.util.Scanner;

public class caesarMain {

    /*
     * Name: main
     * Parameters: String[]
     * Return: void
     * Description: This main function is used to take string and the key from the user, and perform encryption and decryption using
     *              the caesar cipher.
     */
    public static void main(String[] args){

        //New caesar cipher object.
        caesarCipher newCipher = new caesarCipher();

        //Scanner for user input
        Scanner keyboardInput = new Scanner(System.in);

        //Getting the input for the string to be encrypted.
        System.out.println("Enter the string to be encrypted in capital alphabets: ");
        String textToBeEncrypted = keyboardInput.nextLine();
        
        //Getting the key.
        boolean keyApproval = false;
        System.out.print("Enter a key between 1 and 25: ");
        int key = keyboardInput.nextInt();
        while(!keyApproval){

            //If the entered key mod 26 = 0, the text would not be encrypted, so we ask the user for another key.
            if(key % 26 == 0){
                System.out.print("Entered key wont encrypt the data. Please enter a key again:");
                key = keyboardInput.nextInt();
            }else{
                //If the key>25, we take key mod 26 as the key, as after values between 1 to 25, the key actions repeat.
                if(key > 25){
                    key = key % 26;
                    keyApproval = true;
                }
                //If the entered key is negative, we ask the user to enter another key.
                else if(key<0){
                    System.out.print("Negative Key entered. Please enter a key again:");
                    key = keyboardInput.nextInt();
                }else{
                    keyApproval=true;
                }
            }
        }

        //First we encrypt the text, then decrypt the encrypted text.
        System.out.println("Done! Now we first encrypt the text using Caesar Cipher!");
        System.out.println("The original text was: "+ textToBeEncrypted);

        String encryptedString = newCipher.caesarEncryption(textToBeEncrypted, key);
        System.out.println("After encryption the text becomes: " + encryptedString);

        String decryptedString = newCipher.caesarDecryption(encryptedString, key);
        System.out.println("After decryption the text becomes: " + decryptedString);

        System.out.println("DONE!");      

        //Closing to avoid resource leaks.
        keyboardInput.close();

    }
}
