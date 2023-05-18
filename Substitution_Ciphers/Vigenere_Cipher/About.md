Vigenere Cipher:

- We make use of a Vigenere table which can be used to encrypt and decrypt the given text.

- The encryption and decryption are as below:

    |   Encryption
    - We use a vignere table for encryption.
ABCDEFGHIJKLMNOPQRSTUVWXYZ
BCDEFGHIJKLMNOPQRSTUVWXYZA
CDEFGHIJKLMNOPQRSTUVWXYZAB
DEFGHIJKLMNOPQRSTUVWXYZABC
EFGHIJKLMNOPQRSTUVWXYZABCD
FGHIJKLMNOPQRSTUVWXYZABCDE
GHIJKLMNOPQRSTUVWXYZABCDEF
HIJKLMNOPQRSTUVWXYZABCDEFG
IJKLMNOPQRSTUVWXYZABCDEFGH
JKLMNOPQRSTUVWXYZABCDEFGHI
KLMNOPQRSTUVWXYZABCDEFGHIJ
LMNOPQRSTUVWXYZABCDEFGHIJK
MNOPQRSTUVWXYZABCDEFGHIJKL
NOPQRSTUVWXYZABCDEFGHIJKLM
OPQRSTUVWXYZABCDEFGHIJKLMN
PQRSTUVWXYZABCDEFGHIJKLMNO
QRSTUVWXYZABCDEFGHIJKLMNOP
RSTUVWXYZABCDEFGHIJKLMNOPQ
STUVWXYZABCDEFGHIJKLMNOPQR
TUVWXYZABCDEFGHIJKLMNOPQRS
UVWXYZABCDEFGHIJKLMNOPQRST
VWXYZABCDEFGHIJKLMNOPQRSTU
WXYZABCDEFGHIJKLMNOPQRSTUV
XYZABCDEFGHIJKLMNOPQRSTUVW
YZABCDEFGHIJKLMNOPQRSTUVWX
ZABCDEFGHIJKLMNOPQRSTUVWXY
    - There are 26 rows and 26 columns. Starting from index 0 to index 25.
    - Then we take the first character of the plaintext and the first character of the key.
    - A is given number 0, and Z is given number 25.
    - Lets say we have A and B respectively. We take A(0) as the column, B(1) as the row.
    - Then we find the entry with row 0, column 1, and that is the ciphertext. Here it would be B

    |   Decryption
    - Using the same rules as above, lets take ciphertext B(1) and key character A(0).
    - We take row 0, and find B in row 0. We find the column. Here row 0, column 1 gives us B.
    - Column 1 means B, which means the plaintext would be B.

Another example:
Plaintext:  HELLOWORLD
Key:        SECRETSECR
Ciphertext: ZINCSPFVNU

Issues with Vigenere Cipher:
- Very easy to break considering everyone can make the vigenere table, and encrypt-decrypt in real time.
- Can only be used to encrypt alphabets.