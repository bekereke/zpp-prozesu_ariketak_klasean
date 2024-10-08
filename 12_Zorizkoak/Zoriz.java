package unieibar;
import java.io.*;
import java.util.Scanner;

class Zoriz {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String line;
        while ((line = sc.nextLine()) != null) {
            if (line.equals("buka")) {
                break;
            }
            System.out.println((int) (Math.random() * 11));
        }
    }
}