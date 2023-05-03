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
    private Ruangan currentRoom;

    public Sim (String namaLengkap, String pekerjaan, int uang, int kekenyangan, int kesehatan, String status, int mood) {
        this.namaLengkap = namaLengkap;
        this.pekerjaan = pekerjaan;
        this.uang = 100;
        this.kekenyangan = 80;
        this.kesehatan = 80;
        this.status = status;
        this.mood = 80;    
    }

    public void setRuangan(Ruangan ruangan)
    {
        this.currentRoom = ruangan;
    }

    public Ruangan getRuangan(){
        return currentRoom;
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

    public void beliBarang (int uang) {
        Barang barang = new Barang(0);
        this.uang = uang - barang.getharga();
        waktu.doAksi(waktu.getRandomWaktu());
    }

    public void doBeliMakanan(int uang) {
        BahanMakanan bahanMakanan = new BahanMakanan(0);
        this.uang = uang - bahanMakanan.getHarga();
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

    public void doMakan (int kekenyangan) {

    }

    public void doMasak (int mood) {
        this.mood = mood + 10;

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
