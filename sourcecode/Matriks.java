// import java.util.Scanner;

// public class Matriks {
//     public static void print(int[][] matriks) {
//         for (int i = 0; i < 6; i++) {
//             for (int j = 0; j < 6; j++) {
//                 if (matriks[i][j] < 10) {
//                     System.out.print(" " + matriks[i][j] + " ");
//                 } else {
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
//                 if (angka < 10) {
//                     matriks[i][j] = angka;
//                 } else {
//                     matriks[i][j] = angka;
//                 }
//                 angka++;
//             }
//         }
//         print(matriks);

//         int input = 0;
//         while (input != -999) {
//             Scanner sc = new Scanner(System.in);
//             System.out.print("Masukkan angka: ");
//             input = sc.nextInt();
//             if (input != -999) {
//                 boolean found = false;
//                 for (int i = 0; i < 6; i++) {
//                     for (int j = 0; j < 6; j++) {
//                         if (matriks[i][j] == input) {
//                             if (matriks[i][j] != 99) {
//                                 matriks[i][j] = 99;
//                             }
//                             found = true;
//                             break;
//                         }
//                     }
//                     if (found) {
//                         break;
//                     }
//                 }
//                 if (!found) {
//                     System.out.println("Angka tidak ditemukan! Barang tidak dapat ditempatkan pada posisi berikut!");
//                 }
//             }
//             print(matriks);
//         }
//     }
// }

// import java.util.Scanner;

// public class Matriks {
//     public static void print(int[][] matriks) {
//         for (int i = 0; i < 6; i++) {
//             for (int j = 0; j < 6; j++) {
//                 if (matriks[i][j] == 0) {
//                     System.out.print(" . ");
//                 } else if (matriks[i][j] == -1) {
//                     System.out.print(" X ");
//                 } else {
//                     System.out.print(String.format("%2d ", matriks[i][j]));
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
//                 matriks[i][j] = angka++;
//             }
//         }
//         print(matriks);

//         int input = 0;
//         while (input != -999) {
//             Scanner sc = new Scanner(System.in);
//             System.out.print("Masukkan angka: ");
//             input = sc.nextInt();
//             if (input != -999) {
//                 boolean found = false;
//                 for (int i = 0; i < 6; i++) {
//                     for (int j = 0; j < 6; j++) {
//                         if (matriks[i][j] == input) {
//                             if (matriks[i][j] != -1) {
//                                 matriks[i][j] = -1;
//                             } else {
//                                 System.out.println("Angka tidak ditemukan! Barang tidak dapat ditempatkan pada posisi berikut!");
//                             }
//                             found = true;
//                             break;
//                         }
//                     }
//                     if (found) {
//                         break;
//                     }
//                 }
//                 if (!found) {
//                     System.out.println("Angka tidak ditemukan! Barang tidak dapat ditempatkan pada posisi berikut!");
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
                if (matriks[i][j] == 0) {
                    System.out.print(" . ");
                } else if (matriks[i][j] == -1) {
                    System.out.print(" X ");
                } else {
                    System.out.print(String.format("%2d ", matriks[i][j]));
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
                matriks[i][j] = angka++;
            }
        }
        print(matriks);

        int input = 0;
        while (input != -999) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Masukkan angka: ");
            input = sc.nextInt();
            if (input != -999) {
                if (input < 1 || input > 36) {
                    System.out.println("Input salah, silakan coba kembali");
                    continue;
                }
                boolean found = false;
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (matriks[i][j] == input) {
                            if (matriks[i][j] != -1) {
                                matriks[i][j] = -1;
                            } else {
                                System.out.println("Angka tidak ditemukan! Barang tidak dapat ditempatkan pada posisi berikut!");
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

