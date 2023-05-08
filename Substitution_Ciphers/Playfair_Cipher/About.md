Playfair Cipher:

- Playfair Cipher makes use of a 5x5 key matrix to encrypt a given string.

- Given a key string we first make a key matrix which can be used to encrypt and decrypt. It happens as below:

    |   Making the key matrix.
    - First a 5x5 key matrix is made. Then we take in a string from the user, and one by one we fill in the the
    alphabet from the string into the key matrix, if the key matrix does not contain that alphabet.
    - For ease we first convert all alphabets to capitals and remove all the remaining spaces and special
    characters.
    - Then after we are done putting the alphabets from the input key into the key matrix, we loop through all 
    the alphabets from A-Z and if the alphabet is not in the key matrix we add it to the key matrix.
    - We consider I and J to be the same for encryption and decryption purposes.

    |   Encryption
    - First we parse the input string to encrypt. We divide the string into pairs of 2. If there are odd number of
    characters, we add a Z at the end.
    - For each pair, if both elements of the pair are same for instance LL, we add a bogus alphabet to hide. Here it
    would become LX LZ. We added a Z to make it even.
    - We also remove spaces from the input string.
    - Lets consider the matrix below
    A  B  C  D   E
    F  G  H  I/J K
    L  M  N  O   P
    Q  R  S  T   U
    V  W  X  Y   Z
    - We use the below 3 techniques to encrypt a given alphabet.
    (a) For each pair, if both alphabets fall in the same column, we increment their rows by 1. If we reach the end
        we can wraparound.
    e.g. if the pair is AL. We increment the row by 1 so A becomes F and L becomes Q. FQ
    (b) For each pair, if both alphabets fall in the same row, we increment their columns by 1. If we reach the end
        we can wraparound.
    e.g. if the pair is AC. We increment the column by 1 so A becomes B and C becomes D. BD
    (c) For each pair, if the above cases dont work, we consider a square and switch the corners on the same row.
    e.g. if the pair is AH. The square becomes ACHF. We switch the corners from A to C, and H to F. CF
    - Then after encrypting every pair, we combine the pairs to form a single string again.
    
    |   Decryption
    - We do the same as above, break the string into pairs of 2. Then consider the below matrix.
    A  B  C  D   E
    F  G  H  I/J K
    L  M  N  O   P
    Q  R  S  T   U
    V  W  X  Y   Z
    - We use the below 3 techniques to encrypt a given alphabet.
    (a) For each pair, if both alphabets fall in the same column, we decrement their rows by 1. If we reach the end
        we can wraparound.
    e.g. if the pair is FQ. We decrement the row by 1 so F becomes A and Q becomes L. AL
    (b) For each pair, if both alphabets fall in the same row, we decrement their columns by 1. If we reach the end
        we can wraparound.
    e.g. if the pair is BD. We decrement the column by 1 so B becomes A and D becomes C. AC
    (c) For each pair, if the above cases dont work, we consider a square and switch the corners on the same row.
    e.g. if the pair is AH. The square becomes ACHF. We switch the corners from A to C, and H to F. CF
    - Then after encrypting every pair, we combine the pairs to form a single string again.
     

Bugs:

Issues with Playfair Cipher:
- It is only possible to encrypt alphabets with the Playfair Cipher.
- With enough text a direct relation between the ciphertext and the plaintext can be found which makes it very easy to
decrypt the playfair cipher.