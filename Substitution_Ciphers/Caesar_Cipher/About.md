Caesar Cipher:

- Caesar Cipher makes use of the character set and codes.

- Based on the given key, the encryption and decryption happens as below:

    |   Encryption
    - Every plaintext character is replaced with another plaintext alphabet of the same form (i.e. upper or lower case).
    - This replacement is done based on the key and when we reach the last alphabet, we wrap around.
    - Examples:
    1. Plaintext 'A' Key 1. The ciphertext would be 'A' incremented once, which is 'B'.
    2. Plaintext 'Z' Key 1. The ciphertext would be 'Z' incremented once, but there are no capital alphabets after Z, so
        we wrap around and the ciphetext would be 'A'.
    - This is also done for all the ascii characters. Java uses around 256 ascii alphabets, so as soon as we reach the
        end of the ASCII list, we wrap around to ASCII character 1.

    |   Decryption
    - The wraparound and replacement is done as before but instead of incrementing we decrement to decrypt.
    - Examples:
    1. Ciphertext 'B' Key 1. The plaintext would be 'B', decremented once, which is 'A'.
    2. Ciphertext 'A' Key 1. The plaintext would be 'A' decremented once, but there are no capital alphabets before A, so
        we wrap around and the plaintext would be 'Z'.

- Key Selection
    - The reason we take a key in the range 1 to 25 is to make sure that we are in the range of the alphabets. The basic operation
    we undertake is (character position + key) mod 26. After all the key values between 1 and 25 have been used, the encryption
    is repeated so we make sure that we are not overcomputing and instead just use the key values between 1 and 25.
    - If higher key values are input, we trim it to a value between 1 and 25 based on key mod 26. 


Bugs:
- The code works fine for alphabets (a-z,A-Z) and spaces, but there are occasional issues with decryption and encryption
for different special characters. This happens when the key is such that after encryption the character falls in the range
'A-Z' or 'a-z' and hence is treated as an alphabet and is decrypted as such.

Issues with Caesar Cipher:
- With enough text a direct relation between the ciphertext and the plaintext can be found which makes it very easy to
decrypt caesar cipher.
- There are only 25 possible ways to encrypt using the caesar cipher so it is very easy to break using brute force
analysis.