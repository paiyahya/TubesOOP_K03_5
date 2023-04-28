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
        "Jam"
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
        10
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
        "Melihat waktu"
    };
    private static int[] kuantitas =
    {
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
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
        String[] daftarNamaBarang = {"Kasur Single", "Kasur Queen Size", "Kasur King Size", "Toilet", "Kompor Gas", "Kompor Listrik", "Meja dan Kursi", "Jam"};
        for (int i = 0; i < daftarNamaBarang.length; i++) {
            if (daftarNamaBarang[i].equals(barang)) {
                return i; 
            }
        }
        
        return -1;
    }

    public void tambahBarang(String barang) {
        int indeksBarang = namaBarang(barang);
        kuantitas[indeksBarang] += 1;
    }

    public void printBarang() {
        System.out.println("Daftar Barang yang dimiliki");
        for (int i = 0; i < kuantitas.length; i++) {
            if (kuantitas[i] > 0) {
                System.out.println(namaBarang[i] + ": " + kuantitas[i]);
            }
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

    public static String[] getNames(){
        return namaBarang;
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
    //     barang.printBarang();
        
    // }
}
