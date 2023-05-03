import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ruangan {
    private String namaRuangan;
    private char[][] matriksRuangan;
    private List<Barang> daftarBarangRuangan;
    private int panjangRuangan;
    private int lebarRuangan;
    private ArrayList<Ruangan> ruanganTetangga;


    public Ruangan(String namaRuangan, int x, int y) {
        this.namaRuangan = namaRuangan;
        matriksRuangan = new char[6][6];
        daftarBarangRuangan = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matriksRuangan[i][j] = '-';
            }
        }

	}

	public Ruangan(int i, int j) {
	}

	public int getPosisiX() {
        return 0;
    }

    public int getPosisiY() {
        return 0;
    }

    public String getNamaRuangan(){
        return namaRuangan;
    }

    public int getPanjangRuangan(){
        return panjangRuangan;
    }

    public int getLebarRuangan(){
        return lebarRuangan;
    }

    public boolean tambahBarang(String namaBarang) {
        int index = 999;
        switch (namaBarang) {
            case "Kasur Single":
                index = 0;
                break;
            case "Kasur Queen Size":
                index = 1;
                break;
            case "Kasur King Size":
                index = 2;
                break;
            case "Toilet":
                index = 3;
                break;
            case "Kompor Gas":
                index = 4;
                break;
            case "Kompor Listrik":
                index = 5;
                break;
            case "Meja dan Kursi":
                index = 6;
                break;
            case "Jam":
                index = 7;
                break;
            case "Treadmill":
                index = 8;
                break;
            case "Gitar":
                index = 9;
                break;
            case "Sapu":
                index = 10;
                break;
            case "Tv":
                index = 11;
                break;
            case "Sajadah":
                index = 12;
                break;
            case "Buku":
                index = 13;
                break;
            case "Baju":
                index = 14;
                break;
            default:

                break;
        }
        Barang barang = new Barang(index);
        

        // if (index == -1) {
        //     System.out.println("Nama barang tidak ditemukan!");
        //     return false;
        //}
        
        int panjang = barang.getpanjang();
        int lebar = barang.getlebar();

        // pengecekan posisi (horizontal/vertikal)
        

        //input lokasi
        Scanner scan = new Scanner(System.in);
        int x = 0; 
        int y = 0;
        String posisi = "";
        Boolean input = false;
        do {
            try {
                Boolean tabrakan = false;
                System.out.print("Masukkan posisi (x,y): ");
                String lokasi = scan.nextLine();
                String[] lokasiSplit = lokasi.split(",");
                x = Integer.parseInt(lokasiSplit[0]);
                y = Integer.parseInt(lokasiSplit[1]);
                System.out.print("Masukkan posisi (Horizontal/Vertikal): ");
                posisi = scan.nextLine();
                // if (posisi.equalsIgnoreCase("Horizontal") || posisi.equalsIgnoreCase("Vertikal")) {
                //     input = true;
                // } else {
                //     input = false;
                //     System.out.println("Input posisi tidak valid!");
                // }
    
                if (posisi.equalsIgnoreCase("Horizontal")) {
                    int temp = panjang;
                    panjang = lebar;
                    lebar = temp;
                }
                
                // pengecekan apakah posisi valid
                if (x < 0 || x + panjang > 6 || y < 0 || y + lebar > 6) {
                    System.out.println("Input lokasi tidak valid!");
                    continue;
                }
        
                // pengecekan tabrakan dengan barang lain
                for (int i = x; i < x + panjang; i++) {
                    for (int j = y; j < y + lebar; j++) {
                        if (matriksRuangan[i][j] != '-') {
                            tabrakan = true;
                        }
                    }
                }

                if (tabrakan) {
                    System.out.println("Barang tidak dapat diletakkan pada posisi berikut. Silakan coba lagi!");
                }

                if ((x >= 0 && x + panjang <= 6) && (y >= 0 && y + lebar <= 6) && !tabrakan) {
                    input = true;
                }
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Indeks tidak valid");
            }
        } while (!input);
        
        // menambahkan barang ke matriks ruangan
        for (int i = x; i < x + panjang; i++) {
            for (int j = y; j < y + lebar; j++) {
                matriksRuangan[i][j] = barang.getSymbol(namaBarang);
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

    public void printBarangRuangan(){
        int i = 1;
        
        System.out.println("Barang yang Ada di Ruangan: ");
         for(Barang barang : daftarBarangRuangan){
            System.out.println(i+". "+barang.getNama());
            i++;
         }
        
    }

    public void addRoom(int idx, Ruangan ruangan) {
        ruanganTetangga.add(idx, ruangan);
    }

    public ArrayList getRuanganTetangga(){
        return this.ruanganTetangga;
    }

    public static void main(String[] args) {
        Ruangan ruangan = new Ruangan("Kamar Tidur", 6, 6);
        ruangan.tampilkanRuangan();
        ruangan.tambahBarang("Kasur Single");
        ruangan.tampilkanRuangan();
        ruangan.tambahBarang("Meja dan Kursi");
        ruangan.tampilkanRuangan();
        ruangan.tambahBarang("Jam");
        ruangan.tampilkanRuangan();
        ruangan.printBarangRuangan();
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