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
        
        
        int panjang = 0;
        int lebar = 0;
        

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
        
    
                if (posisi.equalsIgnoreCase("Horizontal")) {
                    panjang = barang.getlebar();
                    lebar = barang.getpanjang();
                } else if (posisi.equalsIgnoreCase("Vertikal")){
                    panjang = barang.getpanjang();
                    lebar = barang.getlebar();
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

    public ArrayList<Ruangan> getRuanganTetangga(){
        return this.ruanganTetangga;
    }

    public static void main(String[] args) {
        Ruangan ruangan = new Ruangan("Kamar Tidur", 6, 6);
        ruangan.tampilkanRuangan();
        ruangan.tambahBarang("Kasur Single");
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