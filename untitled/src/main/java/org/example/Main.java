package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        for (int i = 0; i < dna.length; i++) {
            String fila = dna[i];
            //System.out.println(validRow(fila, dna.length));
        }
        //System.out.println(testRows(dna));
        //System.out.println(testColumn(dna));
        //System.out.println(testPrincipalDiagonals(dna));
//        testSupDiagonal(dna);
        testAllDiagonals(dna);
    }


    public static void mostrarMatriz(String[] matriz, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(matriz[i]);

        }
    }

    public static boolean validRow(String fila, int n) {
        fila = fila.toLowerCase();
        int count = 0;
        String validString[] = fila.split("");
        for (int i = 0; i < fila.length(); i++) {
            if (!validString[i].equals("a") && !validString[i].equals("c") && !validString[i].equals("g") && !validString[i].equals("t")) {
                return false;
            } else {
                count++;
            }
        }
        if (count != n) {

            return false;
        }
        return true;
    }


    //Para validar necesitamos que se mueva dna[i] = Los string
    public static boolean testRows(String[] dna) {
        for (int i = 0; i < dna.length; i++) {
            String[] validateString = dna[i].split("");
            int count = 1;
            for (int j = 0; j < validateString.length - 1; j++) {

                if (validateString[j].equals(validateString[j + 1])) {
                    count++;
                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 1;
                }
            }
        }
        return false;
    }

    //    String[] dna = {"ATGACA","CAGTGC","TTATGT","AGATGG","CCCCTA","TCACTG"};
    // A   A   A   T   T   G
    //0;0 1;1 2;2 3;3 4;4 5;5
    public static boolean testDiagonal(String[] dna) {
        return true;
    }


    public static boolean testColumn(String[] dna) {
        String[] dnaColumn = new String[dna.length];
        for (int i = 0; i < dna.length; i++) {
            dnaColumn[i] = "";
            for (int j = 0; j < dna[i].length(); j++) {
                dnaColumn[i] = dnaColumn[i].concat(dna[j].substring(i, i + 1));
            }
        }
        mostrarMatriz(dnaColumn, dna.length);
        return testRows(dnaColumn);
    }

    public static boolean testPrincipalDiagonals(String[] dna) {
        int position = 0;
        String[] dnaDiagonal = new String[2];
        for (int i = 0; i < dnaDiagonal.length; i++) {
            dnaDiagonal[i] = "";
            for (int k = 0; k < dna[i].length(); k++) {
                for (int j = 0; j < dna[i].length(); j++) {
                    if (k == j && i == 0) {
                        dnaDiagonal[0] = dnaDiagonal[0].concat(dna[k].substring(j, j + 1));
                        break;
                    } else if (k + j == dna.length - 1 && i == 1) {
                        dnaDiagonal[1] = dnaDiagonal[1].concat(dna[k].substring(j, j + 1));
                    }
                }

            }
        }
        return testRows(dnaDiagonal);

    }

    public static boolean testSupDiagonal(String[] dna) {
        String[] dnaDiagonalSup = new String[dna.length - 4];
        for (int i = 0; i < dnaDiagonalSup.length; i++) {
            dnaDiagonalSup[i] = "";
            int num = 1;
            //String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
            for (int k = 0; k < dna[i].length()-1; k++) {
                if(i==0){
                    dnaDiagonalSup[0] = dnaDiagonalSup[0].concat(dna[i].substring(k + 1, k + 2));
                }else if(i==1){
                    dnaDiagonalSup[1] = dnaDiagonalSup[1].concat(dna[i].substring(k + 1, k + 2));
                }


            }

        }
        System.out.println(dnaDiagonalSup[0]);
        System.out.println(dnaDiagonalSup[1]);



        return true;
    }

    public static boolean testAllDiagonals(String[] dna) {
        int n = dna.length;

        // Diagonales superiores
        for (int i = 0; i < n - 3; i++) {
            if (checkDiagonal(dna, 0, i, 1, 1)) return true;
            if (checkDiagonal(dna, i, 0, 1, 1)) return true;
        }

        // Diagonales inferiores
        for (int i = 0; i < n - 3; i++) {
            if (checkDiagonal(dna, 0, i, 1, -1)) return true;
            if (checkDiagonal(dna, n - 1, i, -1, 1)) return true;
        }

        return false;
    }

    private static boolean checkDiagonal(String[] dna, int startRow, int startCol, int rowStep, int colStep) {
        int n = dna.length;
        int count = 1;
        char prev = dna[startRow].charAt(startCol);

        for (int i = 1; i < n; i++) {
            int row = startRow + i * rowStep;
            int col = startCol + i * colStep;

            if (row < 0 || row >= n || col < 0 || col >= n) break;

            char current = dna[row].charAt(col);
            if (current == prev) {
                count++;
                if (count == 4) return true;
            } else {
                count = 1;
            }
            prev = current;
        }

        return false;
    }
}