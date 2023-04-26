public class Sim {
    private String namaLengkap;
    private String pekerjaan;
    private int uang;
    private int kekenyangan;
    private int kesehatan;
    private String status;
    private int mood;
    private Object[] inventory;

    public Sim (String namaLengkap, String pekerjaan, int uang, int kekenyangan, int kesehatan, String status, int mood) {
        this.namaLengkap = namaLengkap;
        this.pekerjaan = pekerjaan;
        this.uang = uang;
        this.kekenyangan = kekenyangan;
        this.kesehatan = kesehatan;
        this.status = status;
        this.mood = mood;    }
    
    public boolean isSimDead (){
        if (mood <= 0 || kekenyangan <= 0 || kesehatan <= 0){
            return true;
        } else {
            return false;
        }
    }

    public void removeBarang (Object[] inventory) {

    }

    public void beliBarang (int uang, Object[] inventory) {

    }

    public void doKerja (int kekenyangan, int mood) {
        this.kekenyangan = kekenyangan - 10;
        this.mood = mood - 10;
    }

    public void doOlahraga (int kesehatan, int kekenyangan, int mood) {
        this.kesehatan = kesehatan + 5;
        this.kekenyangan = kekenyangan - 5;
        this.mood = mood + 10;

        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doTidur (int mood, int kesehatan) {
        this.mood = mood + 30;
        this.kesehatan = kesehatan + 20;
        
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
    }

    public void doBuangAir (int mood, int kekenyangan) {
        this.kekenyangan = kekenyangan - 20;
        this.mood = mood + 10;

        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void upgradeRumah (int uang) {

    }

    public void doMandi (int mood, int kesehatan) {
        this.mood = mood + 10;
        this.kesehatan = kesehatan + 10;

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

        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doMenyapu (int kesehatan, int mood) {
        this.kesehatan = kesehatan + 5;
        this.mood = mood + 5;
    
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
    
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doIbadah (int mood, int kesehatan) {
        this.mood = mood + 20;
        this.kesehatan = kesehatan + 10;

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

        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doGantiBaju (int mood) {
        this.mood = mood + 15;

        if (mood > 100) {
            this.mood = 100;
        }
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

}
