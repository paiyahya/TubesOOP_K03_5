import java.util.ArrayList;
import java.util.List;

public class Ruangan {
    private String namaRuangan;
    private char[][] matriksRuangan;
    private List<Barang> daftarBarangRuangan;

    public Ruangan(String namaRuangan) {
        this.namaRuangan = namaRuangan;
        matriksRuangan = new char[6][6];
        daftarBarangRuangan = new ArrayList<>();

        // mengisi matriks ruangan dengan karakter '-'
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matriksRuangan[i][j] = '-';
            }
        }
    }
    public int getPosisiX() {
        return 0;
    }

    public int getPosisiY() {
        return 0;
    }

    public boolean tambahBarang(int x, int y, String namaBarang, String posisi) {
        int index = Barang.namaBarang(namaBarang);
        if (index == -1) {
            System.out.println("Nama barang tidak ditemukan!");
            return false;
        }
        
        Barang barang = new Barang(index);
        int panjang = barang.getpanjang();
        int lebar = barang.getlebar();

        // pengecekan posisi (horizontal/vertikal)
        if (posisi.equalsIgnoreCase("vertikal")) {
            int temp = panjang;
            panjang = lebar;
            lebar = temp;
        }

        // pengecekan apakah posisi valid
        if (x < 0 || x + panjang > 6 || y < 0 || y + lebar > 6) {
            System.out.println("Input lokasi tidak valid!");
            return false;
        }

        // pengecekan tabrakan dengan barang lain
        for (int i = x; i < x + panjang; i++) {
            for (int j = y; j < y + lebar; j++) {
                if (matriksRuangan[i][j] != '-') {
                    System.out.println("Barang tidak dapat diletakkan pada posisi berikut. Silakan coba lagi!");
                    return false;
                }
            }
        }

        // menambahkan barang ke matriks ruangan
        for (int i = x; i < x + panjang; i++) {
            for (int j = y; j < y + lebar; j++) {
                matriksRuangan[i][j] = barang.getSymbol();
            }
        }

        // menambahkan barang ke daftarBarangRuangan
        daftarBarangRuangan.add(barang);

        return true;
    }

    public void tampilkanRuangan() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(matriksRuangan[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Ruangan ruangan = new Ruangan("Kamar Tidur");
        ruangan.tambahBarang(0, 0, "Kasur Single", "horizontal");
        ruangan.tambahBarang(2, 0, "Meja dan Kursi", "vertikal");
        ruangan.tambahBarang(4, 4, "Jam", "horizontal");
        ruangan.tampilkanRuangan();
    }
}

// import java.util.ArrayList;
// import java.util.List;

// public class Ruangan {
//     private List<Barang> daftarBarang;
//     private int panjangRuangan;
//     private int lebarRuangan;
//     private String namaRuangan;

//     public Ruangan(int panjangRuangan, int lebarRuangan, String namaRuangan) {
//         this.panjangRuangan = panjangRuangan;
//         this.lebarRuangan = lebarRuangan;
//         this.daftarBarang = new ArrayList<Barang>();
//         this.namaRuangan = namaRuangan;
//     }

//     public int getPanjangRuangan() {
//         return panjangRuangan;
//     }

//     public int getLebarRuangan() {
//         return lebarRuangan;
//     }

//     public int getPosisiX() {
//         return 0;
//     }

//     public int getPosisiY() {
//         return 0;
//     }

//     public void setPosisi(int x, int y) {
//     }

//     public String getNamaRuangan() {
//         return namaRuangan;
//     }

//     public List<Barang> getDaftarBarang() {
//         return daftarBarang;
//     }

//     public void setDaftarBarang(List<Barang> daftarBarang) {
//         this.daftarBarang = daftarBarang;
//     }

//     public void addObjek(Barang barang) {
//         if (daftarBarang.size() < panjangRuangan * lebarRuangan) {
//             daftarBarang.add(barang);
//         } else {
//             System.out.println("Ruangan penuh!");
//         }
//     }

//     public void removeObjek(Barang barang) {
//         daftarBarang.remove(barang);
//     }

//     public void viewRuangan() {
//         for (int i = 0; i < panjangRuangan; i++) {
//             for (int j = 0; j < lebarRuangan; j++) {
//                 boolean found = false;
//                 for (Barang barang : daftarBarang) {
//                     if (barang.getPosisiX() == i && barang.getPosisiY() == j) {
//                         System.out.print(barang.getNama() + " ");
//                         found = true;
//                         break;
//                     }
//                 }
//                 if (!found) {
//                     System.out.print("- ");
//                 }
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         Rumah rumah = new Rumah(100, 100);
//         Ruangan ruangan = new Ruangan(6, 6, "Kamar Utama");
//         ruangan.viewRuangan();
//         Barang barang = new Barang(1);
//         ruangan.addObjek(barang);
//         rumah.tambahRuangan(ruangan, 0, 0);
//         // rumah.viewRumah();
//         Ruangan ruangan2 = new Ruangan(1, 1, "Kamar Tamu");
//         Barang barang2 = new Barang(2);
//         ruangan2.addObjek(barang2);
//         rumah.tambahRuangan(ruangan2, 0, 1);
//         rumah.viewRumah();

//     //     ruangan.addObjek();
//     //     World world = new World(64, 64);
//     //     world.tambahRumah("Rumah 1", new Rumah(6, 6));
//     //     world.tambahRumah("Rumah 2", new Rumah(12, 6));
//     //     world.tambahRumah("Rumah 3", new Rumah(18, 6));
//     //     // world.printWorld();
//     //     // world.printRumah();
//     //     // world.cekRumah(null);
//     //     world.hapusRumah("Rumah 1");
//     //     world.tambahRumah("Rumah 4", new Rumah(63, 63));
//     //     world.printWorld();
//     //     world.printRumah();
//     }
// }