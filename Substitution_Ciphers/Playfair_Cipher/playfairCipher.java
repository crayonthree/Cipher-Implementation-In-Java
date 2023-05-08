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
        key = stringTransform(key);
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
     * Parameters: String
     * Return: String
     * Description: This function takes in a string to be encrypted, and encrypts using the playfair cipher.
     */
    public String playfairEncryption(String textToBeEncrypted){

        String encryptedString = "";

        //Spaces, special characters removed. All alphabets are converted to capital alphabets.
        textToBeEncrypted = stringTransform(textToBeEncrypted);

        //We loop through all the characters of the string to be encrypted.
        for(int i=0;i<textToBeEncrypted.length();i++){

            //We encrypt one pair at a time.
            char[] currentPair = new char[2];

            //When are are not at the last character.
            if(i != textToBeEncrypted.length()){

                //We consider the current and the next character.
                char firstCharacter = textToBeEncrypted.charAt(i);
                char secondCharacter = textToBeEncrypted.charAt(i+1);

                //If both the characters are same we put a bogus character.
                if(firstCharacter == secondCharacter){

                    //If the character is X, then we put the bogus character as 'Z', else we put 'X'.
                    if(firstCharacter != 'X'){
                        currentPair[0] = firstCharacter;
                        currentPair[1] = 'X';
                    }else{
                        currentPair[0] = firstCharacter;
                        currentPair[1] = 'Z';
                    }

                }
                
                //If the characters are not same.
                else{

                    //We consider both characters, and increment i once more.
                    currentPair[0] = firstCharacter;
                    currentPair[1] = secondCharacter;
                    i = i+1;

                }

            }
            
            //If we are at the last character of the string to be encrypted.
            else{

                //We consider the last character and put a bogus character at the end.
                char firstCharacter = textToBeEncrypted.charAt(i);
                char secondCharacter;

                //If the character is not 'Z', we consider 'Z', else we consider 'X' as the bogus character.
                if(firstCharacter != 'Z'){
                    secondCharacter = 'Z';
                }else{
                    secondCharacter = 'X';
                }

                currentPair[0] = firstCharacter;
                currentPair[1] = secondCharacter;


            }

            //We encrypt the pair using the function encryptionTechniques, and add the encrypted pair to the string.
            char[] encryptedPair = encryptionDecryptionTechniques(currentPair,0);
            encryptedString = encryptedString + encryptedPair[0] + "" + encryptedPair[1];

        }

        //Returning the encrypted string.
        return encryptedString;
    }

    /*
     * Name: encryptionTechniques
     * Parameters: char[], int
     * Return: char[]
     * Description: This function takes in a character pair, encrypts/decrypts it using the key array, and returns the encrypted key array.
     *              Form is used to determing if we are encrypting or decrypting.
     */
    private char[] encryptionDecryptionTechniques(char[] currentPair, int form){

        char[] finalPair = new char[2];

        //Initializing rows and columns
        int rowFirstCharacter = 0;
        int rowSecondCharacter = 0;
        int columnFirstCharacter = 0;
        int columnSecondCharacter = 0;

        //Looping through the key matrix.
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){

                //If we find either character of the pair, we store the rows and columns.

                if(currentPair[0] == keyArray[i][j]){
                    rowFirstCharacter = i;
                    columnFirstCharacter = j;
                }

                if(currentPair[1] == keyArray[i][j]){
                    rowSecondCharacter = i;
                    columnSecondCharacter = j;
                }

            }
        }

        //First case if both the characters of the pair are in the same row.
        if(rowFirstCharacter == rowSecondCharacter){

            //Encryption
            if(form == 0){

                //Normal condition and wraparound condition
                if(columnFirstCharacter + 1 == 5){
                    finalPair[0] = keyArray[rowFirstCharacter][0];
                }else{
                    finalPair[0] = keyArray[rowFirstCharacter][columnFirstCharacter+1];
                }

                //Normal condition and wraparound condition
                if(columnSecondCharacter + 1 == 5){
                    finalPair[1] = keyArray[rowSecondCharacter][0];
                }else{
                    finalPair[1] = keyArray[rowSecondCharacter][columnSecondCharacter+1];
                }

            }
            //Decryption
            else{

                //Normal condition and wraparound condition
                if(columnFirstCharacter - 1 == -1){
                    finalPair[0] = keyArray[rowFirstCharacter][5];
                }else{
                    finalPair[0] = keyArray[rowFirstCharacter][columnFirstCharacter-1];
                }

                //Normal condition and wraparound condition
                if(columnSecondCharacter - 1 == -1){
                    finalPair[1] = keyArray[rowSecondCharacter][5];
                }else{
                    finalPair[1] = keyArray[rowSecondCharacter][columnSecondCharacter-1];
                }

            }

        }
        
        //Second case if both the characters of the pair are in the same column.
        else if(columnFirstCharacter == columnSecondCharacter){

            //Encryption
            if(form == 0){

                //Normal condition and wraparound condition
                if(rowFirstCharacter + 1 == 5){
                    finalPair[0] = keyArray[0][columnFirstCharacter];
                }else{
                    finalPair[0] = keyArray[rowFirstCharacter+1][columnFirstCharacter];
                }

                //Normal condition and wraparound condition
                if(rowSecondCharacter + 1 == 5){
                    finalPair[1] = keyArray[0][columnSecondCharacter];
                }else{
                    finalPair[1] = keyArray[rowSecondCharacter+1][columnSecondCharacter];
                }

            }
            //Decryption
            else{

                //Normal condition and wraparound condition
                if(rowFirstCharacter - 1 == -1){
                    finalPair[0] = keyArray[5][columnFirstCharacter];
                }else{
                    finalPair[0] = keyArray[rowFirstCharacter-1][columnFirstCharacter];
                }

                //Normal condition and wraparound condition
                if(rowSecondCharacter - 1 == -1){
                    finalPair[1] = keyArray[5][columnSecondCharacter];
                }else{
                    finalPair[1] = keyArray[rowSecondCharacter-1][columnSecondCharacter];
                }

            }

        }
        
        //Third case where we exchange the columns, but keep the rows of the characters.
        else{
            finalPair[0] = keyArray[rowSecondCharacter][columnFirstCharacter];
            finalPair[1] = keyArray[rowFirstCharacter][columnSecondCharacter];
        }

        return finalPair;

    }

    /*
     * Name: playfairEncryption
     * Parameters: String
     * Return: String
     * Description: This function takes in a string to be decrypted, and decrypts using the playfair cipher.
     */
    public String playfairDecryption(String textToBeDecrypted){
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
    private String stringTransform(String currentString){

        String finalString = "";
        
        //Removing spaces from the key.
        currentString = currentString.replaceAll("\\s", "");
        
        //Looping through the key, and copying all alphabets in order. Lowercase converted to uppercase, and uppercase used as is.
        for(int i=0;i<currentString.length();i++){
            if(currentString.charAt(i)>='a' && currentString.charAt(i)<='z'){
                finalString = finalString + (char)(currentString.charAt(i) - 32);
            }else if(currentString.charAt(i)>='A' && currentString.charAt(i)<='Z'){
                finalString = finalString + currentString.charAt(i);
            }
        }

        return finalString;

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
