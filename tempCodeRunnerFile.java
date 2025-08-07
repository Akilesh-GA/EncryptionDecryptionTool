// 5:30 - 07 Aug 2025
import java.util.*;

public interface CeaserCipher {
    public void ceaserCipherMethod() {
        System.out.println("Ceaser Cipher Encoding Technique");
        System.out.println("The Caesar Cipher is one of the simplest encryption algorithms that applies a uniform shift to each alphabetic character in the input string. It's useful for understanding basic principles of substitution ciphers, character manipulation, and modular arithmetic in text-based encryption.");
    }
}

public class EncryptionDecryptionTool {
    public static void main(String[] args) {
        System.out.println("Welcome to Encryption and Decryption Tool");
        Scanner scan = new Scanner(System.in);
        int option = 0;
        while(true) {
            System.out.println("Choose Encrypting / Decrypting Technique");
            System.out.println("1 -> Ceaser Cipher");
            System.out.println("2 -> Affine Cipher");
            System.out.println("3 -> Atbash Cipher");
            System.out.println("4 -> XOR Cipher");
            System.out.println("5 -> Transposition Cipher");
            System.out.println("-1 -> Quit application");
            System.out.println("Enter your option : ");
            option = scan.nextInt();
            if(option < 1 || option > 5) {
                System.out.println("Invalid Input Passed !");
                System.out.println("Enter option range (1 - 5) ");
            }
            else {
                switch (option) {
                    case 1:
                        CeaserCipher cc = new CeaserCipher();
                        cc.ceaserCipherMethod();
                        break;
                    case 2:

                        break;
                    case 3:
                        
                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    default:
                        break;
                }
            }
        }
    }
}
