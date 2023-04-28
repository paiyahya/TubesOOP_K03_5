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

    public void setPanjangRuangan(int panjangRuangan) {
        this.panjangRuangan = panjangRuangan;
    }

    public void setLebarRuangan(int lebarRuangan) {
        this.lebarRuangan = lebarRuangan;
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
}