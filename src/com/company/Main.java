package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File fileOne = new File("one.txt");
            File fileTwo = new File("two.txt");
            Scanner scan1 = new Scanner(fileOne);
            Scanner scan2 = new Scanner(fileTwo);
            while (scan1.hasNextLine()) {
               String data = scan1.nextLine();
               System.out.println(data);
            }
            while (scan2.hasNextLine()) {
                String data = scan2.nextLine();
                System.out.println(data);
            }
            scan1.close();
            scan2.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
