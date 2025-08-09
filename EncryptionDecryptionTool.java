import java.util.*;

interface CeaserCipher {
    public void ceaserCipherMethod();
    public void getText(String text,int key);
    public String encryptText();
    public String decryptText();
}

class CeaserCipherImpl implements CeaserCipher {
    String text;
    int key;
    String res;
    public void ceaserCipherMethod() {
        System.out.println("\n======================================");
        System.out.println("         Caesar Cipher Method");
        System.out.println("======================================\n");
        
        System.out.println("The Caesar Cipher is one of the encryption algorithm and ancient cryptography method.");
        System.out.println("It works by applying a uniform shift to each alphabetic character in the input string.");
        System.out.println();
    }

    public void getText(String text,int key) {
        this.text = text;
        this.key = key;
    }

    public String encryptText() {
        StringBuffer encryptedString = new StringBuffer();
        for(int i=0;i<text.length();i++) {
            if(Character.isUpperCase(text.charAt(i))) {
                encryptedString.append((char)(((text.charAt(i) - 'A' + key) % 26 )+ 'A'));
            }
            else if(Character.isLowerCase(text.charAt(i))) {
                encryptedString.append((char)(((text.charAt(i) - 'a' + key) % 26 )+ 'a'));
            }
            else if(Character.isDigit(text.charAt(i))) {
                encryptedString.append(text.charAt(i));
            }
        }
        return encryptedString.toString();
    }

    public String decryptText() {
        StringBuffer decryptedString = new StringBuffer();
        for(int i=0;i<text.length();i++) {
            if(Character.isUpperCase(text.charAt(i))) {
                decryptedString.append((char)(((text.charAt(i) - 'A' - key + 26) % 26 )+ 'A'));
            }
            else if(Character.isLowerCase(text.charAt(i))) {
                decryptedString.append((char)(((text.charAt(i) - 'a' - key + 26) % 26 )+ 'a'));
            }
            else if(Character.isDigit(text.charAt(i))) {
                decryptedString.append(text.charAt(i));
            }
        }
        return decryptedString.toString();
    }

}

interface AffineCipher {
    public void affineCipherMethod();
    public void getText(String text,int key1,int key2);
    public String encryptText();
    public String decryptText();
}

class AffineCipherImpl implements AffineCipher {
    String text;
    int key1,key2;
    char decryptedChar;
    
    public void affineCipherMethod() {
        System.out.println("\n====================================");
        System.out.println("Affine Cipher Method");
        System.out.println("====================================\n");
        System.out.println("The Affine Cipher is a classical substitution using mathematical functions to encrypt and decrypt messages.");
        System.out.println("This technique introduces a more complex level of encryption by combining arithmatic operations.");
        System.out.println();
    }

    public void getText(String text,int key1,int key2) {
        this.text = text;
        this.key1 = key1;
        this.key2 = key2;
    }

    public String encryptText() {
        StringBuffer encryptedString = new StringBuffer();
        for(int i=0;i<text.length();i++) {
            if(Character.isUpperCase(text.charAt(i))) {
                encryptedString.append((char)((((key1 * (text.charAt(i) - 'A')) + key2 ) % 26) + 'A'));
            }
            else if(Character.isLowerCase(text.charAt(i))) {
                encryptedString.append((char)((((key1 * (text.charAt(i) - 'a')) + key2 ) % 26) + 'a'));
            }
            else if(Character.isDigit(text.charAt(i))) {
                encryptedString.append(text.charAt(i));
            }
        }
        return encryptedString.toString();
    }   
    
    private int modInverse(int a,int m) {
        a = a%m;
        for(int x=1;x<m;x++) {
            if((a*x)%m == 1) {
                return x;
            }
        }
        return -1;
    }

    public String decryptText() {
        StringBuffer decryptedString = new StringBuffer();
        for(int i=0;i<text.length();i++) {
            char ch = text.charAt(i);
            if(Character.isUpperCase(text.charAt(i))) {
                int aInv = modInverse(key1, 26);
                int decryptVal = (aInv * ((ch - 'A' - key2 + 26) % 26)) % 26;
                char decryptedChar = (char) (decryptVal + 'A');
                decryptedString.append(decryptedChar);
            }
            else if(Character.isLowerCase(text.charAt(i))) {
                int aInv = modInverse(key1, 26);
                int decryptVal = (aInv * ((ch - 'a' - key2 + 26) % 26)) % 26;
                char decryptedChar = (char) (decryptVal + 'a');
                decryptedString.append(decryptedChar);
            }
            else if(Character.isDigit(text.charAt(i))) {
                decryptedString.append(text.charAt(i));
            }
        }
        return decryptedString.toString();
    }
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
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        do {
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
                        do {
                            System.out.println("Ceaser Cipher Method : ");
                            System.out.println();
                            System.out.println("1 -> Description");
                            System.out.println("2 -> Cipher Text - Encryption");
                            System.out.println("3 -> Cipher Text - Decryption");
                            System.out.println("-1 -> Quit Ceaser Cipher Method");

                            System.out.print("Enter your choice : ");
                            choice = scan.nextInt();

                            try {
                                if(choice == 1) {
                                    cc.ceaserCipherMethod();
                                }
                                else if(choice == 2) {
                                    System.out.println("Enter Text to Encrypt : ");
                                    scan.nextLine();
                                    String text = scan.nextLine();
                                    System.out.println("Enter Key to Encrypt : ");
                                    int key = scan.nextInt();
                                    cc.getText(text, key);
                                    System.out.println(cc.encryptText());
                                }
                                else if(choice == 3) {
                                    System.out.println("Enter Text to Decrypt : ");
                                    scan.nextLine();
                                    String text = scan.nextLine();
                                    System.out.println("Enter Key to Decrypt : ");
                                    int key = scan.nextInt();
                                    cc.getText(text, key);
                                    System.out.println(cc.decryptText());
                                }
                            }
                            catch(InputMismatchException e) {
                                System.err.println("Invlid Input Passed | Enter input range between (1 - 3)");
                            }
                            catch(Exception e) {
                                System.err.println(e.getMessage());
                            }

                        }while(choice != -1);

                        break;
                    case 2:
                        AffineCipherImpl ac = new AffineCipherImpl();

                        do {
                            System.out.println("Affine Cipher Method : ");
                            System.out.println();
                            System.out.println("1 -> Description");
                            System.out.println("2 -> Affine Text - Encryption");
                            System.out.println("3 -> Affine Text - Decryption");
                            System.out.println("-1 -> Quit Affine Cipher Method");

                            System.out.print("Enter your choice : ");
                            choice = scan.nextInt();

                            try {
                                if(choice == 1) {
                                    ac.affineCipherMethod();
                                }
                                else if(choice == 2) {
                                    System.out.println("Enter Text to Encrypt : ");
                                    scan.nextLine();
                                    String text = scan.nextLine();
                                    System.out.println("Enter Key to Encrypt : ");
                                    System.out.println("Enter a value - (prime number) : ");
                                    int key1 = scan.nextInt();
                                    System.out.println("Enter b value : ");
                                    int key2 = scan.nextInt();
                                    ac.getText(text, key1,key2);
                                    System.out.println(ac.encryptText());
                                }
                                else if(choice == 3) {
                                    System.out.println("Enter Text to Decrypt : ");
                                    scan.nextLine();
                                    String text = scan.nextLine();
                                    System.out.println("Enter Keys to Decrypt : ");
                                    System.out.println("Enter a value - (prime number) : ");
                                    int key1 = scan.nextInt();
                                    System.out.println("Enter b value : ");
                                    int key2 = scan.nextInt();
                                    ac.getText(text, key1, key2);
                                    System.out.println(ac.decryptText());
                                }
                            }
                            catch(InputMismatchException e) {
                                System.err.println("Invlid Input Passed | Enter input range between (1 - 3)");
                            }
                            catch(Exception e) {
                                System.err.println(e.getMessage());
                            }

                        }while(choice != -1);

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
        scan.close();
        System.out.println("Thank You");
    }
}
