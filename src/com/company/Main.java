package com.company;

import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);
    char[] alfabet = {' ', 'A', 'B', 'C', 'D','E','F','G','H','I','J','K','L','M','N',
            'O','P','Q','R','S','T','U','V','W','X','Y','Z','Æ','Å'};

    public int encryptOrDecrypt(int shift){ //Sprøger om hvis den skal enten encrypt eller decrypt.

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
        } while (true);
    }

    public int redefineShift(int shift){ //Hvis den skal dekryptere, bliver shift sat til negativ.
        //Sætter shift til negativ.
        int newShift = shift * -1;
        return newShift;
    }
/*
    public String solveChar(String besked){ //Brug denne her til alle objekter, som løser koden.
        for (int i = 0; besked.length() > i ; i++)
            messageToChar(besked, step);
    return character;
    }
 */

    public char messageToChar(String message, int step){ //Bruger en step variabel, så den ved hvilken del i beskeden skal returneres.
            char bogstav = message.charAt(step);
            return bogstav;
    }

    public int bogstaverTilTal(char inputBogstav){
        //Går igennem alle bogstaver indtil den finder hvilket tal passer til et char i alfabet Arrayet.
        for (int i = 0;alfabet.length >= i; i++ ){
            //Tjekker om alfabet Array er det samme som inputtet.
            if ( alfabet[i] == inputBogstav){
                //Returnerer tallet.
                return i;
            }
        }
        return 404;
    }

    public int applyShift(int talBogstav, int shift){

        int shifted = shift + talBogstav;

            //Hvis encryption går over 28 i alfabetet, sætter den tilbage til A,B,C.
            if (shifted > 28){
                shifted = shifted % alfabet.length + 1;
            }

            //Hvis decryption er lige med el. under 0, plusser den med 28.
            if (shifted <= 0){
                shifted +=28;
            }

        return shifted;
    }

    public char taltilBogstaver(int inputTal) {
        //Spørger efter et char med det int fra input.
        char result = alfabet[inputTal];
        return result;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main obj = new Main();
        int step = 0;

        //Introduktion til Casesar Cipher
        //Sprøger efter besked og shift.
        System.out.println("Velkommen til Caesar Cipher 2022! v0.5!");
        System.out.println("Venligst indtast en besked som skal kodes: ");
        String besked = sc.nextLine().toUpperCase();
        System.out.println("Mange tak! Venligst indtast en shift.");
        int shift = sc.nextInt();
        System.out.println();

        //Tager beslutning om shift er til decrypt eller encrypt.
        shift = obj.encryptOrDecrypt(shift);


        System.out.println(shift);//Debugging
        //Skal igennem hele beskeden, og printer den ud én gang, hver gang den looper.
        for (int i = 0;besked.length() > i ; i++) {

            char bogstav = obj.messageToChar(besked, step);

            int bogstavTal = obj.bogstaverTilTal(bogstav);

            int shiftedBogstavTal = obj.applyShift(bogstavTal, shift);

            //char shiftedBogstav =

            System.out.print(shiftedBogstavTal);
            System.out.print(" ");

            //Tilføjer step til sidst så det næste bogstav bliver valgt til næste gang.
            step++;
        }
    }
}
