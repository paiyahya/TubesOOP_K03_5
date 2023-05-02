// import java.util.Arrays;
public class Barang extends Objek {
    public String[] barang;
    
    private static String[] namaBarang =
    {
        "Kasur Single",
        "Kasur Queen Size",
        "Kasur King Size",
        "Toilet",
        "Kompor Gas",
        "Kompor Listrik",
        "Meja dan Kursi",
        "Jam",
        "Treadmill",
        "Gitar",
        "Sapu",
        "Tv",
        "Sajadah",
        "Buku",
        "Baju"
    };
    private static int[] panjangs =
    {
        4,
        4,
        5,
        1,
        2,
        1,
        3,
        1,
        3,
        1,
        1,
        2,
        1,
        1,
        1
    };
    private static int[] lebars =
    {
        1,
        2,
        2,
        1,
        1,
        1,
        3,
        1,
        1,
        1,
        1,
        1,
        1,
        1,
        1
    };
    private static int[] hargas =
    {
        50,
        100,
        150,
        50,
        100,
        200,
        50,
        10,
        200,
        30,
        5,
        150,
        5,
        10,
        5
    };
    private static String[] aksis =
    {
        "Tidur",
        "Tidur",
        "Tidur",
        "Buang air",
        "Memasak",
        "Memasak",
        "Makan",
        "Melihat waktu",
        "Olahraga",
        "Bermain musik",
        "Bersih-bersih",
        "Menonton",
        "Ibadah",
        "Membaca",
        "GantiBaju",
    };
    private static int[] kuantitasInventory =
    {
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
    };

    private static int[] kuantitasBarang =
    {
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
    };

    private int panjang;
    private int lebar;
    private int harga;
    private String aksi;
    private int x;
    private int y;

    public Barang(int index){
        super(namaBarang[index]);
        panjang = panjangs[index];
        lebar = lebars[index];
        harga = hargas[index];
        aksi = aksis[index];
    }

    private int namaBarang(String barang) {
        String[] daftarNamaBarang = {"Kasur Single", "Kasur Queen Size", "Kasur King Size", "Toilet", "Kompor Gas", "Kompor Listrik", "Meja dan Kursi", "Jam", "Treadmill", "Gitar", "Sapu", "Tv", "Sajadah", "Buku", "Baju"};
        for (int i = 0; i < daftarNamaBarang.length; i++) {
            if (daftarNamaBarang[i].equals(barang)) {
                return i; 
            }
        }

        return -1;
    }

    public void tambahBarang(String barang) {
        int indeksBarang = namaBarang(barang);
        kuantitasInventory[indeksBarang] += 1;
    }

    public void hapusBarang(String barang) {
        int indeksBarang = namaBarang(barang);
        kuantitasInventory[indeksBarang] -= 1;
    }

    public void barangRuangan(String barang) {
        int indeksBarang = namaBarang(barang);
        kuantitasBarang[indeksBarang] += 1;
    }

    public void printBarangRuangan() {
        System.out.println("Daftar Barang yang dimiliki dalam ruangan:");
        for (int i = 0; i < kuantitasBarang.length; i++) {
            if (kuantitasBarang[i] > 0) {
                System.out.println(namaBarang[i] + ": " + kuantitasBarang[i]);
            }
        }
    }

    public void printBarangInventory() {
        System.out.println("Daftar Barang yang dimiliki dalam inventory:");
        for (int i = 0; i < kuantitasInventory.length; i++) {
            if (kuantitasInventory[i] > 0) {
                System.out.println(namaBarang[i] + ": " + kuantitasInventory[i]);
            }
        }
    }

    public boolean cekBarang(String barang) {
        int indeksBarang = namaBarang(barang);
        if (kuantitasBarang[indeksBarang] > 0) {
            return true;
        } else {
            System.out.println("Barang " + barang + " tidak ada dalam ruangan.");
            return false;
        }
    }

    public int getPosisiX() {
        return x;
    }
    public int getPosisiY(){
        return y;
    }
    public int getpanjang(){
        return panjang;
    }

    public int getlebar(){
        return lebar;
    }

    public int getharga(){
        return harga;
    }

    public String getaksi(){
        return aksi;
    }

    public static String getNames(int idx){
        return namaBarang[idx];
    }

    public static int[] getpanjangs(){
        return panjangs;
    }

    public static int[] getlebars(){
        return lebars;
    }

    public static int[] gethargas(){
        return hargas;
    }

    public static String[] getaksis(){
        return aksis;
    }
    
    // public void interact(SIM SIM){
    //     switch (this.getaksi()){
    //         case "Tidur":
    //             System.out.println();
    //             System.out.println("SIM Anda sedang tidur...");
    //             System.out.println("Mood SIM Anda bertambah 30!");
    //             System.out.println("Kesehatan SIM Anda bertambah 20!");
    //             SIM.setMood(SIM.getMood() + 30);
    //             // SIM.setHealth(SIM.getHealth() + 20);
    //             break;

    //         case "Buang air":
    //             System.out.println();
    //             System.out.println("SIM Anda sedang buang air...");
    //             System.out.println("Mood SIM Anda bertambah 10!");
    //             System.out.println("Kekenyangan SIM Anda berkurang 20!");
    //             SIM.setMood(SIM.getMood() + 30);
    //             break;

    //         case "Memasak":
    //             System.out.println();
    //             System.out.println("SIM Anda sedang memasak...");
    //             System.out.println("Mood SIM Anda bertambah 10!");
    //             SIM.setMood(SIM.getMood() + 10);
    //             break;

    //         case "Makan":
    //             System.out.println();
    //             System.out.println("SIM Anda sedang makan...");
    //             System.out.println("Mood SIM Anda bertambah 10!");
    //             SIM.setMood(SIM.getMood() + 10);
    //         break;

    //         case "Melihat waktu":
    //             break;
    //     }
    // }

    // public static void main(String[] args) {
    //     Barang barang = new Barang(5);
    //     barang.getaksi();
    //     // barang.interact(null);
    //     barang.tambahBarang("Toilet");
    //     barang.tambahBarang("Toilet");
    //     barang.tambahBarang("Toilet");
    //     barang.tambahBarang("Gitar");
    //     barang.tambahBarang("Sajadah");
    //     barang.barangRuangan("Toilet");
    //     barang.barangRuangan("Treadmill");
    //     barang.printBarangInventory();
    //     barang.printBarangRuangan();
    //     barang.cekBarang("Toilet");
    //     barang.cekBarang("Buku");
    // }
}
