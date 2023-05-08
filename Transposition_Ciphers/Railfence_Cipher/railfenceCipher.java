/*
 * Name: railfenceCipher.java
 * Author: crayonthree / Abhiroop Yerramilli
 * Description: This class contains the functions to encrypt and decrypt a given string using the railfence Cipher.
 */
package Transposition_Ciphers.Railfence_Cipher;

public class railfenceCipher {

    /*
     * Name: railfenceEncryption
     * Parameters: String
     * Return: String
     * Description: This function takes in a string, and encrypts it using railfence cipher.
     */
    public String railfenceEncryption(String textToBeEncrypted){

        //Replacing all spaces with '%'
        textToBeEncrypted = textToBeEncrypted.replaceAll(" ", "%");

        //Adding a % at the end, if there are odd number of characters.
        if(textToBeEncrypted.length() % 2 != 0){
            textToBeEncrypted = textToBeEncrypted + "%";
        }

        //Strings to store the first and second row.
        String firstRow = "";
        String secondRow = "";

        //Looping through the string, and storing the first and second rows.
        for(int i=0;i<textToBeEncrypted.length();i+=2){
            firstRow = firstRow + textToBeEncrypted.charAt(i);
            secondRow = secondRow + textToBeEncrypted.charAt(i+1);
        }

        //Returning the ciphertext
        return firstRow + secondRow;    

    }

    /*
     * Name: railfenceDecryption
     * Parameters: String
     * Return: String
     * Description: This function takes in a string, and decrypts it using railfence cipher.
     */
    public String railfenceDecryption(String textToBeDecrypted){

        //Splitting the ciphertext into the 2 rows
        String firstRow = textToBeDecrypted.substring(0, textToBeDecrypted.length()/2);
        String secondRow = textToBeDecrypted.substring(textToBeDecrypted.length()/2);

        String decryptedString = "";

        //Looping through the rows and reading one column at a time.
        for(int i=0;i<firstRow.length();i++){
            decryptedString = decryptedString + firstRow.charAt(i) + secondRow.charAt(i);
        }

        //Returning the decrypted text.
        return decryptedString;

    }
    
}
