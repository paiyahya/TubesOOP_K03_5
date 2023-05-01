// public class p {
//     public static void main(String[] args) {
//         String[][] matriks = new String[6][6];
//         int angka = 1;
//         for (int i = 0; i < 6; i++) {
//             for (int j = 0; j < 6; j++) {
//                 if(angka < 10){
//                     matriks[i][j] = "0" + angka;
//                 }else{
//                     matriks[i][j] = "" + angka;
//                 }
//                 angka++;
//             }
//         }
//         for (int i = 0; i < 6; i++) {
//             for (int j = 0; j < 6; j++) {
//                 System.out.print(matriks[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }
// }

// import java.util.Scanner;

// public class matriks {
//     public static void print(int[][] matriks){
//         for (int i = 0; i < 6; i++) {
//             for (int j = 0; j < 6; j++) {
//                 if (matriks[i][j] < 10){
//                     System.out.print(" " + matriks[i][j] + " ");
//                 }else{
//                     System.out.print(matriks[i][j] + " ");
//                 }
//             }
//             System.out.println();
//         }
//     }
//     public static void main(String[] args) {
//         int[][] matriks = new int[6][6];
//         int angka = 1;
//         for (int i = 0; i < 6; i++) {
//             for (int j = 0; j < 6; j++) {
//                 if(angka < 10){
//                     matriks[i][j] = angka;
//                 }else{
//                     matriks[i][j] = angka;
//                 }
//                 angka++;
//             }
//         }
//         print(matriks);

//         int input = 0;
//         while(input != -999){
//             Scanner sc = new Scanner(System.in);
//             System.out.print("Masukkan angka: ");
//             input = sc.nextInt();
//             if(input != -999){
//                 for (int i = 0; i < 6; i++) {
//                     for (int j = 0; j < 6; j++) {
//                         if(matriks[i][j] == input){
//                             // System.out.println("Angka " + input + " ditemukan pada posisi (" + i + "," + j + ")");
//                             matriks[i][j] = 99;
//                         }
//                     }
//                 }
//             }
//             print(matriks);
//         } 
//     }
// }

import java.util.Scanner;

public class Matriks {
    public static void print(int[][] matriks) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (matriks[i][j] < 10) {
                    System.out.print(" " + matriks[i][j] + " ");
                } else {
                    System.out.print(matriks[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matriks = new int[6][6];
        int angka = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (angka < 10) {
                    matriks[i][j] = angka;
                } else {
                    matriks[i][j] = angka;
                }
                angka++;
            }
        }
        print(matriks);

        int input = 0;
        while (input != -999) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Masukkan angka: ");
            input = sc.nextInt();
            if (input != -999) {
                boolean found = false;
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (matriks[i][j] == input) {
                            if (matriks[i][j] != 99) {
                                matriks[i][j] = 99;
                            }
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Angka tidak ditemukan! Barang tidak dapat ditempatkan pada posisi berikut!");
                }
            }
            print(matriks);
        }
    }
}
