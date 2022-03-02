package com.company;

import java.util.Scanner;

public class Main {

    boolean validAnswer = false;
    Scanner sc = new Scanner(System.in);
    int shift = 0;

    public int encryptOrDecrypt(int shift){

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
        } while (validAnswer == false);

        return 404;
    }

    public int redefineShift(int shift){
        //Sætter shift til negativ.
        int newShift = shift * -1;
        return newShift;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main obj = new Main();

        System.out.println("Velkommen til Caesar Cipher 2022! v0.5!");
        System.out.println("Venligst indtast en besked som skal kodes: ");
        String besked = sc.nextLine();
        System.out.println("Mange tak! Venligst indtast en shift.");
        int shift = sc.nextInt();

        System.out.println(obj.encryptOrDecrypt(shift));



        //Introduktion til Casesar Cipher






    }
}
