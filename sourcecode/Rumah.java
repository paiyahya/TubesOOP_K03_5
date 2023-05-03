import java.util.ArrayList;
import java.util.List;

public class Rumah {
    private int x;
    private int y;
    // private Ruangan ruanganUtama;
    private String namaRuangan;
    private List<Ruangan> listRuanganRumah;

    public Rumah(int x, int y) {
        this.x = x;
        this.y = y;
        this.listRuanganRumah = new ArrayList<>();
        // Membuat ruangan pertama berukuran 6x6
        Ruangan ruanganPertama = new Ruangan(6, 6);
        listRuanganRumah.add(ruanganPertama);
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
    
    public List<Ruangan> getListRuanganRumah() {
        return listRuanganRumah;
    }

    public void tambahRuangan(String namaRuangan, int x, int y) {
        // Menambahkan ruangan baru ke dalam listRuanganRumah
        listRuanganRumah.add(namaRuangan);
        Ruangan ruangan = new Ruangan("Kamar Tidur", 6, 6);

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