import java.util.Scanner;
import java.util.ArrayList;
import javax.lang.model.util.ElementScanner14;

public class Main {
    public static void nextLine() {
        System.out.println("Press enter to continue...");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }
    public static void main(String[] args) {
        // Waktu waktu = new Waktu();
        // waktu.startGame();
        World world = new World(64, 64);
        // Membuat ArrayList untuk simList dan rumahList
        ArrayList<Sim> simList = new ArrayList<Sim>();
        ArrayList<Rumah> rumahList = new ArrayList<Rumah>();
        // Scanner
        Scanner input = new Scanner(System.in);
        // Membuat Sim di awal game
        System.out.println("Masukkan nama sim: ");
        String nama = input.nextLine();
        
        Pekerjaan pekerjaan = new Pekerjaan();
        pekerjaan.getRandomPekerjaan();
        pekerjaan.printPekerjaan();
        pekerjaan.printGaji();

        Sim sim = new Sim(nama, pekerjaan, 100, 80, 80, "idle", 80, true);
        // Memasukkan Sim awal ke simList
        simList.add(sim);
        // Mengatur Sim awal menjadi currentSim yang dimainkan
        Sim currentSim = sim;
        // Waktu
        Waktu waktu = new Waktu();
        // world.tambahRumah(null, null);
        System.out.println("Masukkan nama rumah: ");
        String namaRumah = input.nextLine();
        // world.tambahRumah(nama, null);
        System.out.println("Masukkan posisi x rumah: ");
        int x = input.nextInt();
        Thread threadBeliBarang = new Thread() {
        int i = 0;
            public void run() {
                long startTime = System.nanoTime();
                long interval = 1000000000; // 1 detik dalam nanodetik
    
                while (true) {
                    long currentTime = System.nanoTime();
                    long elapsedTime = currentTime - startTime;
                    if (elapsedTime >= interval && sim.getBeliBarang() && !sim.getStatus().equals("idle")) {
                        System.out.println("status: "+ sim.getStatus());
                                
                        sim.setWaktuBeliBarang(sim.getWaktuBeliBarang() - 1);
                        System.out.println("\nWaktu yang tersisa untuk barang sampai: " + sim.getWaktuBeliBarang() + " detik");
                        
                        if(sim.getWaktuBeliBarang() == 0){
                            System.out.println("\nBarang telah sampai");
                        }
                            startTime = currentTime;
                    }
                        
                }
            }
        };
        threadBeliBarang.start();

 
        while (x > 64) {
            System.out.println("Posisi x tidak valid");
            System.out.println("Masukkan posisi x rumah: ");
            x = input.nextInt();
        }
        System.out.println("Masukkan posisi y rumah: ");
        int y = input.nextInt();
        Rumah rumah = new Rumah(namaRumah, x, y);
        world.tambahRumah(namaRumah, rumah);
        sim.setRuangan((rumah.getListRuanganRumah().get(0)));
        sim.setRumah(rumah);
        rumahList.add(rumah);
        // Barang, bahanMakanan, dan Masakan baru
        Barang barang = new Barang(0);
        BahanMakanan bahanMakanan = new BahanMakanan(0);
        Masakan masakan = new Masakan(0);
        nextLine();

        while(!sim.isSimDead()) { 
            System.out.println("\n=== DAFTAR MENU ===");
            System.out.println("1. View Sim info");
            System.out.println("2. View Current Location");
            System.out.println("3. View Inventory");
            System.out.println("4. Upgrade House");
            System.out.println("5. Move Room");
            System.out.println("6. Edit Room");
            System.out.println("7. Add SIM");
            System.out.println("8. Change SIM");
            System.out.println("9. List Object");
            System.out.println("10. Go To Object");
            System.out.println("11. Action");
            System.out.println("12. Help");
            System.out.println("13. Exit");
            System.out.println("Silahkan pilih aksi yang ingin dijalankan: ");

            

            Integer nomor = input.nextInt();
            if (nomor.equals(1)) {
                System.out.println("\n=== PROFIL SIM ===");
                System.out.println("Nama SIM: " + currentSim.getNama());
                System.out.println("Kekenyangan anda: " + currentSim.getKekenyangan());
                System.out.println("Kesehatan anda: " + currentSim.getKesehatan());
                System.out.println("Mood anda: " + currentSim.getMood());
                System.out.println("Uang anda: " + currentSim.getUang());
                System.out.println("Pekerjaan anda: " + currentSim.pekerjaan.getPekerjaan());
                System.out.println("Status anda: " + currentSim.getAksi());
                nextLine();
            }
            else if (nomor.equals(2)) {
                world.printWorld();
                world.printRumah();
                System.out.println("Saat ini "+ currentSim.getNama() + " berada dalam " + currentSim.getRumah().getNamarumah() + " pada ruangan " + currentSim.getRuangan().getNamaRuangan());
                nextLine();
                // System.out.println("Saat ini " + sim.getNama() + " berada di ruangan " + sim.getRuangan().getNamaRuangan());
            }
            else if (nomor.equals(3)) {
                System.out.println("Inventory anda: ");
                bahanMakanan.tambahBahanMakanan("Susu");
                bahanMakanan.tambahBahanMakanan("Kacang");
                bahanMakanan.printBahanMakanan();
                masakan.printMakanan();
                barang.printBarangInventory();
                nextLine();
            }
            else if (nomor.equals(4)) {
                sim.upgradeRumah();
                nextLine();
            }
            else if (nomor.equals(5)) {
                nextLine();
            }
            else if (nomor.equals(6)) {
                nextLine();
            }
            else if (nomor.equals(7)) {
                // Menerima input nama Sim yang ingin ditambah
                int i = 1;   
                String trash = input.nextLine();
                System.out.println("Masukkan nama sim yang ingin ditambah !");           
                String nama1 = input.nextLine();
                // Menambahkan Sim baru ke simList
                simList.add(new Sim(nama1, null, 100, 80, 80, "idle", 80, false));
                // Menambah Rumah baru untuk Sim baru
                System.out.println("Masukkan nama rumah: ");
                String namaRumah1 = input.nextLine();
                // world.tambahRumah(nama, null);
                System.out.println("Masukkan posisi x rumah: ");
                int x1 = input.nextInt();
                while (x1 > 64) {
                    System.out.println("Posisi x tidak valid");
                    System.out.println("Masukkan posisi x rumah: ");
                    x = input.nextInt();
                }
                System.out.println("Masukkan posisi y rumah: ");
                int y1 = input.nextInt();
                Rumah rumah1 = new Rumah(namaRumah1, x1, y1);
                world.tambahRumah(namaRumah1, rumah1);
                for (Sim si : simList) {
                    if (si.getNama().equals(nama1)) {
                        si.setRuangan((rumah1.getListRuanganRumah().get(0)));
                        si.setRumah(rumah1);
                        rumahList.add(rumah1);
                    }
                }
                // Menampilkan daftar objek Sim dalam list
                System.out.println("\n=== DAFTAR SIM ===");
                for (Sim s : simList) {
                    System.out.println(i + ". " + s.getNama());
                    i++;
                }
                nextLine();
            }
            else if (nomor.equals(8)) {
                // Menampilkan daftar objek Sim dalam list
                int i = 1;
                System.out.println("\n=== DAFTAR SIM ===");
                for (Sim s : simList) {
                    System.out.println(i + ". " + s.getNama());
                    i++;
                }
                // Menerima input nama Sim yang ingin dimainkan
                System.out.println("Masukkan nama sim yang ingin dimainkan !");
                String trash = input.nextLine();
                String namaMain = input.nextLine();
                boolean isExist = false;
                while (!isExist){
                    for (Sim si : simList) {
                        if (si.getNama().equals(namaMain)) {
                            si.setNowPlaying(true);
                            currentSim = si; // Mengganti currentSim yang aktif menjadi Sim yang ingin dimainkan
                            isExist = true;
                        } else {
                            si.setNowPlaying(false);
                        }
                    }
                    if (!isExist){ // Kondisi apabila nama yang diinput tidak ada dalam simList
                        System.out.println("Nama Sim yang diinput tidak ada dalam List Sim, Input nama lain!");
                        namaMain = input.nextLine();
                    }
                }
                // Menampilkan Sim yang sekarang aktif (sedang dimainkan)
                System.out.println("Sim yang aktif sekarang : " + namaMain + "\n");
                // scanner.close();
                nextLine();
            }
            else if (nomor.equals(9)) {
                barang.printBarangRuangan();
                nextLine();
            }
            else if (nomor.equals(10)) {
                //Menu ini digunakan untuk Sim sudah sampai suatu objek.
                //Jika menuju ke objek tersebut dapat melakukan aksi
                System.out.println("Pilih objek yang ingin dituju: ");
                barang.printBarangRuangan();
                String enter = input.nextLine();
                String nomor1 = input.nextLine();
                // barang.cekBarang(nomor1);
                if (barang.cekBarang(nomor1) == true) {
                    System.out.println("Apakah anda ingin berjalan menuju objek tersebut? (y/n)");
                    String jawaban = input.next();
                    if (jawaban.equals("y")) {
                        System.out.println("Anda sedang berjalan menuju tersebut");
                        // String[] names = barang.getNames();
                        if (nomor1.equals("Kasur Single")) {
                            System.out.println("Anda sudah sampai " + barang.getName(0));
                            System.out.println("Apakah anda ingin tidur? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doTidur(currentSim.getKesehatan(), currentSim.getMood());
                                nextLine();
                            }
                            else {
                                nextLine();
                            }
                        }
                        else if (nomor1.equals("Kasur Queen Size")) {
                            System.out.println("Anda sudah sampai " + barang.getName(1));
                            System.out.println("Apakah anda ingin tidur? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doTidur(currentSim.getKesehatan(), currentSim.getMood());
                                nextLine();
                            }
                            else {
                                nextLine();
                            }
                        }
                        else if (nomor1.equals("Kasur King Size")) {
                            System.out.println("Anda sudah sampai " + barang.getName(2));
                            System.out.println("Apakah anda ingin tidur? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doTidur(currentSim.getKesehatan(), currentSim.getMood());
                                nextLine();
                            }
                            else {
                                nextLine();
                            }
                        }
                        else if (nomor1.equals("Toilet")) {
                            System.out.println("Anda sudah sampai " + barang.getName(3));
                            System.out.println("Apakah anda ingin buang air? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doBuangAir(currentSim.getKesehatan(), currentSim.getMood());
                                nextLine();
                            }
                            else {
                                nextLine();
                            }
                        }
                        else if (nomor1.equals("Kompor Gas")) {
                            System.out.println("Anda sudah sampai " + barang.getName(4));
                            System.out.println("Apakah anda ingin memasak? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                System.out.println("Berikut bahan makanan yang kamu punya :\n");
                                bahanMakanan.printBahanMakanan();
                                barang.printBarangInventory();
                                System.out.println("Masakan apa yang ingin anda masak?");
                                System.out.println("1. Nasi Ayam");
                                System.out.println("2. Nasi Kari");
                                System.out.println("3. Susu Kacang");
                                System.out.println("4. Tumis Sayur");
                                System.out.println("5. Bistik");
                                Integer jawaban2 = input.nextInt();
                                if (jawaban2.equals(1)){
                                    if (bahanMakanan.kuantitasInventory[0] > 0 && bahanMakanan.kuantitasInventory[2] > 0) {
                                        System.out.println("Apakah anda ingin memasak Nasi Ayam? (y/n)");
                                        String jawaban3 = input.next();
                                        if (jawaban3.equals("y")) {
                                            System.out.println("Anda sedang memasak Nasi Ayam");
                                            currentSim.doMasakNasiAyam(currentSim.getMood());
                                            bahanMakanan.kuantitasInventory[0] -= 1;
                                            bahanMakanan.kuantitasInventory[2] -= 1;
                                            masakan.tambahMakanan("Nasi Ayam");
                                            System.out.println("Anda berhasil memasak Nasi Ayam, silahkan cek inventory");
                                        }
                                        else {
                                            System.out.println("Anda tidak jadi memasak");
                                            nextLine();
                                        }
                                    }
                                    else {
                                        System.out.println("Bahan makanan tidak cukup");
                                        nextLine();
                                    }
                                }
                                else if (jawaban2.equals(2)){
                                    if (bahanMakanan.kuantitasInventory[0] > 0 && bahanMakanan.kuantitasInventory[1] > 0 && bahanMakanan.kuantitasInventory[3] > 0 && bahanMakanan.kuantitasInventory[4] > 0) {
                                        System.out.println("Apakah anda ingin memasak Nasi Kari? (y/n)");
                                        String jawaban3 = input.next();
                                        if (jawaban3.equals("y")) {
                                            System.out.println("Anda sedang memasak Nasi Kari");
                                            currentSim.doMasakNasiKari(currentSim.getMood());
                                            bahanMakanan.kuantitasInventory[0] -= 1;
                                            bahanMakanan.kuantitasInventory[1] -= 1;
                                            bahanMakanan.kuantitasInventory[3] -= 1;
                                            bahanMakanan.kuantitasInventory[4] -= 1;
                                            masakan.tambahMakanan("Nasi Kari");
                                            System.out.println("Anda berhasil memasak Nasi Kari, silahkan cek inventory");
                                        }
                                        else {
                                            System.out.println("Anda tidak jadi memasak");
                                            nextLine();
                                        }
                                    }
                                    else {
                                        System.out.println("Bahan makanan tidak cukup");
                                        nextLine();
                                    }
                                }
                                else if (jawaban2.equals(3)){
                                    if (bahanMakanan.kuantitasInventory[6] > 0 && bahanMakanan.kuantitasInventory[7] > 0 ) {
                                        System.out.println("Apakah anda ingin memasak Susu Kacang? (y/n)");
                                        String jawaban3 = input.next();
                                        if (jawaban3.equals("y")) {
                                            System.out.println("Anda sedang memasak Susu Kacang");
                                            currentSim.doMasakSususKacang(currentSim.getMood());
                                            bahanMakanan.kuantitasInventory[6] =- 1;
                                            bahanMakanan.kuantitasInventory[7] =- 1;
                                            masakan.tambahMakanan("Susu Kacang");
                                            System.out.println("Anda berhasil memasak Susu Kacang, silahkan cek inventory");
                                        }
                                        else {
                                            System.out.println("Anda tidak jadi memasak");
                                            nextLine();
                                        }
                                    }
                                    else {
                                        System.out.println("Bahan makanan tidak cukup");
                                        nextLine();
                                    }
                                }
                                else if (jawaban2.equals(4)){
                                    if (bahanMakanan.kuantitasInventory[4] > 0 && bahanMakanan.kuantitasInventory[5] > 0) {
                                        System.out.println("Apakah anda ingin memasak Tumis Sayur? (y/n)");
                                        String jawaban3 = input.next();
                                        if (jawaban3.equals("y")) {
                                            System.out.println("Anda sedang memasak Tumis Sayur");
                                            currentSim.doMasakTumisSayur(currentSim.getMood());
                                            bahanMakanan.kuantitasInventory[4] -= 1;
                                            bahanMakanan.kuantitasInventory[5] -= 1;
                                            masakan.tambahMakanan("Tumis Sayur");
                                            System.out.println("Anda berhasil memasak Nasi Kari, silahkan cek inventory");
                                        }
                                        else {
                                            System.out.println("Anda tidak jadi memasak");
                                            nextLine();
                                        }
                                    }
                                    else {
                                        System.out.println("Bahan makanan tidak cukup");
                                        nextLine();
                                    }
                                }
                                else if (jawaban2.equals(5)){
                                    if (bahanMakanan.kuantitasInventory[1] > 0 && bahanMakanan.kuantitasInventory[3] > 0) {
                                        System.out.println("Apakah anda ingin memasak Bistik? (y/n)");
                                        String jawaban3 = input.next();
                                        if (jawaban3.equals("y")) {
                                            System.out.println("Anda sedang memasak Bistik");
                                            currentSim.doMasakBistik(currentSim.getMood());
                                            bahanMakanan.kuantitasInventory[1] -= 1;
                                            bahanMakanan.kuantitasInventory[3] -= 1;
                                            masakan.tambahMakanan("Bistik");
                                            System.out.println("Anda berhasil memasak Bistik, silahkan cek inventory");
                                        }
                                        else {
                                            System.out.println("Anda tidak jadi memasak");
                                            nextLine();
                                        }
                                    }
                                    else {
                                        System.out.println("Bahan makanan tidak cukup");
                                        nextLine();
                                    }
                                }
                            }
                            else {
                                nextLine();
                            }
                        }
                        else if (nomor1.equals("Kompor Listrik")) {
                            System.out.println("Anda sudah sampai " + barang.getName(5));
                            System.out.println("Apakah anda ingin memasak? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                System.out.println("Masakan apa yang ingin anda masak?");
                                System.out.println("1. Nasi Ayam");
                                System.out.println("2. Nasi Kari");
                                System.out.println("3. Susu Kacang");
                                System.out.println("4. Tumis Sayur");
                                System.out.println("5. Bistik");
                                Integer jawaban2 = input.nextInt();
                                if (jawaban2.equals(1)){
                                    if (bahanMakanan.kuantitasInventory[0] > 0 && bahanMakanan.kuantitasInventory[2] > 0) {
                                        System.out.println("Apakah anda ingin memasak Nasi Ayam? (y/n)");
                                        String jawaban3 = input.next();
                                        if (jawaban3.equals("y")) {
                                            System.out.println("Anda sedang memasak Nasi Ayam");
                                            currentSim.doMasakNasiAyam(currentSim.getMood());
                                            bahanMakanan.kuantitasInventory[0] -= 1;
                                            bahanMakanan.kuantitasInventory[2] -= 1;
                                            masakan.tambahMakanan("Nasi Ayam");
                                            System.out.println("Anda berhasil memasak Nasi Ayam, silahkan cek inventory");
                                        }
                                        else {
                                            System.out.println("Anda tidak jadi memasak");
                                            nextLine();
                                        }
                                    }
                                    else {
                                        System.out.println("Bahan makanan tidak cukup");
                                        nextLine();
                                    }
                                }
                                else if (jawaban2.equals(2)){
                                    if (bahanMakanan.kuantitasInventory[0] > 0 && bahanMakanan.kuantitasInventory[1] > 0 && bahanMakanan.kuantitasInventory[3] > 0 && bahanMakanan.kuantitasInventory[4] > 0) {
                                        System.out.println("Apakah anda ingin memasak Nasi Kari? (y/n)");
                                        String jawaban3 = input.next();
                                        if (jawaban3.equals("y")) {
                                            System.out.println("Anda sedang memasak Nasi Kari");
                                            currentSim.doMasakNasiKari(currentSim.getMood());
                                            bahanMakanan.kuantitasInventory[0] -= 1;
                                            bahanMakanan.kuantitasInventory[1] -= 1;
                                            bahanMakanan.kuantitasInventory[3] -= 1;
                                            bahanMakanan.kuantitasInventory[4] -= 1;
                                            masakan.tambahMakanan("Nasi Kari");
                                            System.out.println("Anda berhasil memasak Nasi Kari, silahkan cek inventory");
                                        }
                                        else {
                                            System.out.println("Anda tidak jadi memasak");
                                            nextLine();
                                        }
                                    }
                                    else {
                                        System.out.println("Bahan makanan tidak cukup");
                                        nextLine();
                                    }
                                }
                                else if (jawaban2.equals(3)){
                                    if (bahanMakanan.kuantitasInventory[6] > 0 && bahanMakanan.kuantitasInventory[7] > 0 ) {
                                        System.out.println("Apakah anda ingin memasak Susu Kacang? (y/n)");
                                        String jawaban3 = input.next();
                                        if (jawaban3.equals("y")) {
                                            System.out.println("Anda sedang memasak Susu Kacang");
                                            currentSim.doMasakSususKacang(currentSim.getMood());
                                            bahanMakanan.kuantitasInventory[6]--;
                                            bahanMakanan.kuantitasInventory[7]--;
                                            masakan.tambahMakanan("Susus Kacang");
                                            System.out.println("Anda berhasil memasak Susu Kacang, silahkan cek inventory");
                                        }
                                        else {
                                            System.out.println("Anda tidak jadi memasak");
                                            nextLine();
                                        }
                                    }
                                    else {
                                        System.out.println("Bahan makanan tidak cukup");
                                        nextLine();
                                    }
                                }
                                else if (jawaban2.equals(4)){
                                    if (bahanMakanan.kuantitasInventory[4] > 0 && bahanMakanan.kuantitasInventory[5] > 0) {
                                        System.out.println("Apakah anda ingin memasak Tumis Sayur? (y/n)");
                                        String jawaban3 = input.next();
                                        if (jawaban3.equals("y")) {
                                            System.out.println("Anda sedang memasak Tumis Sayur");
                                            currentSim.doMasakTumisSayur(currentSim.getMood());
                                            bahanMakanan.kuantitasInventory[4] -= 1;
                                            bahanMakanan.kuantitasInventory[5] -= 1;
                                            masakan.tambahMakanan("Tumis Sayur");
                                            System.out.println("Anda berhasil memasak Nasi Kari, silahkan cek inventory");
                                        }
                                        else {
                                            System.out.println("Anda tidak jadi memasak");
                                            nextLine();
                                        }
                                    }
                                    else {
                                        System.out.println("Bahan makanan tidak cukup");
                                        nextLine();
                                    }
                                }
                                else if (jawaban2.equals(5)){
                                    if (bahanMakanan.kuantitasInventory[1] > 0 && bahanMakanan.kuantitasInventory[3] > 0) {
                                        System.out.println("Apakah anda ingin memasak Bistik? (y/n)");
                                        String jawaban3 = input.next();
                                        if (jawaban3.equals("y")) {
                                            System.out.println("Anda sedang memasak Bistik");
                                            currentSim.doMasakBistik(currentSim.getMood());
                                            bahanMakanan.kuantitasInventory[1] -= 1;
                                            bahanMakanan.kuantitasInventory[3] -= 1;
                                            masakan.tambahMakanan("Bistik");
                                            System.out.println("Anda berhasil memasak Bistik, silahkan cek inventory");
                                        }
                                        else {
                                            System.out.println("Anda tidak jadi memasak");
                                            nextLine();
                                        }
                                    }
                                    else {
                                        System.out.println("Bahan makanan tidak cukup");
                                        nextLine();
                                    }
                                }
                            }
                            else {
                                nextLine();
                            }
                        }
                        else if (nomor1.equals("Meja dan Kursi")) {
                            System.out.println("Anda sudah sampai " + barang.getName(6));
                            System.out.println("Apakah anda ingin makan? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                System.out.println("Pilih makanan yang ingin anda makan :");
                                bahanMakanan.printBahanMakanan();
                                masakan.printMakanan();
                                String trash = input.nextLine();
                                String jawaban2 = input.nextLine();
                                if (jawaban2.equals("Nasi Kari")) {
                                    masakan.cekMasakan("Nasi Kari");
                                    currentSim.doMakan("Nasi Kari");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Nasi Ayam")) {
                                    currentSim.doMakan("Nasi Ayam");
                                    masakan.cekMasakan("Nasi Ayam");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Susu Kacang")) {
                                    currentSim.doMakan("Susu Kacang");
                                    masakan.cekMasakan("Susu Kacang");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Tumis Sayur")) {
                                    masakan.cekMasakan("Tumis Sayur");
                                    currentSim.doMakan("Tumis Sayur");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Bistik")) {
                                    masakan.cekMasakan("Bistik");
                                    currentSim.doMakan("Bistik");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Nasi")) {
                                    bahanMakanan.cekBahan("Nasi");
                                    currentSim.doMakan("Nasi");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Kentang")) {
                                    bahanMakanan.cekBahan("Kentang");
                                    currentSim.doMakan("Kentang");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Ayam")) {
                                    bahanMakanan.cekBahan("Ayam");
                                    currentSim.doMakan("Ayam");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Sapi")) {
                                    bahanMakanan.cekBahan("Sapi");
                                    currentSim.doMakan("Sapi");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Kacang")) {
                                    bahanMakanan.cekBahan("Kacang");
                                    currentSim.doMakan("Kacang");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Susu")) {
                                    bahanMakanan.cekBahan("Susu");
                                    currentSim.doMakan("Susu");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Wortel")) {
                                    bahanMakanan.cekBahan("Wortel");
                                    currentSim.doMakan("Wortel");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Bayam")) {
                                    bahanMakanan.cekBahan("Bayam");
                                    currentSim.doMakan("Bayam");
                                    nextLine();
                                }
                                else {
                                    System.out.println("Masakan tidak ada");
                                    nextLine();
                                }
                            }
                            else {
                                nextLine();
                            }
                        }
                        else if (nomor1.equals("Jam")) {
                            System.out.println("Anda sudah sampai " + barang.getName(7));
                            System.out.println("Apakah anda ingin melihat waktu? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doLihatWaktu();
                                nextLine();
                            }
                            else {
                                nextLine();
                            }
                            
                        }
                        else if (nomor1.equals("Treadmill")) {
                            System.out.println("Anda sudah sampai " + barang.getName(8));
                            System.out.println("Apakah anda ingin berolahraga? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doOlahraga(currentSim.getKesehatan(), currentSim.getKekenyangan(), currentSim.getMood());
                                nextLine();
                            }
                            else {
                                nextLine();
                            }
                            
                        }
                        else if (nomor1.equals("Gitar")) {
                            System.out.println("Anda sudah sampai " + barang.getName(9));
                            System.out.println("Apakah anda ingin bermain gitar? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doMainGitar(currentSim.getMood(), currentSim.getKekenyangan());
                                nextLine();
                            }
                            else {
                                nextLine();
                            }
                            
                        }
                        else if (nomor1.equals("Sapu")) {
                            System.out.println("Anda sudah sampai " + barang.getName(10));
                            System.out.println("Apakah anda ingin menyapu? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doMenyapu(currentSim.getMood(), currentSim.getKekenyangan());
                                nextLine();
                            }
                            else {
                                nextLine();
                            }
                            
                            
                        }
                        else if (nomor1.equals("Tv")) {
                            System.out.println("Anda sudah sampai " + barang.getName(11));
                            System.out.println("Apakah anda ingin menonton TV? (y/n");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doMenonton(currentSim.getMood(), currentSim.getKekenyangan());
                                nextLine();
                            }
                            else {
                                nextLine();
                            }
                            
                        }
                        else if (nomor1.equals("Sajadah")) {
                            System.out.println("Anda sudah sampai " + barang.getName(12));
                            System.out.println("Apakah anda ingin ibadah? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doIbadah(currentSim.getMood(), currentSim.getKesehatan());
                                nextLine();
                            }
                            else {
                                nextLine();
                            }
                        }
                        else if (nomor1.equals("Buku")) {
                            System.out.println("Anda sudah sampai rak" + barang.getName(13));
                            System.out.println("Apakah anda ingin membaca? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doBaca(currentSim.getMood(), currentSim.getKekenyangan());
                                nextLine();
                            }
                            else {
                                nextLine();
                            }
                        }
                        else if (nomor1.equals("Baju")) {
                            System.out.println("Anda sudah sampai " + barang.getName(14));
                            System.out.println("Apakah anda ingin mengganti baju? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doGantiBaju(currentSim.getMood());
                                nextLine();
                            }
                            else {
                                nextLine();
                            }
                        }
                    }
                    else if (jawaban.equals("n")) {
                        nextLine();
                    }
                    else {
                        System.out.println("Input tidak valid");
                        nextLine();
                    }
                } else {
                    nextLine();
                }
            }
            else if (nomor.equals(11)) {
                System.out.println("Pilihan aksi yang dapat dilakukan: ");
                System.out.println("1. Bekerja");
                System.out.println("2. Berkunjung ke rumah teman");
                System.out.println("3. Beli barang");
                Integer pilihan = input.nextInt();
                if (pilihan.equals(1)) {
                    System.out.println("Anda sedang bekerja");
                    currentSim.doKerja(currentSim.getKekenyangan(), currentSim.getMood());
                    nextLine();
                }
                else if (pilihan.equals(2)) {
                    int i = 1;
                    System.out.println("\n=== DAFTAR RUMAH ===");
                    for (Rumah r : rumahList) {
                        System.out.println(i + ". " + r.getNamarumah());
                        i++;
                    }
                    System.out.println("Masukkan nama rumah yang ingin anda kunjungi!");
                    String trash = input.nextLine();
                    String rumahkunjung = input.nextLine();
                    boolean isExist = false;
                    while (!isExist){
                        for (Rumah r : rumahList) {
                            if (r.getNamarumah().equals(rumahkunjung)) {
                                Rumah currentRumah = r;
                                currentSim.setRumah(r);
                                isExist = true;
                            }
                        }
                        if (!isExist){
                            System.out.println("Nama Rumah yang ingin dikunjungi tidak tersedia, silahkan input ulang!");
                            rumahkunjung = input.nextLine();
                        }
                    }
                    System.out.println("Anda sedang berkunjung ke rumah teman (" + rumahkunjung + ")");
                    currentSim.doBerkunjung(currentSim.getMood(), currentSim.getKekenyangan());
                    nextLine();
                }
                else if (pilihan.equals(3)) {
                    System.out.println("Pilihan barang yang dapat dibeli: ");
                    System.out.println("1. Bahan makanan");
                    System.out.println("2. Toilet");
                    System.out.println("3. Jam");
                    System.out.println("4. Treadmill");
                    System.out.println("5. Gitar");
                    System.out.println("6. Sapu");
                    System.out.println("7. Tv");
                    System.out.println("8. Sajadah");
                    System.out.println("9. Buku");
                    System.out.println("10. Baju");
                    System.out.println("11. Kasur Single");
                    System.out.println("12. Kasur Queen Size");
                    System.out.println("13. Kasur King Size");
                    System.out.println("14. Kompor Gas");
                    System.out.println("15. Kompor Listrik");
                    System.out.println("16. Meja dan Kursi");
                    Integer pilihan2 = input.nextInt();
                    if (pilihan2.equals(1)) {
                        System.out.println("Pilihan makanan yang dapat dibeli: ");
                        System.out.println("1. Nasi");
                        System.out.println("2. Kentang");
                        System.out.println("3. Ayam");
                        System.out.println("4. Sapi");
                        System.out.println("5. Wortel");
                        System.out.println("6. Bayam");
                        System.out.println("7. Kacang");
                        System.out.println("8. Susu");
                        Integer pilihan3 = input.nextInt();
                        if (pilihan3.equals(1)) {
                            System.out.println("Apakah anda ingin membeli nasi? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                if(sim.getUang() >= bahanMakanan.hargas[0]) {
                                    currentSim.doBeliMakanan("Nasi");
                                    bahanMakanan.tambahBahanMakanan("Nasi");
                                    nextLine();
                                }
                                else {
                                    System.out.println("Uang anda tidak cukup");
                                    nextLine();
                                }
                            }
                            else if (jawaban1.equals("n")) {
                                nextLine();
                            }
                            else {
                                System.out.println("Input tidak valid");
                                nextLine();
                            }
                        }
                        else if (pilihan3.equals(2)) {
                            System.out.println("Apakah anda ingin membeli kentang? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doBeliMakanan("Kentang");
                                bahanMakanan.tambahBahanMakanan("Kentang");
                                nextLine();
                            }
                            else if (jawaban1.equals("n")) {
                                nextLine();
                            }
                            else {
                                System.out.println("Input tidak valid");
                                nextLine();
                            }
                        }
                        else if (pilihan3.equals(3)) {
                            System.out.println("Apakah anda ingin membeli ayam? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doBeliMakanan("Ayam");
                                bahanMakanan.tambahBahanMakanan("Ayam");
                                nextLine();
                            }
                            else if (jawaban1.equals("n")) {
                                nextLine();
                            }
                            else {
                                System.out.println("Input tidak valid");
                                nextLine();
                            }
                        }
                        else if (pilihan3.equals(4)) {
                            System.out.println("Apakah anda ingin membeli sapi? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doBeliMakanan("Sapi");
                                bahanMakanan.tambahBahanMakanan("Sapi");
                                nextLine();
                            }
                            else if (jawaban1.equals("n")) {
                                nextLine();
                            }
                            else {
                                System.out.println("Input tidak valid");
                                nextLine();
                            }
                        }
                        else if (pilihan3.equals(5)) {
                            System.out.println("Apakah anda ingin membeli wortel? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doBeliMakanan("Wortel");
                                bahanMakanan.tambahBahanMakanan("Wortel");
                                nextLine();
                            }
                            else if (jawaban1.equals("n")) {
                                nextLine();
                            }
                            else {
                                System.out.println("Input tidak valid");
                                nextLine();
                            }
                        }
                        else if (pilihan3.equals(6)) {
                            System.out.println("Apakah anda ingin membeli bayam? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doBeliMakanan("Bayam");
                                bahanMakanan.tambahBahanMakanan("Bayam");
                                nextLine();
                            }
                            else if (jawaban1.equals("n")) {
                                nextLine();
                            }
                            else {
                                System.out.println("Input tidak valid");
                                nextLine();
                            }
                        }
                        else if (pilihan3.equals(7)) {
                            System.out.println("Apakah anda ingin membeli kacang? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doBeliMakanan("Kacang");
                                bahanMakanan.tambahBahanMakanan("Kacang");
                                nextLine();
                            }
                            else if (jawaban1.equals("n")) {
                                nextLine();
                            }
                            else {
                                System.out.println("Input tidak valid");
                                nextLine();
                            }
                        }
                        else if (pilihan3.equals(8)) {
                            System.out.println("Apakah anda ingin membeli susu? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                currentSim.doBeliMakanan("Susu");
                                bahanMakanan.tambahBahanMakanan("Susu");
                                nextLine();
                            }
                            else if (jawaban1.equals("n")) {
                                nextLine();
                            }
                            else {
                                System.out.println("Input tidak valid");
                                nextLine();
                            }
                        }
                        else {
                            System.out.println("Input tidak valid");
                            nextLine();
                        }
                    }
                    else if (pilihan2.equals(2)) {
                        System.out.println("Apakah anda ingin membeli toilet?(y/n)");
                        String jawaban2 = input.next();
                        if (jawaban2.equals("y")) {
                            currentSim.beliBarang("Toilet");
                            barang.tambahBarang("Toilet");
                            nextLine();
                        }
                        else if (jawaban2.equals("n")) {
                            nextLine();
                        }
                        else {
                            System.out.println("Input tidak valid");
                            nextLine();
                        }
                    }
                    else if (pilihan2.equals(3)) {
                        System.out.println("Apakah anda ingin membeli jam?(y/n)");
                        String jawaban3 = input.next();
                        if (jawaban3.equals("y")) {
                            currentSim.beliBarang("Jam");
                            barang.tambahBarang("Jam");
                            nextLine();
                        }
                        else if (jawaban3.equals("n")) {
                            nextLine();
                        }
                        else {
                            System.out.println("Input tidak valid");
                            nextLine();
                        }
                    }
                    else if (pilihan2.equals(4)) {
                        System.out.println("Apakah anda ingin membeli treadmill?(y/n)");
                        String jawaban4 = input.next();
                        if (jawaban4.equals("y")) {
                            currentSim.beliBarang("Treadmill");
                            barang.tambahBarang("Treadmill");
                            nextLine();
                        }
                        else if (jawaban4.equals("n")) {
                            nextLine();
                        }
                        else {
                            System.out.println("Input tidak valid");
                            nextLine();
                        }
                    }
                    else if (pilihan2.equals(5)){
                        System.out.println("Apakah anda ingin membeli gitar?(y/n)");
                        String jawaban5 = input.next();
                        if (jawaban5.equals("y")) {
                            currentSim.beliBarang("Gitar");
                            barang.tambahBarang("Gitar");
                            nextLine();
                        }
                        else if (jawaban5.equals("n")) {
                            nextLine();
                        }
                        else {
                            System.out.println("Input tidak valid");
                            nextLine();
                        }
                    }
                    else if (pilihan2.equals(6)) {
                        System.out.println("Apakah anda ingin membeli sapu?(y/n)");
                        String jawaban6 = input.next();
                        if (jawaban6.equals("y")) {
                            currentSim.beliBarang("Sapu");
                            barang.tambahBarang("Sapu");
                            nextLine();
                        }
                        else if (jawaban6.equals("n")) {
                            nextLine();
                        }
                        else {
                            System.out.println("Input tidak valid");
                            nextLine();
                        }
                    }
                    else if (pilihan2.equals(7)) {
                        System.out.println("Apakah anda ingin membeli tv?(y/n)");
                        String jawaban7 = input.next();
                        if (jawaban7.equals("y")) {
                            if (sim.getUang() >= barang.hargas[11]) {
                                currentSim.beliBarang("Tv");
                                barang.tambahBarang("Tv");
                                nextLine();
                            }
                            else {
                                System.out.println("Uang anda tidak cukup");
                                nextLine();
                            }
                        }
                        else if (jawaban7.equals("n")) {
                            nextLine();
                        }
                        else {
                            System.out.println("Input tidak valid");
                            nextLine();
                        }
                    }
                    else if (pilihan2.equals(8)){
                        System.out.println("Apakah anda ingin membeli sajadah?(y/n)");
                        String jawaban8 = input.next();
                        if (jawaban8.equals("y")) {
                            currentSim.beliBarang("Sajadah");
                            barang.tambahBarang("Sajadah");
                            nextLine();
                        }
                        else if (jawaban8.equals("n")) {
                            nextLine();
                        }
                        else {
                            System.out.println("Input tidak valid");
                            nextLine();
                        }
                    }
                    else if (pilihan2.equals(9)) {
                        System.out.println("Apakah anda ingin membeli buku?(y/n)");
                        String jawaban9 = input.next();
                        if (jawaban9.equals("y")) {
                            currentSim.beliBarang("Buku");
                            barang.tambahBarang("Buku");
                            nextLine();
                        }
                        else if (jawaban9.equals("n")) {
                            nextLine();
                        }
                        else {
                            System.out.println("Input tidak valid");
                            nextLine();
                        }
                    }
                    else if (pilihan2.equals(10)) {
                        System.out.println("Apakah anda ingin membeli baju?(y/n)");
                        String jawaban10 = input.next();
                        if (jawaban10.equals("y")) {
                            currentSim.beliBarang("Baju");
                            barang.tambahBarang("Baju");
                            nextLine();
                        }
                        else if (jawaban10.equals("n")) {
                            nextLine();
                        }
                        else {
                            System.out.println("Input tidak valid");
                            nextLine();
                        }
                    }
                    else if (pilihan2.equals(11)){
                        System.out.println("Apakah anda ingin membeli kasur single?(y/n)");
                        String jawaban11 = input.next();
                        if (jawaban11.equals("y")) {
                            currentSim.beliBarang("Kasur Single");
                            barang.tambahBarang("Kasur Single");
                            nextLine();
                        }
                        else if (jawaban11.equals("n")) {
                            nextLine();
                        }
                        else {
                            System.out.println("Input tidak valid");
                            nextLine();
                        }
                    }
                    else if (pilihan2.equals(12)) {
                        System.out.println("Apakah anda ingin membeli kasur queen size?(y/n)");
                        String jawaban12 = input.next();
                        if (jawaban12.equals("y")) {
                            currentSim.beliBarang("Kasur Queen Size");
                            barang.tambahBarang("Kasur Queen Size");
                            nextLine();
                        }
                        else if (jawaban12.equals("n")) {
                            nextLine();
                        }
                        else {
                            System.out.println("Input tidak valid");
                            nextLine();
                        }
                    }
                    else if (pilihan2.equals(13)) {
                        System.out.println("Apakah anda ingin membeli kasur king size?(y/n)");
                        String jawaban13 = input.next();
                        if (jawaban13.equals("y")) {
                            currentSim.beliBarang("Kasur King Size");
                            barang.tambahBarang("Kasur King Size");
                            nextLine();
                        }
                        else if (jawaban13.equals("n")) {
                            nextLine();
                        }
                        else {
                            System.out.println("Input tidak valid");
                            nextLine();
                        }
                    }
                    else if (pilihan2.equals(14)) {
                        System.out.println("Apakah anda ingin membeli kompor gas?(y/n)");
                        String jawaban14 = input.next();
                        if (jawaban14.equals("y")) {
                            currentSim.beliBarang("Kompor Gas");
                            barang.tambahBarang("Kompor Gas");
                            nextLine();
                        }
                        else if (jawaban14.equals("n")) {
                            nextLine();
                        }
                        else {
                            System.out.println("Input tidak valid");
                        }
                    }
                    else if (pilihan2.equals(15)) {
                        System.out.println("Apakah anda ingin membeli kompor listrik?(y/n)");
                        String jawaban15 = input.next();
                        if (jawaban15.equals("y")) {
                            currentSim.beliBarang("Kompor Listrik");
                            barang.tambahBarang("Kompor Listrik");
                            nextLine();
                        }
                        else if (jawaban15.equals("n")) {
                            nextLine();
                        }
                        else {
                            System.out.println("Input tidak valid");
                        }
                    }
                    else if (pilihan2.equals(16)) {
                        System.out.println("Apakah anda ingin membeli meja dan kursi?(y/n)");
                        String jawaban16 = input.next();
                        if (jawaban16.equals("y")) {
                            currentSim.beliBarang("Meja dan Kursi");
                            barang.tambahBarang("Meja dan Kursi");
                            nextLine();
                        }
                        else if (jawaban16.equals("n")) {
                            nextLine();
                        }
                        else {
                            System.out.println("Input tidak valid");
                        }
                    }
                    else {
                        System.out.println("Input tidak valid");
                        nextLine();
                    }
                }
            }
            else if (nomor.equals(12)) {
                System.out.println(""); //arahan permainan
                nextLine();
            } 
            else if (nomor.equals(13)) {
                System.out.println("Apakah Anda yakin ingin keluar? (y/n)");
                String jawaban = input.next();
                if (jawaban.equals("y")) {
                    System.out.println("Terima kasih telah bermain");
                    break;
                }
                else if (jawaban.equals("n")) {
                    nextLine();
                    continue;
                }
                else {
                    System.out.println("Input tidak valid");
                    nextLine();
                }
            }
            else {
                System.out.println("Input tidak valid");
                nextLine();
            }
        }
    }
}
