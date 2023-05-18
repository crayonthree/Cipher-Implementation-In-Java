/*
 * Name: vigenereCipher.java
 * Author: crayonthree / Abhiroop Yerramilli
 * Description: This class contains the functions to encrypt and decrypt a given string based on the entered key, using the vigenere cipher.
 */
package Substitution_Ciphers.Vigenere_Cipher;

public class vigenereCipher {
    
    //The keys to encryption and decryption.
    private char[][] vigenereMatrix;
    private String vigenereKey = "";

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

        //Parsing the key to only consider the capital alphabets.
        for(int i=0;i<key.length();i++){

            char currentCharacter = key.charAt(i);
            if(currentCharacter>='A' && currentCharacter<='Z'){
                vigenereKey = vigenereKey + currentCharacter;
            }else if(currentCharacter>='a' && currentCharacter<='z'){
                vigenereKey = vigenereKey + (char)(currentCharacter-32);
            } 
        }
    }

    /*
     * Name: vigenereEncryption
     * Parameters: String, String
     * Return: String
     * Description: This function takes in a string to be encrypted and key to use, and encrypts it using the vigenere cipher.
     */
    public String vigenereEncryption(String textToBeEncrypted){

        //Parsing the string to only consider the capital alphabets.
        String parsedTextToBeEncrypted = "";
        for(int i=0;i<textToBeEncrypted.length();i++){

            char currentCharacter = textToBeEncrypted.charAt(i);
            if(currentCharacter>='A' && currentCharacter<='Z'){
                parsedTextToBeEncrypted = parsedTextToBeEncrypted + currentCharacter;
            }else if(currentCharacter>='a' && currentCharacter<='z'){
                parsedTextToBeEncrypted = parsedTextToBeEncrypted + (char)(currentCharacter-32);
            }  

        }

        //Encrypting the parsed string
        String encryptedString  = "";
        int currentKeyIndex = 0;
        for(int i=0;i<parsedTextToBeEncrypted.length();i++){

            char currentCharacter = parsedTextToBeEncrypted.charAt(i);
            char encryptedCharacter = vigenereMatrix[(int)vigenereKey.charAt(currentKeyIndex) - 65][(int)currentCharacter-65];
            encryptedString = encryptedString + encryptedCharacter;
            currentKeyIndex++;
            
            //Looping through the key
            if(currentKeyIndex>=vigenereKey.length()){
                currentKeyIndex = 0;
            }
        }

        //Returning the encrypted string.
        return encryptedString;
    }

    /*
     * Name: vigenereDecryption
     * Parameters: String, String
     * Return: String
     * Description: This function takes in a string to be decrypted and key to use, and decrypts it using the vigenere cipher.
     */
    public String vigenereDecryption(String textToBeEncrypted){

        //Decrypting the parsed string
        String decryptedString  = "";
        int currentKeyIndex = 0;
        for(int i=0;i<textToBeEncrypted.length();i++){

            //Getting the current row and character.
            int currentRow = (int)vigenereKey.charAt(currentKeyIndex)- 65;
            char currentCharacter = textToBeEncrypted.charAt(i);
            char encryptedCharacter = ' ';

            //Looking through the row to find the character, looking up the index, and getting the encrypted character based on the index.
            for(int j=0;j<26;j++){
                if(currentCharacter == vigenereMatrix[currentRow][j]){
                    encryptedCharacter = (char)(j + 65);
                }
            }
            decryptedString = decryptedString + encryptedCharacter;
            currentKeyIndex++;
            
            //Looping through the key
            if(currentKeyIndex>=vigenereKey.length()){
                currentKeyIndex = 0;
            }
        }

        //Returning the decrypted string.
        return decryptedString;
    }

}
