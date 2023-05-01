import java.util.ArrayList;
import java.util.List;

class Rumah {
    private int x;
    private int y;
    private List<Ruangan> daftarRuangan;

    public Rumah(int x, int y) {
        this.x = x;
        this.y = y;
        daftarRuangan = new ArrayList<Ruangan>();
        // daftarRuangan.add(new Ruangan(6, 6, null));
    }

    // getter methods for x and y coordinates
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isRuanganAvailable(int x, int y) {
        // Cek apakah terdapat ruangan dengan koordinat (x,y) pada daftarRuangan
        for (Ruangan ruangan : daftarRuangan) {
            if (ruangan.getPosisiX() == x && ruangan.getPosisiY() == y) {
                return false;
            }
        }
        return true;
    }

    public List<Ruangan> getDaftarRuangan() {
        return daftarRuangan;
    }

    public void tambahRuangan(Ruangan ruangan, int x, int y) {
        if (isRuanganAvailable(x, y)) {
            if(daftarRuangan.size() == 0){
                daftarRuangan.add(ruangan);
                ruangan.setPosisi(x, y);
            } else{
                boolean connected = false;
                // Cek apakah ruangan baru terhubung dengan ruangan lain yang sudah ada
                for (Ruangan r : daftarRuangan) {
                    if ((r.getPosisiX() == x && r.getPosisiY() == y - 1) ||
                            (r.getPosisiX() == x && r.getPosisiY() == y + ruangan.getLebarRuangan()) ||
                            (r.getPosisiX() == x - 1 && r.getPosisiY() == y) ||
                            (r.getPosisiX() == x + ruangan.getPanjangRuangan() && r.getPosisiY() == y)) {
                        connected = true;
                        break;
                    }
                }
                if (connected) {
                    daftarRuangan.add(ruangan);
                    ruangan.setPosisi(x, y);
                } else {
                    System.out.println("Ruangan tidak dapat ditambahkan, tidak terhubung dengan ruangan lain.");
                }
            }
        } else {
            System.out.println("Ruangan tidak dapat ditambahkan, posisi telah ditempati.");
        }
    }

    public void viewRumah() {
        System.out.println("Posisi: (" + x + ", " + y + ")");
        System.out.println("Daftar Ruangan: ");
        for (Ruangan ruangan : daftarRuangan) {
            System.out.println("- " + ruangan.getNamaRuangan() + " (" + ruangan.getPanjangRuangan() + " x " + ruangan.getLebarRuangan() + ")");
        }
    }

    // public static void main(String[] args) {
    //      = new World(64, 64);
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

    public static void main(String[] args) {
        Rumah rumah = new Rumah(6, 6);
        
        Ruangan ruangan1 = new Ruangan(2, 3, "Kamar Tidur Utama");
        rumah.tambahRuangan(ruangan1, 1, 1);

        Ruangan ruangan2 = new Ruangan(2, 2, "Kamar Tidur Anak");
        rumah.tambahRuangan(ruangan2, 1, 4);

        Ruangan ruangan3 = new Ruangan(3, 2, "Ruang Tamu");
        rumah.tambahRuangan(ruangan3, 4, 1);

        rumah.viewRumah();
    }
}