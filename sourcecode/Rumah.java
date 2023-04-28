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
        daftarRuangan.add(new Ruangan("Kamar", 6, 6));
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
}