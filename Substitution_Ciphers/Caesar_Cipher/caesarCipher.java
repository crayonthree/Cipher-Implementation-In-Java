/*
 * Name: caesarCipher.java
 * Author: crayonthree / Abhiroop Yerramilli
 * Description: This class contains the functions to encrypt and decrypt a given string based on the entered key, using caesar cipher.
 */
package Substitution_Ciphers.Caesar_Cipher;

class caesarCipher{

    /*
     * Name: caesarEncryption
     * Parameters: String, int
     * Return: String
     * Description: This function takes in a string to be encrypted, and uses an integer key to perform encryption using the caesar cipher.
     */
    public String caesarEncryption(String textToBeEncrypted, int key){

        //Character array of the text to be encrypted.
        char[] currentString = textToBeEncrypted.toCharArray();

        //String containing the encrypted characters.
        String encryptedString = "";

        //Looping through all characters
        for(int i=0;i<currentString.length;i++){

            //Integer to store the plaintext character. We use an integer to make calculations simpler.
            int plaintextCharacter;

            //The ciphertext character.
            char cipherCharacter;

            //If the cipher character is a lowercase alphabet
            if(currentString[i]<='z' && currentString[i]>='a'){

                //We subtract 'a' to get the ciphertext between 0 and 25. This can directly corelate to alphabets from
                //'a' to 'z' to an integer between 0 and 25.
                plaintextCharacter = (int)currentString[i] - 'a';

                //Calculating the intermediate and encrypting using the intermediate
                int intermediate = intermediateCalculation(plaintextCharacter+key, 25);
                cipherCharacter = (char)((intermediate % 26) + 'a');

            }
            
            //If the cipher character is an uppercase alphabet
            else if(currentString[i]<='Z' && currentString[i]>='A'){

                //We subtract 'A' to get the ciphertext between 0 and 25. This can directly corelate to alphabets from
                //'A' to 'Z' to an integer between 0 and 25.
                plaintextCharacter = (int)currentString[i] - 'A';

                //Calculating the intermediate and encrypting using the intermediate
                int intermediate = intermediateCalculation(plaintextCharacter+key, 25);
                cipherCharacter = (char)((intermediate % 26) + 'A');

            }
            
            //If the character is not an alphabet.
            else{

                plaintextCharacter = (int)currentString[i];

                //Calculating the intermediate and encrypting using the intermediate
                int intermediate = intermediateCalculation(plaintextCharacter+key, 255);
                cipherCharacter = (char)(intermediate);

            }

            encryptedString = encryptedString + cipherCharacter;

        }

        return encryptedString;

    }

    /*
     * Name: caesarDecryption
     * Parameters: String, int
     * Return: String
     * Description: This function takes in a string to be decrypted, and uses an integer key to perform deceryption using the caesar cipher.
     */
    public String caesarDecryption(String textToBeDecrypted, int key){

        //Character array of the text to be decrypted.
        char[] currentString = textToBeDecrypted.toCharArray();

        //String containing the decrypted characters.
        String decryptedString = "";

        //Looping through all characters
        for(int i=0;i<currentString.length;i++){

            //Integer to store the ciphertext character. We use an integer to make calculations simpler.
            int cipherCharacter;

            //The plaintext character
            char plaintextCharacter;

            //If the cipher character is a lowercase alphabet
            if(currentString[i]<='z' && currentString[i]>='a'){

                //We subtract 'a' to get the ciphertext between 0 and 25. This can directly corelate to alphabets from
                //'a' to 'z' to an integer between 0 and 25.
                cipherCharacter = (int)currentString[i] - 'a';

                //Calculating the intermediate and decrypting using the intermediate
                int intermediate = intermediateCalculation(cipherCharacter-key, 25);
                plaintextCharacter = (char)((intermediate % 26) + 'a');

            }
            
            //If the cipher character is an uppercase alphabet
            else if(currentString[i]<='Z' && currentString[i]>='A'){

                //We subtract 'A' to get the ciphertext between 0 and 25. This can directly corelate to alphabets from
                //'A' to 'Z' to an integer between 0 and 25.
                cipherCharacter = (int)currentString[i] - 'A';

                //Calculating the intermediate and decrypting using the intermediate
                int intermediate = intermediateCalculation(cipherCharacter-key, 25);
                plaintextCharacter = (char)((intermediate % 26) + 'A');

            }
            
            //If the character is not an alphabet.
            else{

                cipherCharacter = (int)currentString[i];

                //Calculating the intermediate and decrypting using the intermediate
                int intermediate = intermediateCalculation(cipherCharacter-key, 255);
                plaintextCharacter = (char)(intermediate);

            }

            decryptedString = decryptedString + plaintextCharacter;


        }

        return decryptedString;

    }

    /*
     * Name: intermediateCalculation
     * Parameters: int, int
     * Return: int
     * Description: This function takes in an intermediate integer, and the limit. If the intermediate is more than the limit, we subtract limit
     *              from the intermediate. Else if the intermediate is less than 0, we add the lmit to the intermediate.
     */
    public int intermediateCalculation(int intermediate, int limit){

        if(intermediate>limit){
            intermediate = intermediate - 26;
        }else if(intermediate<0){
            intermediate = intermediate + 26;
        }

        return intermediate;
    }


}