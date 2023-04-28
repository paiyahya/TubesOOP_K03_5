public class BahanMakanan extends Objek {
    private int harga;
    private int kekenyangan;

    private static String[] namaBahanMakanan = {
        "Nasi",
        "Kentang",
        "Ayam",
        "Sapi",
        "Wortel",
        "Bayam",
        "Kacang",
        "Susu"
    };

    private static int[] hargas = {
        5,
        3,
        10,
        12,
        3,
        3,
        2,
        2
    };

    private static int[] kekenyanganValues = {
        5,
        4,
        8,
        15,
        2,
        2,
        2,
        1
    };

    public BahanMakanan(int index) {
        super(namaBahanMakanan[index]);
        harga = hargas[index];
        kekenyangan = kekenyanganValues[index];
    }

    public int getHarga() {
        return harga;
    }

    public int getKekenyangan() {
        return kekenyangan;
    }

    public void masakBahanMakanan() {
        System.out.println("Memasak bahan makanan: " + getNama());
    }

    public static String[] getNamaBahanMakanan() {
        return namaBahanMakanan;
    }

    public static int[] getHargas() {
        return hargas;
    }

    public static int[] getKekenyanganValues() {
        return kekenyanganValues;
    }

    public static void main(String[] args) {
        BahanMakanan[] bahanMakanans = new BahanMakanan[namaBahanMakanan.length];
        for (int i = 0; i < namaBahanMakanan.length; i++) {
            bahanMakanans[i] = new BahanMakanan(i);
        }

        System.out.println("Daftar Bahan Makanan:");
        for (BahanMakanan bahanMakanan : bahanMakanans) {
            System.out.println("Nama Bahan Makanan: " + bahanMakanan.getNama() + ", Harga: " + bahanMakanan.getHarga() + ", Kekenyangan: " + bahanMakanan.getKekenyangan());
        }
    }
}