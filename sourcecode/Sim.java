import java.util.Scanner;
import java.util.Set;

public class Sim {
    private String namaLengkap;
    private String pekerjaan;
    private int uang;
    private int kekenyangan;
    private int kesehatan;
    public String status;
    private int mood;
    private Object[] inventory;
    private static Waktu waktu = new Waktu();
    private Ruangan currentRoom;
    private Rumah currentRumah;
    private boolean NowPlaying;

    public Sim (String namaLengkap, String pekerjaan, int uang, int kekenyangan, int kesehatan, String status, int mood, boolean NowPlaying) {
        this.namaLengkap = namaLengkap;
        this.pekerjaan = pekerjaan;
        this.uang = 100;
        this.kekenyangan = 80;
        this.kesehatan = 80;
        this.status = status;
        this.mood = 80;  
        this.NowPlaying = NowPlaying;
    }

    public void setRuangan(Ruangan ruangan)
    {
        this.currentRoom = ruangan;
    }

    public Ruangan getRuangan(){
        return currentRoom;
    }

    public void setRumah(Rumah rumah){
        this.currentRumah = rumah;
    }

    public Rumah getRumah(){
        return currentRumah;
    }
    
    public boolean isSimDead (){
        if (mood <= 0 || kekenyangan <= 0 || kesehatan <= 0){
            return true;
        } else {
            return false;
        }
    }

    // public boolean isIdle() {
    //     if (this.status == "idle") {
    //         return true;
    //     } else {
    //         System.out.println("Anda sedang melakukan kegiatan lain");
    //         return false;
    //     }
    // }

    public void beliBarang (String namabarang) {
        Barang barang = new Barang(0);
        int idx = barang.namaBarang(namabarang);
        if(idx != -1) {
            if (getUang() >= barang.hargas[idx]){
                this.uang = getUang() - barang.hargas[idx];
                waktu.doAksi(waktu.getRandomWaktu(), waktu);
                // waktuBeliBarang = waktu.getRandomWaktu();
                // System.out.println("Waktu tunggu barang: " + waktuBeliBarang + " detik");
                // setBeliBarang(true);
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
                waktu.doAksi(waktu.getRandomWaktu(), waktu);
                // waktuBeliBarang = waktu.getRandomWaktu();
                // setBeliBarang(true);
            }
            else {
                System.out.println("Uang tidak cukup");
            }
        }
    }

    public void doKerja (int kekenyangan, int mood) {
        this.kekenyangan = kekenyangan - 10;
        this.mood = mood - 10;
        this.status = "Sedang bekerja";
        waktu.doAksi1(30, waktu);
        System.out.println("Anda sudah selesai bekerja");
        this.status = "idle";
    }

    public void doOlahraga (int kesehatan, int kekenyangan, int mood) {

        this.kesehatan = kesehatan + 5;
        this.kekenyangan = kekenyangan - 5;
        this.mood = mood + 10;
        waktu.doAksi1(20, waktu);
        this.status = "Sedang olahraga";
        System.out.println("Anda sudah selesai olahraga");
        this.status = "idle";
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doTidur (int mood, int kesehatan) {
        this.mood = mood + 30;
        this.kesehatan = kesehatan + 20;
        this.status = "Sedang tidur";
        waktu.doAksi1(240, waktu);
        System.out.println("Anda sudah selesai tidur");
        this.status = "idle";
        if (mood > 100) {
            this.mood = 100;
        }
        
        if (kesehatan > 100) {
            this.kesehatan = 100;
        }
    }

    public void doMakan (String namaMakanan) {
        this.status = "Sedang makan";
        waktu.doAksi1(30, waktu);
        System.out.println("Anda sudah selesai makan");
        this.status = "idle";
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

    public void doMasakNasiAyam(int mood) {
        this.mood = mood + 10;
        this.status = "Sedang memasak";
        waktu.doAksi1(24, waktu);
        this.status = "idle";
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doMasakNasiKari(int mood) {
        this.mood = mood + 10;
        this.status = "Sedang memasak";
        waktu.doAksi1(45, waktu);
        this.status = "idle";
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doMasakSususKacang(int mood) {
        this.mood = mood + 10;
        this.status = "Sedang memasak";
        waktu.doAksi1(8, waktu);
        this.status = "idle";
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doMasakTumisSayur(int mood) {
        this.mood = mood + 10;
        this.status = "Sedang memasak";
        waktu.doAksi1(8, waktu);
        this.status = "idle";
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doMasakBistik(int mood) {
        this.mood = mood + 10;
        this.status = "Sedang memasak";
        waktu.doAksi1(33, waktu);
        this.status = "idle";
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doBerkunjung (int mood, int kekenyangan) {
        this.status = "Sedang berkunjung";
        waktu.doAksi1(30, waktu);
        System.out.println("Anda sudah selesai berkunjung");
        this.status = "idle";
        this.mood = mood + 10;
        this.kekenyangan = kekenyangan - 10;
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doBuangAir (int mood, int kekenyangan) {
        this.status = "Sedang buang air";
        waktu.doAksi1(10, waktu);
        System.out.println("Anda sudah selesai buang air");
        this.status = "idle";
        this.kekenyangan = kekenyangan - 20;
        this.mood = mood + 10;
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void upgradeRumah () {
//         Rumah rumah = new Rumah(0,0);
//         System.out.println("Apakah anda ingin upgrade rumah?(y/n)");
//         Scanner input = new Scanner(System.in);
//         if (input.nextLine().equals("y")) {
//             // rumah.setDefaultRuangan();
//             rumah.printListRuanganRumah();
//             rumah.tambahRuangan();
//             rumah.setRuangan();
//         }
//         waktu.doAksi(1);
//         rumah.printListRuanganRumah();
    }

    public void doMandi (int mood, int kesehatan) {
        this.status = "Sedang mandi";
        waktu.doAksi1(60, waktu);
        System.out.println("Anda sudah selesai mandi");
        this.status = "idle";
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
        this.status = "Sedang main gitar";
        waktu.doAksi1(30, waktu);
        System.out.println("Anda sudah selesai main gitar");
        this.status = "idle";
        this.mood = mood + 10;
        this.kekenyangan = kekenyangan - 5;
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doMenyapu (int kesehatan, int mood) {
        this.status = "Sedang menyapu";
        waktu.doAksi1(10, waktu);
        System.out.println("Anda sudah selesai menyapu");
        this.status = "idle";
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
        this.status = "Sedang menonton";
        waktu.doAksi1(20, waktu);
        System.out.println("Anda sudah selesai menonton");
        this.status = "idle";
        this.mood = mood + 15;
        this.kekenyangan = kekenyangan - 5;
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doIbadah (int mood, int kesehatan) {
        this.status = "Sedang beribadah";
        waktu.doAksi1(20, waktu);
        System.out.println("Anda sudah selesai beribadah");
        this.status = "idle";
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
        this.status = "Sedang membaca";
        waktu.doAksi1(30, waktu);
        System.out.println("Anda sudah selesai membaca");
        this.status = "idle";
        this.mood = mood + 10;
        this.kekenyangan = kekenyangan - 5;
        if (mood > 100) {
            this.mood = 100;
        }
    }

    public void doGantiBaju (int mood) {
        this.status = "Sedang mengganti baju";
        waktu.doAksi1(5, waktu);
        System.out.println("Anda sudah selesai mengganti baju");
        this.status = "idle";
        this.mood = mood + 15;
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
    public boolean isNowPlaying() {
        return NowPlaying;   
    }
    public void setNowPlaying(boolean NowPlaying) {
        this.NowPlaying = NowPlaying;
    }
}
