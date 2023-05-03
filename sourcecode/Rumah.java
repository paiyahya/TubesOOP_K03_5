import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rumah {
    private int x;
    private int y;
    private int panjangRumah;
    private int lebarRumah;
    // private Ruangan ruanganUtama;
    private String namaRuangan;
    private static List<Ruangan> listRuanganRumah;

    public Rumah(int x, int y) {
        this.x = x;
        this.y = y;
        this.listRuanganRumah = new ArrayList<>();
        setDefaultRuangan();
        // Membuat ruangan pertama berukuran 6x6
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getNamaRuangan(){
        return namaRuangan;
    }

    public void setPanjangRumah(int panjangRumah){
        this.panjangRumah = panjangRumah;
    }

    public void setLebarRumah(int lebarRumah){
        this.lebarRumah = lebarRumah;
    }
    
    public int getPanjangRumah() {
        return panjangRumah;
    }

    public int getLebarRumah(){
        return lebarRumah;
    }

    public static List<Ruangan> getListRuanganRumah() {
        return listRuanganRumah;
    }

    // public void tambahRuangan(String namaRuangan, int x, int y) {
    //     // Menambahkan ruangan baru ke dalam listRuanganRumah
    //     Ruangan ruangan = new Ruangan(namaRuangan, 6, 6);
    //     listRuanganRumah.add(ruangan);
    // }

    public static void printListRuanganRumah(){
        int i = 1;
        
        System.out.println("Daftar ruangan yang ada di rumah: ");
         for(Ruangan ruangan : listRuanganRumah){
            System.out.println(i+". "+ruangan.getNamaRuangan());
            i++;
         }
    }

    public static void setRuangan(){
        String namaRuangan;
        System.out.print("Masukkan nama ruangan : ");
        Scanner scan2 = new Scanner(System.in);
        namaRuangan = scan2.nextLine();
        Ruangan ruanganPertama = new Ruangan(namaRuangan,6, 6);
        getListRuanganRumah().add(ruanganPertama);
    }

    public void setDefaultRuangan(){
        Ruangan ruanganPertama = new Ruangan("Kamar",6, 6);
        getListRuanganRumah().add(ruanganPertama);
    }

    public void PilihRuangan(){
        int pilihan;
        System.out.print("Pilih ruangan yang ingin diakses : ");
        Scanner scan3 = new Scanner(System.in);
        pilihan = scan3.nextInt();
        getListRuanganRumah().get(pilihan-1).tampilkanRuangan();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan X: ");
        int x = scan.nextInt();
        System.out.print("Masukkan Y: ");
        int y = scan.nextInt();
        Rumah rumah = new Rumah(x, y);
        setRuangan();
        // Ruangan ruangan = new Ruangan("Kamar Tidur", 6, 6);
        // getListRuanganRumah().add(ruangan);
        rumah.printListRuanganRumah();
        rumah.PilihRuangan();
        // ruangan.tambahBarang("Kasur Single");
        // ruangan.tampilkanRuangan();
        // ruangan.tambahBarang("Meja dan Kursi");
        // ruangan.tampilkanRuangan();
        // ruangan.tambahBarang("Jam");
        // ruangan.tampilkanRuangan();
        // ruangan.printBarangRuangan();
    } 
}
// import java.util.ArrayList;
// import java.util.List;

// public class Rumah {
//     private int x;
//     private int y;
//     private Ruangan ruanganUtama;
//     private String namaRuangan;
//     private List<Ruangan> listRuanganRumah;

//     public Rumah(int x, int y) {
//         this.x = x;
//         this.y = y;
//         this.ruanganUtama = new Ruangan(namaRuangan, x, y);
//         this.listRuanganRumah = new ArrayList<>();
//         listRuanganRumah.add(ruanganUtama);
//     }

//     public int getX() {
//         return x;
//     }

//     public int getY() {
//         return y;
//     }

//     public String getNamaRuangan(){
//         return namaRuangan;
//     }

//     public List<Ruangan> getListRuanganRumah() {
//         return listRuanganRumah;
//     }

//     public void tambahRuangan(Ruangan ruanganBaru) {
//         // Sambungkan ruangan baru dengan ruangan utama
//         ruanganUtama.sambungkanRuangan(ruanganBaru);
//         // Tambahkan ruangan baru ke list ruangan rumah
//         listRuanganRumah.add(ruanganBaru);
//         // Gantikan ruangan utama dengan ruangan baru
//         ruanganUtama = ruanganBaru;
//     }

//     public static void main(String[] args) {
//         // World world = new World(64, 64);
    
//         // Membuat beberapa rumah
//         Rumah rumah1 = new Rumah(6, 6);
//         // Rumah rumah2 = new Rumah(12, 6);
//         // Rumah rumah3 = new Rumah(18, 6);
    
//             // Menambahkan rumah ke world
//         // world.tambahRumah("Rumah 1", rumah1);
//         // world.tambahRumah("Rumah 2", rumah2);
//         // world.tambahRumah("Rumah 3", rumah3);
    
//             // Menampilkan informasi rumah dan world
//         // System.out.println("Informasi Rumah di World:");
//         // world.printRumah();
//         // System.out.println();

    
//             // Menambahkan ruangan ke rumah1
//         rumah1.tambahRuangan(new Ruangan("Kamar Tidur", 6, 6));
//         rumah1.tambahRuangan(new Ruangan("Kamar Mandi", 6, 6));
                
//                 // Menampilkan informasi tentang rumah1 dan ruangan yang ada di dalamnya
//         System.out.println("Informasi Ruangan di Rumah 1:");
//         for (Ruangan ruangan : rumah1.getListRuanganRumah()) {
//             System.out.println("Ruangan: " + ruangan.getNamaRuangan() + " Ukuran: " + ruangan.getPanjangRuangan() + "x" + ruangan.getLebarRuangan());
//             }
//         }
//     }