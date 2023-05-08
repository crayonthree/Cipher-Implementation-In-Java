Railfence Cipher:

- A simple transposition cipher based on a "fence".

- There are no keys. The encryption and decryption is done as below:

    |   Encryption
    - Plaintext is written in 2 rows. Filling each column first.
    - % is used to denote spaces, and empty spaces are filled with %.
    - First we read row 1, then we read row 2 to produce the cipher text.

    |   Decryption
    - To obtain the plaintext, we first write the ciphertext row wise.
    - Then we read the cipher text column wise to get the plaintext.
    - Then we convert % to spaces and get the original plaintext.

Bugs:

Issues with Railfence Cipher:
- Very easy to crack.
- No keys, so decryption algorithm is known to everyone, and everyone can decrypt it.