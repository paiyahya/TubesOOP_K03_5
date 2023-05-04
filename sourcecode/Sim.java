public class Sim {
    private String namaLengkap;
    private String pekerjaan;
    private int uang;
    private int kekenyangan;
    private int kesehatan;
    private String status;
    private int mood;
    private Object[] inventory;
    private static Waktu waktu = new Waktu();

    public Sim (String namaLengkap, String pekerjaan, int uang, int kekenyangan, int kesehatan, String status, int mood) {
        this.namaLengkap = namaLengkap;
        this.pekerjaan = pekerjaan;
        this.uang = 100;
        this.kekenyangan = 80;
        this.kesehatan = 80;
        this.status = status;
        this.mood = 80;    
    }
    
    public boolean isSimDead (){
        if (mood <= 0 || kekenyangan <= 0 || kesehatan <= 0){
            return true;
        } else {
            return false;
        }
    }

    public void removeBarang (Object[] inventory) {

    }

    public void beliBarang (String namabarang) {
        Barang barang = new Barang(0);
        int idx = barang.namaBarang(namabarang);
        if(idx != -1) {
            if (getUang() >= barang.hargas[idx]){
                this.uang = getUang() - barang.hargas[idx];
                waktu.doAksi(waktu.getRandomWaktu());
            }
            else {
                System.out.println("Uang tidak cukup");

            }
        }
    }

    public void doBeliMakanan(String namaMakanan) {
        BahanMakanan bahanMakanan = new BahanMakanan(0);
        int idx = bahanMakanan.namaBahanMakanan(namaMakanan);
        if(idx != -1) {
            if (getUang() >= bahanMakanan.hargas[idx]) {
                this.uang = getUang() - bahanMakanan.hargas[idx];
                waktu.doAksi(waktu.getRandomWaktu());
            }
            else {
                System.out.println("Uang tidak cukup");
            }
        }
    }

    public void doKerja (int kekenyangan, int mood) {
        this.kekenyangan = kekenyangan - 10;
        this.mood = mood - 10;
        waktu.doAksi(30);
    }

    public void doOlahraga (int kesehatan, int kekenyangan, int mood) {

        this.kesehatan = kesehatan + 5;
        this.kekenyangan = kekenyangan - 5;
        this.mood = mood + 10;
        waktu.doAksi(20);
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doTidur (int mood, int kesehatan) {
        this.mood = mood + 30;
        this.kesehatan = kesehatan + 20;
        waktu.doAksi(240);
        if (mood > 100) {
            this.mood = 100;
        }
        
        if (kesehatan > 100) {
            this.kesehatan = 100;
        }
    }

    public void doMakan (String namaMakanan) {
        waktu.doAksi(30);
        Masakan masakan = new Masakan(0);
        BahanMakanan bahanMakanan = new BahanMakanan(0);
        int idx = masakan.namaMasakan(namaMakanan);
        int idx2 = bahanMakanan.namaBahanMakanan(namaMakanan);
        if(idx != -1) {
            this.kekenyangan = getKekenyangan() + masakan.kekenyangans[idx];
        }
        else if (idx2 != -1) {
            this.kekenyangan = getKekenyangan() + bahanMakanan.kekenyangans[idx2];
        }
    }

    public void doMasak (int mood) {
        this.mood = mood + 10;

        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doMasakNasiAyam(int mood) {
        this.mood = mood + 10;
        waktu.doAksi(24);
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doMasakNasiKari(int mood) {
        this.mood = mood + 10;
        waktu.doAksi(45);
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doMasakSususKacang(int mood) {
        this.mood = mood + 10;
        waktu.doAksi(8);
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doMasakTumisSayur(int mood) {
        this.mood = mood + 10;
        waktu.doAksi(8);
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doMasakBistik(int mood) {
        this.mood = mood + 10;
        waktu.doAksi(33);
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doBerkunjung (int mood, int kekenyangan) {
        this.mood = mood + 10;
        this.kekenyangan = kekenyangan - 10;
    
        if (mood > 100) {
            this.mood = 100;
        }
        waktu.doAksi(30);
    }

    public void doBuangAir (int mood, int kekenyangan) {
        this.kekenyangan = kekenyangan - 20;
        this.mood = mood + 10;

        if (mood > 100) {
            this.mood = 100;
        }
        waktu.doAksi(10);
    }

    public void upgradeRumah (int uang) {
        waktu.doAksi(18);
    }

    public void doMandi (int mood, int kesehatan) {
        this.mood = mood + 10;
        this.kesehatan = kesehatan + 10;
        waktu.doAksi(60);
        if (mood > 100) {
            this.mood = 100;
        }
        
        if (kesehatan > 100) {
            this.kesehatan = 100;
        }
    }

    public void doMainGitar (int mood, int kekenyangan) {
        this.mood = mood + 10;
        this.kekenyangan = kekenyangan - 5;
        waktu.doAksi(30);
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doMenyapu (int kesehatan, int mood) {
        this.kesehatan = kesehatan + 5;
        this.mood = mood + 5;
        waktu.doAksi(10);
        if (mood > 100) {
            this.mood = 100;
        }
        
        if (kesehatan > 100) {
            this.kesehatan = 100;
        }
    }

    public void doMenonton (int mood, int kekenyangan) {
        this.mood = mood + 15;
        this.kekenyangan = kekenyangan - 5;
        waktu.doAksi(20);
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doIbadah (int mood, int kesehatan) {
        this.mood = mood + 20;
        this.kesehatan = kesehatan + 10;
        waktu.doAksi(20);
        if (mood > 100) {
            this.mood = 100;
        }
        
        if (kesehatan > 100) {
            this.kesehatan = 100;
        }
    }

    public void doBaca (int mood, int kekenyangan) {
        this.mood = mood + 10;
        this.kekenyangan = kekenyangan - 5;
        waktu.doAksi(30);
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doGantiBaju (int mood) {
        this.mood = mood + 15;
        waktu.doAksi(5);
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doLihatWaktu() {
        waktu.printWaktu();
    }

       public void changeSim() {
        
    }
    
    // getter dan setter
    public String getNama() {
        return namaLengkap;
    }
    
    public void setNama(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }
    
    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }
    
    public String getAksi() {
        return status;
    }
    public int getKekenyangan() {
        return kekenyangan;
    }
    public int getKesehatan() {
        return kesehatan;
    }
    public int getMood() {
        return mood;
    }
    public int getUang() {
        return uang;
    }
    public String getPekerjaan() {
        return pekerjaan;
    }
}
