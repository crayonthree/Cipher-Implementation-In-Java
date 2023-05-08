package Transposition_Ciphers.Matrix_Transposition_Cipher;

public class matrixTranspositionCipher {

    //The key to encryption and decryption.
    private int[] columnKey;

    /*
     * Name: matrixTranspositionCipher
     * Parameters: String
     * Return: String
     * Description: This constructor takes in a key, and makes the key array.
     */
    public matrixTranspositionCipher(String key){
        key = key.replaceAll(" ", "");

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
        return null;
    }

    /*
     * Name: matrixTranspositionEncryption
     * Parameters: String
     * Return: String
     * Description: This function takes in a string to be decrypted, and decrypts using the matrix transposition cipher.
     */
    public String matrixTranspositionDecryption(String textToBeDecrypted){
        return null;
    }
    
}
