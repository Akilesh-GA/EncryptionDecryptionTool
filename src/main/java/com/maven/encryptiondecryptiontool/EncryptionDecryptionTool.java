package com.maven.encryptiondecryptiontool;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.*;

class User {
    protected String name;
    protected String email;
    private String password;
    User(String name,String email,String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

class Admin extends User {
    Admin(String name,String email,String password) {
        super(name,email,password);
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void displayUserDetails() {
        System.out.println("===========================================\n");
        System.out.println("Admin Deatils : ");
        System.out.println("Username : " + getName());
        System.out.println("Email id : " + getEmail());
        System.out.println("\n===========================================\n");
    }
    public void displayUserPrivilages() {
        System.out.println("===========================================\n");
        System.out.println("Admin Privilages : ");
        System.out.println(" > Database Access ");
        System.out.println(" > Edit & Modify users Data");
        System.out.println("\n===========================================\n");
    }
}

class Others extends User {
    Others(String name,String email,String password) {
        super(name,email,password);
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void displayUserDetails() {
        System.out.println("===========================================\n");
        System.out.println("Other User Deatils : ");
        System.out.println("Username : " + getName());
        System.out.println("Email id : " + getEmail());
        System.out.println("\n===========================================\n");
    }
    public void displayUserPrivilages() {
        System.out.println("===========================================\n");
        System.out.println("Other User Privilages : ");
        System.out.println(" > Database Access ");
        System.out.println(" > Only View users Data");
        System.out.println("\n===========================================\n");
    }
}

interface CeaserCipher {
    public void ceaserCipherMethod();
    public void setText(String text,int key);
    public String encryptText();
    public String decryptText();
}

class CeaserCipherImpl implements CeaserCipher {
    String text;
    int key;
    String res;
    public void ceaserCipherMethod() {
        System.out.println("\n===========================================");
        System.out.println("\tCEASER CIPHER TECHNIQUE");
        System.out.println("===========================================\n");
        
        System.out.println("The Caesar Cipher is one of the encryption algorithm and ancient cryptography method.");
        System.out.println("It works by applying a uniform shift to each alphabetic character in the input string.");
        System.out.println();
    }

    public void setText(String text,int key) {
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
    public void setText(String text,int key1,int key2);
    public String encryptText();
    public String decryptText();
}

class AffineCipherImpl implements AffineCipher {
    String text;
    int key1,key2;
    char decryptedChar;
    
    public void affineCipherMethod() {
        System.out.println("\n===========================================");
        System.out.println("\tAFFINE CIPHER TECHNIQUE");
        System.out.println("===========================================\n");
        System.out.println("The Affine Cipher is a classical substitution using mathematical functions to encrypt and decrypt messages.");
        System.out.println("This technique introduces a more complex level of encryption by combining arithmatic operations.");
        System.out.println();
    }

    public void setText(String text,int key1,int key2) {
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
    public void atbashCipherMethod();
}

class AtbashCipherImpl implements AtbashCipher {
    String text;

    public void atbashCipherMethod() {
        System.out.println("\n===========================================");
        System.out.println("\tATBASH CIPHER TECHNIQUE");
        System.out.println("===========================================\n");
        System.out.println();
        System.out.println("The Atbash Cipher is a classical substitution cipher where each letter in the alphabet is reversed.");
        System.out.println("It does not use any keys, making it one of the simplest ciphers to implement and understand and Ideal for beginners in cryptography.");
    }
    public void setText(String text) {
        this.text = text;
    }
    public String encryptText() {
        StringBuffer encryptedString = new StringBuffer();
        HashMap<Character,Character> map = new HashMap<>();
        for(char i='a',j='z'; i<='z'; i++,j--) {
            map.put(i,j);
        }
        for(char i='A',j='Z'; i<='Z'; i++,j--) {
            map.put(i,j);
        }
        for(int i=0;i<text.length();i++) {
            Character mapped = map.get(text.charAt(i));
            if(mapped != null) {
                encryptedString.append(mapped);
            }
            else {
                encryptedString.append(text.charAt(i));
            }
        }
        return encryptedString.toString();
    }
    public String decryptText() {
        StringBuffer decryptedString = new StringBuffer();
        HashMap<Character,Character> map = new HashMap<>();
        for(char i='z',j='a'; i>='a'; i--,j++) {
            map.put(i,j);
        }
        for(char i='Z',j='A'; i>='A'; i--,j++) {
            map.put(i,j);
        }
        for(int i=0;i<text.length();i++) {
            Character mapped = map.get(text.charAt(i));
            if(mapped != null) {
                decryptedString.append(mapped);
            }
            else {
                decryptedString.append(text.charAt(i));
            }
        }
        return decryptedString.toString();
    }
}


interface XORCipher {
    public void XORCipherMethod();
    public void setText(String text, char key);
    public String encryptText();
    public String decryptText();
}

class XORCipherImpl implements XORCipher {
    String text;
    char key;

    public void XORCipherMethod() {
        System.out.println("\n===========================================");
        System.out.println("\tXOR CIPHER TECHNIQUE");
        System.out.println("===========================================\n");
        System.out.println("The XOR Cipher is a symmetric encryption technique that applies the XOR operation between the plaintext and a key.");
        System.out.println("This makes it a lightweight encryption method commonly used in low-level security systems or embedded devices.");
        System.out.println();
    }
    public void setText(String text, char key) {
        this.text = text;
        this.key = key;
    }
    public String encryptText() {
        StringBuffer encryptedString = new StringBuffer();
        for(int i=0;i<text.length();i++) {
            encryptedString.append((char)(text.charAt(i) ^ key));
        }
        return encryptedString.toString();
    }
    public String decryptText() {
        StringBuffer decryptedString = new StringBuffer();
        for(int i=0;i<text.length();i++) {
            decryptedString.append((char)(text.charAt(i) ^ key));
        }
        return decryptedString.toString();
    }
}

public class EncryptionDecryptionTool {
    public static void main(String[] args) {

        String name;
        String email;
        String password;

        Scanner scan = new Scanner(System.in);

        System.out.println("\n===========================================");
        System.out.println("\tENCRYPTION DECRYPTION TOOL");
        System.out.println("===========================================\n");
        System.out.print("Enter Username : ");
        name = scan.nextLine();
        System.out.print("Enter Email id : ");
        email = scan.nextLine();
        System.out.print("Enter Password : ");
        password = scan.nextLine();
        System.out.println("\n===========================================");
        
        //Admin Details
        String AdminPassword = "admin1466";
        String AdminMailId = "admin@outlook.com";
        int value = 0;

        try {

            if(name.trim().toLowerCase().equals("admin") && password.trim().equals(AdminPassword) && email.trim().equals(AdminMailId)) {
                Admin admin = new Admin(name,email,password);
                do {
                    System.out.println("1 -> View Admin Details");
                    System.out.println("2 -> Admin Privilages");
                    System.out.println("-1 -> Quit Admin");
                    System.out.println("Enter Value : ");
                    value = scan.nextInt();
                    if(value == 1) {
                        admin.displayUserDetails();
                    }
                    else if(value == 2) {
                        admin.displayUserPrivilages();
                    }
                    else if((value < 1 && value != -1) || (value > 3 && value != -1)) {
                        System.out.println("Invalid Input Passed !");
                        System.out.println("Enter option range (1 - 2) ");
                    }
                } while(value != -1);
            }
            else if((name.trim().toLowerCase().equals("admin")) && !(password.trim().equals(AdminPassword) && email.trim().equals(AdminMailId))) {
                System.out.println("ALERT: Unauthorized admin access attempt !");
                System.out.println("Verify your login -> name email and password ");
                System.exit(0);
            }
            else {
                Others others = new Others(name,email,password);
                do {
                    System.out.println("1 -> View User Details");
                    System.out.println("2 -> User Privilages");
                    System.out.println("-1 -> Quit User");
                    System.out.println("Enter Value : ");
                    value = scan.nextInt();
                    if(value == 1) {
                        others.displayUserDetails();
                    }
                    else if(value == 2) {
                        others.displayUserPrivilages();
                    }
                    else if((value < 1 && value != -1) || (value > 3 && value != -1)) {
                        System.out.println("Invalid Input Passed !");
                        System.out.println("Enter option range (1 - 2) ");
                    }
                } while(value != -1);
            }

        }
        catch(Exception e) {
            System.err.println(e);
        }

        String uri = "mongodb://localhost:27017/";

        try(MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("maven-project");
            MongoCollection<Document> collection = database.getCollection("users");
            Document userDocument = new Document("name",name).append("email",email).append("password",password);
            collection.insertOne(userDocument);
        }

        int option = 0;
        int choice = 0;
        
        do {
            System.out.println("===========================================\n");

            System.out.println("Choose Encrypting / Decrypting Technique");
            System.out.println("1 -> Ceaser Cipher");
            System.out.println("2 -> Affine Cipher");
            System.out.println("3 -> Atbash Cipher");
            System.out.println("4 -> XOR Cipher");
            System.out.println("-1 -> Quit Application");

            System.out.print("Enter your option : ");

            option = scan.nextInt();

            if((option < 1 && option != -1) || (option > 4 && option != 1)) {
                System.out.println("Invalid Input Passed !");
                System.out.println("Enter option range (1 - 4) ");
            }
            if(option == -1) {
                break;
            }
            else {
                switch (option) {
                    case 1:
                        CeaserCipherImpl cc = new CeaserCipherImpl();
                        do {
                            System.out.println("\n\n===========================================\n");
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
                                    System.out.print("Enter Text to Encrypt : ");
                                    scan.nextLine();
                                    String text = scan.nextLine();
                                    System.out.print("Enter Key to Encrypt : ");
                                    int key = scan.nextInt();
                                    cc.setText(text, key);
                                    System.out.print("Encrypted Text : " + cc.encryptText());
                                }
                                else if(choice == 3) {
                                    System.out.print("Enter Text to Decrypt : ");
                                    scan.nextLine();
                                    String text = scan.nextLine();
                                    System.out.print("Enter Key to Decrypt : ");
                                    int key = scan.nextInt();
                                    cc.setText(text, key);
                                    System.out.print("Decrypted Text : " + cc.decryptText());
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
                            System.out.println("\n\n===========================================\n");
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
                                    ac.setText(text, key1,key2);
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
                                    ac.setText(text, key1, key2);
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
                        do {
                            System.out.println("\n\n===========================================\n");
                            System.out.println("Atbash Cipher Method : ");
                            System.out.println();
                            System.out.println("1 -> Description");
                            System.out.println("2 -> Atbash Text - Encryption");
                            System.out.println("3 -> Atbash Text - Decryption");
                            System.out.println("-1 -> Quit Atbash Cipher Method");

                            System.out.print("Enter your choice : ");
                            choice = scan.nextInt();

                            try {
                                if(choice == 1) {
                                    at.atbashCipherMethod();
                                }
                                else if(choice == 2) {
                                    System.out.println("Enter Text to Encrypt : ");
                                    scan.nextLine();
                                    String text = scan.nextLine();
                                    at.setText(text);
                                    System.out.print("Encrypted Text : " + at.encryptText());
                                }
                                else if(choice == 3) {
                                    System.out.println("Enter Text to Decrypt : ");
                                    scan.nextLine();
                                    String text = scan.nextLine();
                                    at.setText(text);
                                    System.out.print("Decrypted Text : " + at.decryptText());
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
                    case 4:
                        XORCipherImpl xor = new XORCipherImpl();
                        do {
                            System.out.println("\n===========================================\n");
                            System.out.println("XOR Cipher Method : ");
                            System.out.println();
                            System.out.println("1 -> Description");
                            System.out.println("2 -> XOR Text - Encryption");
                            System.out.println("3 -> XOR Text - Decryption");
                            System.out.println("-1 -> Quit XOR Cipher Method");

                            System.out.print("Enter your choice : ");
                            choice = scan.nextInt();

                            try {
                                if(choice == 1) {
                                    xor.XORCipherMethod();
                                }
                                else if(choice == 2) {
                                    System.out.println("Enter Text to Encrypt : ");
                                    scan.nextLine();
                                    String text = scan.nextLine();
                                    System.out.println("Enter Key to Encrypt : ");
                                    char key = scan.next().charAt(0);
                                    xor.setText(text,key);
                                    System.out.print("Encrypted Text : " + xor.encryptText());
                                }
                                else if(choice == 3) {
                                    System.out.println("Enter Text to Decrypt : ");
                                    scan.nextLine();
                                    String text = scan.nextLine();
                                    System.out.println("Enter Key to Encrypt : ");
                                    char key = scan.next().charAt(0);
                                    xor.setText(text,key);
                                    System.out.print("Decrypted Text : " + xor.decryptText());
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
                    default:
                        break;
                }
            }
        } while(option != -1);
        scan.close();
    }
}