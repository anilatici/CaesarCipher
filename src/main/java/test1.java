import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) throws IOException{
        String data = Files.readAllLines(Paths.get("/Users/anilatici/year 2 semester 1/computer security/CaesarCipher/src/main/text/ciphertext.txt")).get(0);
        System.out.println(data);
    }
}
