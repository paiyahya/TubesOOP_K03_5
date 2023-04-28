import java.util.ArrayList;
import java.util.List;

public class Ruangan {
    private List<Barang> daftarBarang;
    private int panjangRuangan;
    private int lebarRuangan;

    public Ruangan(int panjangRuangan, int lebarRuangan) {
        this.panjangRuangan = panjangRuangan;
        this.lebarRuangan = lebarRuangan;
        this.daftarBarang = new ArrayList<Barang>();
    }

    public int getPanjangRuangan() {
        return panjangRuangan;
    }

    public int getLebarRuangan() {
        return lebarRuangan;
    }

    public int getPosisiX() {
        return 0;
    }

    public int getPosisiY() {
        return 0;
    }

    public void setPosisi(int x, int y) {
    }

    public String getNamaRuangan() {
        return null;
    }

    public List<Barang> getDaftarBarang() {
        return daftarBarang;
    }

    public void setDaftarBarang(List<Barang> daftarBarang) {
        this.daftarBarang = daftarBarang;
    }

    public void addObjek(Barang barang) {
        if (daftarBarang.size() < panjangRuangan * lebarRuangan) {
            daftarBarang.add(barang);
        } else {
            System.out.println("Ruangan penuh!");
        }
    }

    public void removeObjek(Barang barang) {
        daftarBarang.remove(barang);
    }

    public void viewRuangan() {
        for (int i = 0; i < panjangRuangan; i++) {
            for (int j = 0; j < lebarRuangan; j++) {
                boolean found = false;
                for (Barang barang : daftarBarang) {
                    if (barang.getPosisiX() == i && barang.getPosisiY() == j) {
                        System.out.print(barang.getNama() + " ");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    // public static void main(String[] args) {
    //     Ruangan ruangan = new Ruangan(6, 6);
    //     ruangan.viewRuangan();
    //     ruangan.addObjek();
    //     World world = new World(64, 64);
    //     world.tambahRumah("Rumah 1", new Rumah(6, 6));
    //     world.tambahRumah("Rumah 2", new Rumah(12, 6));
    //     world.tambahRumah("Rumah 3", new Rumah(18, 6));
    //     // world.printWorld();
    //     // world.printRumah();
    //     // world.cekRumah(null);
    //     world.hapusRumah("Rumah 1");
    //     world.tambahRumah("Rumah 4", new Rumah(63, 63));
    //     world.printWorld();
    //     world.printRumah();
    // }
}