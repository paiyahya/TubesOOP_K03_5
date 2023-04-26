import java.util.ArrayList;
import java.util.List;

class Rumah extends Ruangan {
    private int x;
    private int y;
    private List<Ruangan> daftarRuangan;
    private boolean[][] matriksRumah;

    public Rumah(int x, int y) {
        this.x = x;
        this.y = y;
        daftarRuangan = new ArrayList<>();
        matriksRumah = new boolean[6][6];
        // Set semua sel dalam matriksRumah ke false (kosong)
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matriksRumah[i][j] = false;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean isRuanganAvailable(int x, int y) {
        return !matriksRumah[x][y];
    }

    public List<Ruangan> getDaftarRuangan() {
        return daftarRuangan;
    }

    public void tambahRuangan(Ruangan ruangan, int x, int y) {
        if (isRuanganAvailable(x, y)) {
            daftarRuangan.add(ruangan);
            ruangan.setPosisi(x, y);
            // Set sel dalam matriksRumah yang ditempati oleh ruangan ke true
            for (int i = x; i < x + ruangan.getPanjangRuangan(); i++) {
                for (int j = y; j < y + ruangan.getLebarRuangan(); j++) {
                    matriksRumah[i][j] = true;
                }
            }
        } else {
            System.out.println("Ruangan tidak dapat ditambahkan, posisi telah ditempati.");
        }
    }

    public void viewRumah() {
        System.out.println("Posisi: (" + x + ", " + y + ")");
        System.out.println("Daftar Ruangan: " + daftarRuangan);
        System.out.println("Matriks Rumah: ");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(matriksRumah[i][j] ? "x" : ".");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}