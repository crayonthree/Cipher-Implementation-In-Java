/*
 * Name: vigenereCipher.java
 * Author: crayonthree / Abhiroop Yerramilli
 * Description: This class contains the functions to encrypt and decrypt a given string based on the entered key, using the vigenere cipher.
 */
package Substitution_Ciphers.Vigenere_Cipher;

public class vigenereCipher {
    
    //The keys to encryption and decryption.
    private char[][] vigenereMatrix;
    private String vigenereKey;

    /*
     * Name: vigenereCipher
     * Parameters: None
     * Return: None
     * Description: This constructor makes a 26x26 array for performing vigenere cipher.
     */
    public vigenereCipher(String key){

        //Initializing the key
        vigenereMatrix = new char[26][26];

        //Making the matrix. 0 is considered as A, 25 as Z.
        char startingCharacter = 0;
        for(int i=0;i<26;i++){

            int column = 0;
            for(int j=startingCharacter;j<startingCharacter+26;j++){
                
                //Filling the matrix
                if(j>=26){
                    //Looping back
                    vigenereMatrix[i][column] = (char)(65 + (j-26));
                }else{
                    vigenereMatrix[i][column] = (char)(65 + j);
                }
                column++;
            }
            startingCharacter++;
        }

        //Setting the initial key
        vigenereKey = key;
    }

    /*
     * Name: vigenereEncryption
     * Parameters: String, String
     * Return: String
     * Description: This function takes in a string to be encrypted and key to use, and encrypts it using the vigenere cipher.
     */
    public String vigenereEncryption(String textToBeEncrypted){
        return null;
    }

    /*
     * Name: vigenereDecryption
     * Parameters: String, String
     * Return: String
     * Description: This function takes in a string to be decrypted and key to use, and decrypts it using the vigenere cipher.
     */
    public String vigenereDecryption(String textToBeEncrypted){
        return null;
    }

    public void printKey(){
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                System.out.print(vigenereMatrix[i][j]);
            }
            System.out.println();
        }
    }

}
