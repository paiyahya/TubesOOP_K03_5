//import java.util.ArrayList;

public class BahanMakanan extends Objek {
    public String[] bahanMakanan;
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
    private static int[] kekenyangans = {
            5,
            4,
            8,
            15,
            2,
            2,
            2,
            1
    };

    static int[] kuantitasInventory =
    {
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
    };

    private int harga;
    private int kekenyangan;

    public BahanMakanan(int index) {
        super(namaBahanMakanan[index]);
        harga = hargas[index];
        kekenyangan = kekenyangans[index];
    }

    private int namaBahanMakanan(String bahanMakanan)
    {
        String[] daftarNamaBahanMakanan = {"Nasi", "Kentang", "Ayam", "Sapi", "Wortel", "Bayam", "Kacang", "Susu"};
        for (int i = 0; i < daftarNamaBahanMakanan.length; i++){
            if (daftarNamaBahanMakanan[i].equals(bahanMakanan)){
                return i;
            }
        }

        return -1;
    }

    public void tambahBahanMakanan (String bahanMakanan)
    {
        int indeksBahanMakanan = namaBahanMakanan(bahanMakanan);
        kuantitasInventory[indeksBahanMakanan] += 1;
    }

    public void hapusBahanMakanan(String bahanMakanan)
    {
        int indeksBahanMakanan = namaBahanMakanan(bahanMakanan);
        kuantitasInventory[indeksBahanMakanan] -= 1;
    }

    public void printBahanMakanan()
    {
        // System.out.println("Daftar Bahan Makanan yang dimiliki:");
        for (int i = 0; i < kuantitasInventory.length; i++){
            if (kuantitasInventory[i] > 0)
            {
                System.out.println(namaBahanMakanan[i] + " " + kuantitasInventory[i] + " buah");
            }
        }
    }

    public String getBahanMakanan(int index) {
        return namaBahanMakanan[index];
    }

    public int getHarga() {
        return harga;
    }

    public int getKekenyangan() {
        return kekenyangan;
    }

//    public static ArrayList<BahanMakanan> inisialisasiBahanMakanan() {
//        ArrayList<BahanMakanan> listBahanMakanan = new ArrayList<>();
//        for (int i = 0; i < namaBahanMakanan.length; i++) {
//            listBahanMakanan.add(new BahanMakanan(i));
//        }
//        return listBahanMakanan;
//    }

//    public static void tampilkanBahanMakanan(ArrayList<BahanMakanan> listBahanMakanan) {
//        System.out.println("Daftar Bahan Makanan yang dimiliki:");
//        for (BahanMakanan bahanMakanan : listBahanMakanan) {
//            System.out.println("Nama Bahan Makanan: " + bahanMakanan.getBahanMakanan() + ", Harga: " + bahanMakanan.getHarga() + ", Kekenyangan: " + bahanMakanan.getKekenyangan());
//        }
//    }

 //   public static void main(String[] args) {
 //       ArrayList<BahanMakanan> listBahanMakanan = inisialisasiBahanMakanan();
 //       tampilkanBahanMakanan(listBahanMakanan);
//    }
public static void main(String[] args) {
    BahanMakanan bahanMakanan = new BahanMakanan(5);
    bahanMakanan.tambahBahanMakanan("Wortel");
    bahanMakanan.tambahBahanMakanan("Wortel");
    bahanMakanan.tambahBahanMakanan("Wortel");
    bahanMakanan.tambahBahanMakanan("Bayam");
    bahanMakanan.tambahBahanMakanan("Kacang");
    bahanMakanan.printBahanMakanan();
    }
}