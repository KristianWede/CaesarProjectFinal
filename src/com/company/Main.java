package com.company;

import java.util.Scanner;

public class Main {

    boolean validAnswer = false;
    Scanner sc = new Scanner(System.in);
    char[] alfabet = {' ', 'A', 'B', 'C', 'D','E','F','G','H','I','J','K','L','M','N',
            'O','P','Q','R','S','T','U','V','W','X','Y','Z','Æ','Å'};

    public int encryptOrDecrypt(int shift){ //Sprøger om hvis den skal enten encrypt eller decrupy.

        do{
            System.out.println("Skal du Encrypt eller Decrypt?");
            String dilemma = sc.next();
            switch(dilemma) {
                case "Encrypt":
                    return shift;
                case "Decrypt":
                    return redefineShift(shift);
                default:
                    System.out.println("Det passer ikke noget! Prøv igen!");
            }
        } while (!validAnswer);

        return 404;
    }

    public int redefineShift(int shift){ //Hvis den skal dekryptere, bliver shift sat til negativ.
        //Sætter shift til negativ.
        int newShift = shift * -1;
        return newShift;
    }

    //public String solveChar(){ //Brug denne her til alle objekter, som løser koden.


    //    return character;
    //}


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main obj = new Main();

        //Introduktion til Casesar Cipher
        //Sprøger efter besked og shift.
        System.out.println("Velkommen til Caesar Cipher 2022! v0.5!");
        System.out.println("Venligst indtast en besked som skal kodes: ");
        String besked = sc.nextLine();
        System.out.println("Mange tak! Venligst indtast en shift.");
        int shift = sc.nextInt();

        //Tager beslutning om shift er til decrypt eller encrypt.
        shift = obj.encryptOrDecrypt(shift);
        System.out.println(shift);













    }
}
