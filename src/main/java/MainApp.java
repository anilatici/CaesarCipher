import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainApp {
    public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String decrypt(String data, int shiftkey){
        data = data.toLowerCase();
        String decryptStr ="";
        for(int i =0; i < data.length(); i++){
            char c = data.charAt(i);
            int charPosition = alphabet.indexOf(c);
            if (charPosition == -1)
            {
                decryptStr += c;
                continue;
            }
            int pos = alphabet.indexOf(data.charAt(i));
            int decryptPos = (pos - shiftkey) % 26;
            if(decryptPos < 0){
                decryptPos = alphabet.length() + decryptPos;
            }
            char decryptChar = alphabet.charAt(decryptPos);
            decryptStr += decryptChar;
        }
        return decryptStr;
    }

    public static void bruteForce(String data)
    {
        data = data.toLowerCase();
        String decryptStr ="";
        for (int i=0; i<26; i++)
        {
            System.out.println("Key: " + (i+1) + " Decrypted text: " + decrypt(data, i));;
        }

    }


    public static void main(String[] args) throws IOException {

        String data = null;
        String data1 = null;
        int shiftKey = 3;
        try {
            data = Files.readAllLines(Paths.get("/Users/anilatici/year 2 semester 1/computer security/CaesarCipher/src/main/text/ciphertext.txt")).get(0);
            data1 = Files.readAllLines(Paths.get("/Users/anilatici/year 2 semester 1/computer security/CaesarCipher/src/main/text/ciphertext.txt")).get(1);

        } catch (FileNotFoundException e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        }

        System.out.println("Text  : " + data);
        System.out.println("Shift : " + shiftKey);
        System.out.println("Decrypted data: " + decrypt(data, shiftKey));
        bruteForce(data1);
    }
}
