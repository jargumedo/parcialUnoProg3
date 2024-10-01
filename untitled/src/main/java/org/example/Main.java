package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] dna = {"ATGCGA","CATTGC","TTATGT","AGAATG","CCCCTA","TCACTG"};
        for (int i = 0; i < dna.length; i++) {
            String fila = dna[i];
            //System.out.println(validRow(fila, dna.length));
        }
        //System.out.println(testRows(dna));
        //System.out.println(testColumn(dna));
        //System.out.println(testPrincipalDiagonals(dna));
        System.out.println(testSupDiagonal(dna));

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
        int n = dna.length;  // Tamaño de la matriz nxn
        int count = 0;  // Contador para saber cuántas diagonales cumplen la condición

        // Primera pasada para contar cuántas diagonales tienen longitud >= 4
        for (int i = 0; i < n - 1; i++) {
            String diagonal = "";
            for (int j = 0; j < n - i - 1; j++) {
                diagonal = diagonal.concat(dna[j].substring(j + i + 1, j + i + 2));
            }
            if (diagonal.length() >= 4) {
                count++;  // Contamos las diagonales que cumplen la condición
            }
        }

        // Creamos el array de diagonales con el tamaño exacto
        String[] dnaDiagonalSup = new String[count];
        int index = 0;  // Índice para almacenar en el array

        // Segunda pasada para llenar el array con las diagonales que cumplen la condición
        for (int i = 0; i < n - 1; i++) {
            String diagonal = "";
            for (int j = 0; j < n - i - 1; j++) {
                diagonal = diagonal.concat(dna[j].substring(j + i + 1, j + i + 2));
            }
            if (diagonal.length() >= 4) {
                dnaDiagonalSup[index] = diagonal;  // Almacenamos la diagonal
                index++;
            }
        }

        // Imprimir los resultados
        for (int i = 0; i < dnaDiagonalSup.length; i++) {
            System.out.println("Diagonal " + (i + 1) + ": " + dnaDiagonalSup[i]);
        }

        return testRows(dnaDiagonalSup);
    }

//    public static boolean testSupDiagonal(String[] dna) {
//        String[] dnaDiagonalSup = new String[dna.length - 4];
//        for (int i = 0; i < dnaDiagonalSup.length; i++) {
//            dnaDiagonalSup[i] = "";
//            int num = 1;
//            //String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
//            for (int j = 0; j < dna[i].length()-1; j++) {
//                if(i==0){
//                    dnaDiagonalSup[0] = dnaDiagonalSup[0].concat(dna[j].substring(j + 1, j + 2));
//                }else if(i==1 && dnaDiagonalSup[1].length()<4){
//                    dnaDiagonalSup[1] = dnaDiagonalSup[1].concat(dna[j].substring(j + 2, j + 3));
//                }
//
//
//            }
//
//        }
//        System.out.println(dnaDiagonalSup[0]);
//        System.out.println(dnaDiagonalSup[1]);
//
//
//
//        return true;
//    }

}