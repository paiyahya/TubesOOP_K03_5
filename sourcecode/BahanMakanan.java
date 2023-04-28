import java.util.ArrayList;

public class BahanMakanan {
    private static String[] namaBahanMakanan = {
            "Nasi", "Kentang", "Ayam", "Sapi", "Wortel", "Bayam", "Kacang", "Susu"
    };
    private static int[] hargas = {
            5, 3, 10, 12, 3, 3, 2, 2
    };
    private static int[] kekenyangans = {
            5, 4, 8, 15, 2, 2, 2, 1
    };

    private String bahanMakanan;
    private int harga;
    private int kekenyangan;

    public BahanMakanan(int index) {
        bahanMakanan = namaBahanMakanan[index];
        harga = hargas[index];
        kekenyangan = kekenyangans[index];
    }

    public String getBahanMakanan() {
        return bahanMakanan;
    }

    public int getHarga() {
        return harga;
    }

    public int getKekenyangan() {
        return kekenyangan;
    }

    public static ArrayList<BahanMakanan> inisialisasiBahanMakanan() {
        ArrayList<BahanMakanan> listBahanMakanan = new ArrayList<>();
        for (int i = 0; i < namaBahanMakanan.length; i++) {
            listBahanMakanan.add(new BahanMakanan(i));
        }
        return listBahanMakanan;
    }

    public static void tampilkanBahanMakanan(ArrayList<BahanMakanan> listBahanMakanan) {
        System.out.println("Daftar Bahan Makanan yang dimiliki:");
        for (BahanMakanan bahanMakanan : listBahanMakanan) {
            System.out.println("Nama Bahan Makanan: " + bahanMakanan.getBahanMakanan() + ", Harga: " + bahanMakanan.getHarga() + ", Kekenyangan: " + bahanMakanan.getKekenyangan());
        }
    }

    public static void main(String[] args) {
        ArrayList<BahanMakanan> listBahanMakanan = inisialisasiBahanMakanan();
        tampilkanBahanMakanan(listBahanMakanan);
    }
}