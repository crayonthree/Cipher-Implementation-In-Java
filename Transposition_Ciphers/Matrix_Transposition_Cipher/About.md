Matrix Transposition Cipher:

- Matrix Transposition Cipher is an extension of the railfence cipher.

- Instead of having just 2 rows, we have multiple rows, and we do not choose columns one after another
and instead we choose specific columns based on the key. For instance instead of 1,2,3,4,5 we can select
3 4 1 5 2.

- The encryption and decryption are as below:

    |   Encryption
    - We write the input string row wise, and fill the empty spaces with %.
    - % is also used to replace spaces.
    - Then we use the key, which is an array of column numbers, and we read the columns in order of the key.
    - This gives us the ciphertext.
    
    |   Decryption
    - To get the plaintext, we first figure out how many rows are required.
    - Then create a 2-D array, and read the columns in order from the ciphertext, using the key.
    - After we read all the columns. Then we read the whole array row-wise to get the plaintext.


Bugs:

Issues with Matrix Transposition Cipher:
- Both sides need to have the same key to encrypt and decrypt, easy to steal.
- Can be bruteforced under certain conditions.