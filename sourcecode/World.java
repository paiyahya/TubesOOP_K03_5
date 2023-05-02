import java.util.HashMap;
import java.util.Map;



public class World {
    private static final int panjang = 64;
    private static final int lebar = 64;
    private HashMap<String, Rumah> daftarRumah = new HashMap<>();

    public World(int panjang, int lebar) {
    }

    public HashMap<String, Rumah> getDaftarRumah() {
        return daftarRumah;
    }

    public void tambahRumah(String nama, Rumah rumah) {
        daftarRumah.put(nama, rumah);
        Barang barang = new Barang(0);
        barang.barangRuangan("Kasur Single");
        barang.barangRuangan("Toilet");
        barang.barangRuangan("Kompor Gas");
        barang.barangRuangan("Meja dan Kursi");
        barang.barangRuangan("Jam");
    }

    public void hapusRumah(String nama) {
        daftarRumah.remove(nama);
    }

    public boolean cekRumah(Rumah posisi) {
        for (Map.Entry<String, Rumah> entry : daftarRumah.entrySet()) {
            if (entry.getValue().getX() == posisi.getX() && entry.getValue().getY() == posisi.getY()) {
                // return false if the given position matches the position of any existing house
                return false;
            }
        }
        // return true if no existing house has the same position as the given position
        return true;
    }

    public void printRumah() {
        for (Map.Entry<String, Rumah> entry : daftarRumah.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getX() + "," + entry.getValue().getY());
        }
    }

    public void printWorld() {
        for (int i = 0; i < panjang; i++) {
            for (int j = 0; j < lebar; j++) {
                boolean isRumah = false;
                for (Map.Entry<String, Rumah> entry : daftarRumah.entrySet()) {
                    if (entry.getValue().getX() == i && entry.getValue().getY() == j) {
                        System.out.print("R");
                        isRumah = true;
                        break;
                    }
                }
                if (!isRumah) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // public static void main(String[] args) {
    //     World world = new World(6, 6);
    //     world.tambahRumah("Rumah 1", new Rumah(6, 6));
    //     world.tambahRumah("Rumah 2", new Rumah(12, 6));
    //     world.tambahRumah("Rumah 3", new Rumah(18, 6));
    //     world.printWorld();
    //     world.printRumah();
    //     // world.cekRumah(null);
    //     world.hapusRumah("Rumah 1");
    //     world.tambahRumah("Rumah 4", new Rumah(63, 63));
    //     world.printWorld();
    //     world.printRumah();
    // }
}