import java.util.ArrayList;

public class Masakan extends Objek {
    private ArrayList<BahanMakanan> bahanMakanan;
    private int kekenyangan;

    private static String[] namaMakanan = {
        "Nasi Ayam", 
        "Nasi Kari",
        "Susu Kacang",
        "Tumis Sayur",
        "Bistik"
    };

    public static int[] kekenyangans = {
            5,
            4,
            8,
            15,
            2
    };

    public static int[] kuantitasInventory =
    {
        0,
        0,
        0,
        0,
        0
    };

    public boolean cekMasakan(String masakan) {
        int indeksBarang = namaMasakan(masakan);
        if (kuantitasInventory[indeksBarang] > 0) {
            return true;
        } else {
            System.out.println("Barang " + masakan + " tidak ada dalam inventory.");
            return false;
        }
    }

    public Masakan(int index) {
        super(namaMakanan[index]);
        kekenyangan = kekenyangans[index];
    }

    public int namaMasakan(String namaMakanan)
    {
        String[] daftarNamaBahanMakanan = {"Nasi Ayam", "Nasi Kari", "Susu Kacang", "Tumis Sayur", "Bistik"};
        for (int i = 0; i < daftarNamaBahanMakanan.length; i++){
            // System.out.println("namaMakanan: " + i + " " + namaMakanan);
            if (daftarNamaBahanMakanan[i].equals(namaMakanan)){
                return i;
            }
        }
        return -1;
    }

    public void tambahMakanan (String namaMakanan)
    {   
        System.out.println("namaMakanan 1: " + namaMakanan);
        int indeksMakanan = namaMasakan(namaMakanan);
        kuantitasInventory[indeksMakanan] += 1;
    }

    public void useMakanan (String namaMakanan)
    {   
        System.out.println("namaMakanan 1: " + namaMakanan);
        int indeksMakanan = namaMasakan(namaMakanan);
        kuantitasInventory[indeksMakanan]--;
    }

    private int hitungKekenyangan(ArrayList<BahanMakanan> bahanMakanan) {
        int totalKekenyangan = 0;
        Sim sim = new Sim(nama, nama, totalKekenyangan, totalKekenyangan, totalKekenyangan, nama, totalKekenyangan);
        for (BahanMakanan bahan : bahanMakanan) {
            totalKekenyangan += sim.getKekenyangan();
        }
        // Pengganda untuk menyesuaikan kekenyangan
        double pengganda = 0.8;
        return (int) Math.round(totalKekenyangan * pengganda);
    }
    
    public String getNamaMakanan() {
        return getNama();
    }

    public ArrayList<BahanMakanan> getBahanMakanan() {
        return bahanMakanan;
    }

    public int getKekenyangan() {
        return kekenyangan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.nama = namaMakanan;
    }

    public void setBahanMakanan(ArrayList<BahanMakanan> bahanMakanan) {
        this.bahanMakanan = bahanMakanan;
        this.kekenyangan = hitungKekenyangan(bahanMakanan);
    }

    public void showJenisMakanan() {
        System.out.print("Nama Masakan: " + getNamaMakanan() + ", Bahan: ");
        for (int i = 0; i < bahanMakanan.size(); i++) {
            System.out.print(bahanMakanan.get(i).getNama());
            if (i < bahanMakanan.size() - 1) {
                System.out.print("+");
            }
        }
        System.out.println(", Kekenyangan: " + kekenyangan);
    }

    public void printMakanan()
    {
        // System.out.println("Daftar Bahan Makanan yang dimiliki:");
        for (int i = 0; i < kuantitasInventory.length; i++){
            if (kuantitasInventory[i] > 0)
            {
                System.out.println(namaMakanan[i] + " " + kuantitasInventory[i] + " buah");
            }
        }
    }

    // public static void main(String[] args) {
    //     ArrayList<BahanMakanan> listBahanMakanan = new Masakan();

    //     ArrayList<BahanMakanan> nasiAyamBahan = new ArrayList<>();
    //     nasiAyamBahan.add(listBahanMakanan.get(0)); // Nasi
    //     nasiAyamBahan.add(listBahanMakanan.get(2)); // Ayam
    //     Masakan nasiAyam = new Masakan("Nasi Ayam", nasiAyamBahan);

    //     ArrayList<BahanMakanan> nasiKariBahan = new ArrayList<>();
    //     nasiKariBahan.add(listBahanMakanan.get(0)); // Nasi
    //     nasiKariBahan.add(listBahanMakanan.get(1)); // Kentang
    //     nasiKariBahan.add(listBahanMakanan.get(4)); // Wortel
    //     nasiKariBahan.add(listBahanMakanan.get(3)); // Sapi
    //     Masakan nasiKari = new Masakan("Nasi Kari", nasiKariBahan);

    //     ArrayList<BahanMakanan> susuKacangBahan = new ArrayList<>();
    //     susuKacangBahan.add(listBahanMakanan.get(7)); // Susu
    //     susuKacangBahan.add(listBahanMakanan.get(6)); // Kacang
    //     Masakan susuKacang = new Masakan("Susu Kacang", susuKacangBahan);

    //     ArrayList<BahanMakanan> tumisSayurBahan = new ArrayList<>();
    //     tumisSayurBahan.add(listBahanMakanan.get(4)); // Wortel
    //     tumisSayurBahan.add(listBahanMakanan.get(5)); // Bayam
    //     Masakan tumisSayur = new Masakan("Tumis Sayur", tumisSayurBahan);

    //     ArrayList<BahanMakanan> bistikBahan = new ArrayList<>();
    //     bistikBahan.add(listBahanMakanan.get(1)); // Kentang
    //     bistikBahan.add(listBahanMakanan.get(3)); // Sapi
    //     Masakan bistik = new Masakan("Bistik", bistikBahan);

    //     nasiAyam.showJenisMakanan();
    //     nasiKari.showJenisMakanan();
    //     susuKacang.showJenisMakanan();
    //     tumisSayur.showJenisMakanan();
    //     bistik.showJenisMakanan();
    // }
}