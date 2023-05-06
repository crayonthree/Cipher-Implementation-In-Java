/*
 * Name: playfairCipher.java
 * Author: crayonthree / Abhiroop Yerramilli
 * Description: This class contains the functions to encrypt and decrypt a given string based on the entered key, using playfair cipher.
 */
package Substitution_Ciphers.Playfair_Cipher;

public class playfairCipher {

    //2-D array to store the key.
    private char[][] keyArray = new char[5][5];

    public playfairCipher(String key){

        //Transforming the key
        key = keyTransform(key);
        System.out.println(key);

        //Initializing the 2-D array.
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                keyArray[i][j] = 'a';
            }
        }

        //Count is used to keep track of how many elements of the keyArray are filled.
        int count = 0;
        //Row is used to keep track of rows.
        int row = 0;

        //Looping through the key, checking if the character is in the 2-D key array.
        for(int i=0;i<key.length();i++){
            char currentCharacter = key.charAt(i);

            //If the character is not in the key array, we add it to the array.
            if(!contains(keyArray, currentCharacter)){

                //If all elements of the row are full, we increment the row.
                if(count==5){
                    count = 0;
                    row++;
                }

                keyArray[row][count] = currentCharacter;
                count++;

            }

        }

        //We loop through all the alphabets to build our key matrix.
        for(int i='A';i<='Z';i++){
            char currentCharacter = (char)i;

            //If the character is not in the key array, we add it to the array.
            if(!contains(keyArray, currentCharacter)){

                //If all elements of the row are full, we increment the row.
                if(count==5){
                    count = 0;
                    row++;
                }

                keyArray[row][count] = currentCharacter;
                count++;

            }
        }

    }

    /*
     * Name: playfairEncryption
     * Parameters: String, String
     * Return: String
     * Description: This function takes in a string to be encrypted, and uses a string key to perform encryption using the playfair cipher.
     */
    public String playfairEncryption(String textToBeEncrypted){
        return null;
    }

    /*
     * Name: contains
     * Parameters: char[][], char
     * Return: boolean
     * Description: This function takes in a 2-D array of characters, and checks if a given character is in that character array. If it is, then
     *              true is returned, else false is returned.
     */
    private boolean contains(char[][] key, char currentCharacter){

        //Looping through the array and checking with each character.
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){

                //This if condition accounts for the special case where we consider I and J to be the same entity when building the matrix.
                if((key[i][j] == 'I' && currentCharacter == 'J') ||
                    (key[i][j] == 'J' && currentCharacter == 'I') ||
                    (key[i][j] == currentCharacter)){
                    return true;
                }

            }
        }

        return false;

    }

    /*
     * Name: keyTransform
     * Parameters: String
     * Return: String
     * Description: This function removes specific elements and transforms the key, to make it usable to make the playfair key.
     */
    private String keyTransform(String key){

        String finalKey = "";
        
        //Removing spaces from the key.
        key = key.replaceAll("\\s", "");
        
        //Looping through the key, and copying all alphabets in order. Lowercase converted to uppercase, and uppercase used as is.
        for(int i=0;i<key.length();i++){
            if(key.charAt(i)>='a' && key.charAt(i)<='z'){
                finalKey = finalKey + (char)(key.charAt(i) - 32);
            }else if(key.charAt(i)>='A' && key.charAt(i)<='Z'){
                finalKey = finalKey + key.charAt(i);
            }
        }

        return finalKey;

    }

    public void printKey(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(keyArray[i][j]);
            }
            System.out.println();
        }
    }
    
}
