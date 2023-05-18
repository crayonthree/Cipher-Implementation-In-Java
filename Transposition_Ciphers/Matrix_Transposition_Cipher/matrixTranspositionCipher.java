/*
 * Name: matrixTranspositionCipher.java
 * Author: crayonthree / Abhiroop Yerramilli
 * Description: This class contains the functions to encrypt and decrypt a given string based on the entered key, using matrix transposition cipher.
 */
package Transposition_Ciphers.Matrix_Transposition_Cipher;

public class matrixTranspositionCipher {

    //The key to encryption and decryption.
    private int[] columnKey;

    /*
     * Name: matrixTranspositionCipher
     * Parameters: String
     * Return: None
     * Description: This constructor takes in a key, and makes the key array.
     */
    public matrixTranspositionCipher(String key){

        //Replacing spaces from the key.
        key = key.replaceAll(" ", "");

        //Initializing the column key, using the ASCII table.
        columnKey = new int[key.length()];
        for(int i=0;i<key.length();i++){
            columnKey[i] = (int)key.charAt(i) - 49;
        }
    }

    /*
     * Name: matrixTranspositionEncryption
     * Parameters: String
     * Return: String
     * Description: This function takes in a string to be encrypted, and encrypts it using the matrix transposition cipher.
     */
    public String matrixTranspositionEncryption(String textToBeEncrypted){
        
        //Parsing the input string.
        textToBeEncrypted = textToBeEncrypted.replaceAll(" ", "%");

        //Initializing ints to store variables for the matrix.
        int numberOfColumns = columnKey.length;
        int numberOfCharacters = textToBeEncrypted.length();
        int numberOfRows = (numberOfCharacters/numberOfColumns) + 1;

        //Making the matrix
        char[][] currentPlaintextMatrix = new char[numberOfRows][numberOfColumns];

        int currentCharacterIndex = 0;
        for(int i=0;i<numberOfRows;i++){
            for(int j=0;j<numberOfColumns;j++){

                //While there are elements in the string, use those characters, else use '%'
                if(currentCharacterIndex<numberOfCharacters){

                    currentPlaintextMatrix[i][j] = textToBeEncrypted.charAt(currentCharacterIndex);
                    currentCharacterIndex++;

                }else{

                    currentPlaintextMatrix[i][j] = '%';

                }

            }
        }

        //Applying the key for encryption
        String cipherText = "";
        for(int j=0;j<columnKey.length;j++){

            String currentColumn = "";
            for(int i=0;i<numberOfRows;i++){

                currentColumn = currentColumn + currentPlaintextMatrix[i][columnKey[j]];

            }

            //Reading the columns in order of the columns and adding them.
            cipherText = cipherText + currentColumn;
        }

        //Returning the cipherText
        return cipherText;
    }

    /*
     * Name: matrixTranspositionEncryption
     * Parameters: String
     * Return: String
     * Description: This function takes in a string to be decrypted, and decrypts using the matrix transposition cipher.
     */
    public String matrixTranspositionDecryption(String textToBeDecrypted){
        
        //Initializing ints to store variables for the matrix.
        int numberOfColumns = columnKey.length;
        int numberOfCharacters = textToBeDecrypted.length();
        int numberOfRows = (numberOfCharacters/numberOfColumns);

        //Making the matrix
        char[][] currentMatrix = new char[numberOfRows][numberOfColumns];

        //Applying the key for decryption, and remaking the matrix
        int currentCharacterIndex = 0;
        for(int j=0;j<columnKey.length;j++){
            for(int i=0;i<numberOfRows;i++){

                //Reading the string to be decrypted.
                currentMatrix[i][columnKey[j]] = textToBeDecrypted.charAt(currentCharacterIndex);
                currentCharacterIndex++;

            }
        }

        //Reading the matrix one row at a time.
        String plainText = "";
        for(int i=0;i<numberOfRows;i++){

            String currentRow = "";
            for(int j=0;j<numberOfColumns;j++){
                
                currentRow = currentRow + currentMatrix[i][j];

            }

            //Reading the rows and adding them to the final plaintext string.
            plainText = plainText + currentRow;
        }

        //Returning the plainText
        return plainText;
    }
    
}
