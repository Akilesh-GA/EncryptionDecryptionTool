import java.util.*;

interface CeaserCipher {
    default void ceaserCipherMethod() {
        System.out.println();
        System.out.println("Ceaser Cipher Encoding Technique");
        System.out.println();
        System.out.println("The Caesar Cipher is one of the simplest encryption algorithms that applies a uniform shift to each alphabetic character in the input string.\nIt's useful for understanding basic principles of substitution ciphers, character manipulation, and modular arithmetic in text-based encryption.");
        System.out.println();
    }
}

class CeaserCipherImpl implements CeaserCipher {
    // No additional methods needed
}

interface AffineCipher {
    default void affineCipherMethod() {
        System.out.println();
        System.out.println("Affine Cipher Encoding Technique");
        System.out.println();
        System.out.println("The Affine Cipher is a classical substitution cipher that uses mathematical functions to encrypt and decrypt messages.\nThis technique introduces a more complex level of encryption by combining multiplication and addition operations, making it slightly stronger than simple Caesar shifts.");
        System.out.println();
    }
}

class AffineCipherImpl implements AffineCipher {
    // No additional methods needed
}

interface AtbashCipher {
    default void atbashCipherMethod() {
        System.out.println();
        System.out.println("Atbash Cipher Encoding Technique");
        System.out.println();
        System.out.println("The Atbash Cipher is a classical substitution cipher where each letter in the alphabet is reversed.\nIt does not use any keys, making it one of the simplest ciphers to implement and understand and Ideal for beginners in cryptography.");
        System.out.println();
    }
}

class AtbashCipherImpl implements AtbashCipher {
    // No additional methods needed
}


interface XORCipher {
    default void XORCipherMethod() {
        System.out.println();
        System.out.println("XOR Cipher Encoding Technique");
        System.out.println();
        System.out.println("The XOR Cipher is a symmetric encryption technique that applies the XOR (exclusive OR) operation between the plaintext and a key.\nThis makes it a lightweight encryption method commonly used in low-level security systems or embedded devices.");
        System.out.println();
    }
}

class XORCipherImpl implements XORCipher {
    // No additional methods needed
}

interface TranspositionCipher {
    default void transpositionCipherMethod() {
        System.out.println();
        System.out.println("Transposition Cipher Encoding Technique");
        System.out.println();
        System.out.println("The Transposition Cipher does not alter the characters but rearranges their order based on a fixed system or pattern.\nOften used in puzzle encryption, or in combination with substitution ciphers for stronger results.");
        System.out.println();
    }
}

class TranspositionCipherImpl implements TranspositionCipher {
    // No additional methods needed
}

public class EncryptionDecryptionTool {
    public static void main(String[] args) {
        System.out.println("Welcome to Encryption and Decryption Tool");
        int option = 0;
        do {
            Scanner scan = new Scanner(System.in);

            System.out.println("Choose Encrypting / Decrypting Technique");
            System.out.println("1 -> Ceaser Cipher");
            System.out.println("2 -> Affine Cipher");
            System.out.println("3 -> Atbash Cipher");
            System.out.println("4 -> XOR Cipher");
            System.out.println("5 -> Transposition Cipher");
            System.out.println("-1 -> Quit application");

            System.out.print("Enter your option : ");
            option = scan.nextInt();

            if(option < 1 || option > 5) {
                System.out.println("Invalid Input Passed !");
                System.out.println("Enter option range (1 - 5) ");
            }
            if(option == -1) {
                break;
            }
            else {
                switch (option) {
                    case 1:
                        CeaserCipherImpl cc = new CeaserCipherImpl();
                        cc.ceaserCipherMethod();
                        break;
                    case 2:
                        AffineCipherImpl ac = new AffineCipherImpl();
                        ac.affineCipherMethod();
                        break;
                    case 3:
                        AtbashCipherImpl at = new AtbashCipherImpl();
                        at.atbashCipherMethod();
                        break;
                    case 4:
                        XORCipherImpl xor = new XORCipherImpl();
                        xor.XORCipherMethod(); 
                        break;
                    case 5:
                        TranspositionCipherImpl tc = new TranspositionCipherImpl();
                        tc.transpositionCipherMethod();
                        break;
                    default:
                        break;
                }
            }
        } while(option != -1);
        System.out.println("Thank You");
    }
}
