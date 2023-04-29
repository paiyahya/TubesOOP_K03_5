import java.util.ArrayList;

public class Masakan extends Objek {
    private ArrayList<BahanMakanan> bahanMakanan;
    private int kekenyangan;

    public Masakan(String namaMakanan, ArrayList<BahanMakanan> bahanMakanan) {
        super(namaMakanan); // Memanggil konstruktor superclass Objek
        this.bahanMakanan = bahanMakanan;
        this.kekenyangan = hitungKekenyangan(bahanMakanan);
    }

    private int hitungKekenyangan(ArrayList<BahanMakanan> bahanMakanan) {
        int totalKekenyangan = 0;
        for (BahanMakanan bahan : bahanMakanan) {
            totalKekenyangan += bahan.getKekenyangan();
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
            System.out.print(bahanMakanan.get(i).getBahanMakanan());
            if (i < bahanMakanan.size() - 1) {
                System.out.print("+");
            }
        }
        System.out.println(", Kekenyangan: " + kekenyangan);
    }

    public static void main(String[] args) {
        ArrayList<BahanMakanan> listBahanMakanan = BahanMakanan.inisialisasiBahanMakanan();

        ArrayList<BahanMakanan> nasiAyamBahan = new ArrayList<>();
        nasiAyamBahan.add(listBahanMakanan.get(0)); // Nasi
        nasiAyamBahan.add(listBahanMakanan.get(2)); // Ayam
        Masakan nasiAyam = new Masakan("Nasi Ayam", nasiAyamBahan);

        ArrayList<BahanMakanan> nasiKariBahan = new ArrayList<>();
        nasiKariBahan.add(listBahanMakanan.get(0)); // Nasi
        nasiKariBahan.add(listBahanMakanan.get(1)); // Kentang
        nasiKariBahan.add(listBahanMakanan.get(4)); // Wortel
        nasiKariBahan.add(listBahanMakanan.get(3)); // Sapi
        Masakan nasiKari = new Masakan("Nasi Kari", nasiKariBahan);

        ArrayList<BahanMakanan> susuKacangBahan = new ArrayList<>();
        susuKacangBahan.add(listBahanMakanan.get(7)); // Susu
        susuKacangBahan.add(listBahanMakanan.get(6)); // Kacang
        Masakan susuKacang = new Masakan("Susu Kacang", susuKacangBahan);

        ArrayList<BahanMakanan> tumisSayurBahan = new ArrayList<>();
        tumisSayurBahan.add(listBahanMakanan.get(4)); // Wortel
        tumisSayurBahan.add(listBahanMakanan.get(5)); // Bayam
        Masakan tumisSayur = new Masakan("Tumis Sayur", tumisSayurBahan);

        ArrayList<BahanMakanan> bistikBahan = new ArrayList<>();
        bistikBahan.add(listBahanMakanan.get(1)); // Kentang
        bistikBahan.add(listBahanMakanan.get(3)); // Sapi
        Masakan bistik = new Masakan("Bistik", bistikBahan);

        nasiAyam.showJenisMakanan();
        nasiKari.showJenisMakanan();
        susuKacang.showJenisMakanan();
        tumisSayur.showJenisMakanan();
        bistik.showJenisMakanan();
    }
}