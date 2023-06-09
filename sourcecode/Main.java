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
        System.out.println(" ██████╗ ███╗   ██╗███╗   ███╗ ██████╗ ");
        System.out.println(" ██╔══██╗████╗  ██║████╗ ████║██╔═══██╗");
        System.out.println(" ██████╔╝██╔██╗ ██║██╔████╔██║██║   ██║");
        System.out.println(" ██╔══██╗██║╚██╗██║██║╚██╔╝██║██║   ██║");
        System.out.println(" ██████╔╝██║ ╚████║██║ ╚═╝ ██║╚██████╔╝");
        System.out.println(" ╚═════╝ ╚═╝  ╚═══╝╚═╝     ╚═╝ ╚═════╝ ");
        nextLine();
        System.out.println("S = I = M = P = L = I = C = I = T = Y = S = I = M = P = L = I = C = I = T = Y = S = I = M = P"); 
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - -");             
        System.out.println(". . . . . . . .  . . . . . . . . .  WELCOME TO SIMPLICITY . . . . . . . .  . . . . . . . . . ");
        System.out.println(". . . . . . . .  . . . . . . . . .  WELCOME TO SIMPLICITY . . . . . . . .  . . . . . . . . . ");
        System.out.println("= = = = S I M P L I C I T Y = = = = = = = = = = = = = = = = = S I M P L I C T Y = = = = = = =");
        System.out.println("= = = = S I M P L I C I T Y = = = = = = = = = = = = = = = = = S I M P L I C T Y = = = = = = =");
        System.out.println(". . . . . . . .  . . . . . . . . .  WELCOME TO SIMPLICITY . . . . . . . .  . . . . . . . . .");
        System.out.println(". . . . . . . .  . . . . . . . . .  WELCOME TO SIMPLICITY . . . . . . . .  . . . . . . . . .");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - -");       
        System.out.println("S = I = M = P = L = I = C = I = T = Y = S = I = M = P = L = I = C = I = T = Y = S = I = M = P");       
        System.out.println("\n\n                              S E L A M A T B E R M A I N\n\n");       
        // Scanner
        Scanner input = new Scanner(System.in);
        // Waktu waktu = new Waktu();
        // waktu.startGame();
        World world = new World(64, 64);
        // Membuat ArrayList untuk simList dan rumahList
        ArrayList<Sim> simList = new ArrayList<Sim>();
        ArrayList<Rumah> rumahList = new ArrayList<Rumah>();
        System.out.println("... Membuat Karakter Awal SIM ...\n");
        // Membuat Sim di awal game
        System.out.println("Masukkan nama sim: ");
        String nama = input.nextLine();
        
        Pekerjaan pekerjaan = new Pekerjaan();
        pekerjaan.getRandomPekerjaan();

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
        while (x > 64) {
            System.out.println("Posisi x tidak valid");
            System.out.println("Masukkan posisi x rumah: ");
            x = input.nextInt();
        }
        System.out.println("Masukkan posisi y rumah: ");
        int y = input.nextInt();
        while (y > 64) {
            System.out.println("Posisi y tidak valid");
            System.out.println("Masukkan posisi y rumah: ");
            y = input.nextInt();
        }
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
                System.out.println("\n=== SIM INFO ===");
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
                System.out.println("\n=== CURRENT LOCATION ===");
                world.printWorld();
                world.printRumah();
                System.out.println("Saat ini "+ currentSim.getNama() + " berada dalam " + currentSim.getRumah().getNamarumah() + " pada ruangan " + currentSim.getRuangan().getNamaRuangan());
                nextLine();
                // System.out.println("Saat ini " + sim.getNama() + " berada di ruangan " + sim.getRuangan().getNamaRuangan());
            }
            else if (nomor.equals(3)) {
                System.out.println("\n=== VIEW INVENTORY ===");
                System.out.println("Inventory anda: ");
                bahanMakanan.printBahanMakanan();
                masakan.printMakanan();
                barang.printBarangInventory();
                nextLine();
            }
            else if (nomor.equals(4)) {
                System.out.println("\n=== UPGRADE HOUSE ===");
                if (currentSim.getRuangan() == (currentSim.getRumah().getListRuanganRumah().get(0))){
                    System.out.println("\n=== DAFTAR RUANGAN DALAM RUMAH ===");
                    for(int i = 0; i < currentSim.getRumah().getListRuanganRumah().size(); i++) {
                        System.out.println((i+1) + "." + currentSim.getRumah().getListRuanganRumah().get(i).getNamaRuangan());
                    }
                    System.out.println("\nMasukkan nomor arah tambahan ruangan yang ingin dibuat: ");
                    System.out.println("1. Atas");
                    System.out.println("2. Bawah");
                    System.out.println("3. Kanan");
                    System.out.println("4. Kiri");
                    int arah = input.nextInt();
                    
                    if (arah == 1){
                        if (currentSim.getRuangan().getListRuanganTetangga()[0] != null) {
                            System.out.println("\nBagian Atas sudah terisi ruangan!");
                        } else {
                            System.out.print("\nMasukkan nama ruangan baru yang ingin ditambah: ");
                            String trash = input.nextLine();
                            String namaRuangan = input.nextLine();
                            Ruangan tetangga = new Ruangan(namaRuangan, 6, 6);
                            for (Rumah rum : rumahList) {
                                if (rum.getNamarumah().equals(currentSim.getRumah().getNamarumah())) {
                                    currentSim.getRuangan().getListRuanganTetangga()[0] = tetangga;
                                    currentSim.getRumah().getListRuanganRumah().add(tetangga);
                                }
                            }
                        }
                    } else if (arah == 2) {
                        if (currentSim.getRuangan().getListRuanganTetangga()[1] != null) {
                            System.out.println("\nBagian Bawah sudah terisi ruangan!");
                        } else {
                            System.out.print("\nMasukkan nama ruangan baru yang ingin ditambah: ");
                            String trash = input.nextLine();
                            String namaRuangan = input.nextLine();
                            Ruangan tetangga = new Ruangan(namaRuangan, 6, 6);
                            for (Rumah rum : rumahList) {
                                if (rum.getNamarumah().equals(currentSim.getRumah().getNamarumah())) {
                                    currentSim.getRuangan().getListRuanganTetangga()[1] = tetangga;
                                    currentSim.getRumah().getListRuanganRumah().add(tetangga);
                                }
                            }
                        }
                    } else if (arah == 3) {
                        if (currentSim.getRuangan().getListRuanganTetangga()[2] != null) {
                            System.out.println("\nBagian Kanan sudah terisi ruangan!");
                        } else {
                            System.out.print("\nMasukkan nama ruangan baru yang ingin ditambah: ");
                            String trash = input.nextLine();
                            String namaRuangan = input.nextLine();
                            Ruangan tetangga = new Ruangan(namaRuangan, 6, 6);
                            for (Rumah rum : rumahList) {
                                if (rum.getNamarumah().equals(currentSim.getRumah().getNamarumah())) {
                                    currentSim.getRuangan().getListRuanganTetangga()[2] = tetangga;
                                    currentSim.getRumah().getListRuanganRumah().add(tetangga);
                                }
                            }
                        }
                    } else if (arah == 4) {
                        if (currentSim.getRuangan().getListRuanganTetangga()[3] != null) {
                            System.out.println("\nBagian Kiri sudah terisi ruangan!");
                        } else {
                            System.out.print("\nMasukkan nama ruangan baru yang ingin ditambah: ");
                            String trash = input.nextLine();
                            String namaRuangan = input.nextLine();
                            Ruangan tetangga = new Ruangan(namaRuangan, 6, 6);
                            for (Rumah rum : rumahList) {
                                if (rum.getNamarumah().equals(currentSim.getRumah().getNamarumah())) {
                                    currentSim.getRuangan().getListRuanganTetangga()[3] = tetangga;
                                    currentSim.getRumah().getListRuanganRumah().add(tetangga);
                                }
                            }
                        }
                    }
                    // Menampilkan daftar ruangan dalam rumah setelah ditambah
                    System.out.println("\n=== DAFTAR RUANGAN DALAM RUMAH ===");
                    for(int i = 0; i < currentSim.getRumah().getListRuanganRumah().size(); i++) {
                        System.out.println((i+1) + "." + currentSim.getRumah().getListRuanganRumah().get(i).getNamaRuangan());
                    }
                } else {
                    System.out.println("Anda harus pindah ke kamar utama terlebih dahulu!");
                }
                nextLine();
            }
            else if (nomor.equals(5)) {
                System.out.println("\n=== MOVE ROOM ===");
                // Menampilkan status keberadaan Sim saat ini
                System.out.println("Ruangan yang Anda tempati sekarang : " + currentSim.getRuangan().getNamaRuangan() + "\n");
                // Menampilkan daftar ruangan di dalam Rumah
                System.out.println("=== DAFTAR RUANGAN DALAM RUMAH ===");
                for(int i = 0; i < currentSim.getRumah().getListRuanganRumah().size(); i++) {
                    System.out.println((i+1) + "." + currentSim.getRumah().getListRuanganRumah().get(i).getNamaRuangan());
                }
                System.out.println("Ke ruangan apa Anda ingin berpindah?");
                String trash = input.nextLine();
                String namaruangpindah = input.nextLine();
                boolean isExist = false;
                while (!isExist){
                    for (Ruangan r : currentSim.getRumah().getListRuanganRumah()) {
                        if (r.getNamaRuangan().equals(namaruangpindah)) {
                            currentSim.setRuangan(r); // Mengganti currentSim yang aktif menjadi Sim yang ingin dimainkan
                            isExist = true;
                        }
                    }
                    if (!isExist){ // Kondisi apabila nama yang diinput tidak ada dalam simList
                        System.out.println("Ruangan tidak tersedia, Input nama lain!");
                        namaruangpindah = input.nextLine();
                    }
                }
                // Menampilkan Sim yang sekarang aktif (sedang dimainkan)
                System.out.println("Ruangan yang Anda tempati sekarang : " + namaruangpindah + "\n");
                // scanner.close();
                nextLine();
            }
            else if (nomor.equals(6)) {
                System.out.println("=== EDIT ROOM ===");
                System.out.println("1. Membeli Barang Baru");
                System.out.println("2. Menambahkan atau Memindahkan Barang");
                System.out.println("Masukkan opsi yang ingin Anda lakukan (dalam angka):");
                int piledit = input.nextInt();
                if (piledit == 1){
                    System.out.println("### Tampilan Ruangan ###");
                    currentSim.getRuangan().tampilkanRuangan();
                    System.out.println("Barang yang ingin Anda beli:");
                    String trash = input.nextLine();
                    String barangbeli = input.nextLine();
                    currentSim.beliBarang(barangbeli);
                } else if (piledit == 2) {
                    System.out.println("Menambahkan (1) atau Memindahkan (2)?");
                    int piledit1 = input.nextInt();
                    if (piledit1 == 1) {
                        // Menampilkan tampilan ruangan
                        System.out.println("### Tampilan Ruangan ###");
                        currentSim.getRuangan().tampilkanRuangan();
                        
                        // Menampilkan barang yang dimiliki di inventory
                        System.out.println("Barang di Inventory Anda :");
                        barang.printBarangInventory();
                        
                        // Menerima input barang yang ingin ditambah ke ruangan
                        System.out.println("\nBarang apa yang ingin Anda tambahkan?");
                        System.out.println("Ingat, hanya barang yang ada di inventory Anda yang bisa ditambah ke ruangan!");
                        String trash = input.nextLine();
                        String barangEdit = input.nextLine();
                        currentSim.getRuangan().tambahBarang(barangEdit);
                        
                        // Menampilkan ruangan dan barang yang ada di ruangan
                        System.out.println("### Tampilan Ruangan ###");              
                        currentSim.getRuangan().tampilkanRuangan();
                        currentSim.getRuangan().printBarangRuangan();
                    } else if (piledit1 == 2){
                        System.out.println("### Tampilan Ruangan ###");
                        currentSim.getRuangan().tampilkanRuangan();
                        
                        // Menerima input barang yang ingin dipindahkan ke ruangan
                        System.out.println("\nBarang apa yang ingin Anda pindahkan?");
                        String trash = input.nextLine();
                        String barangEdit = input.nextLine();
                        
                        // Remove barang dari list barang di ruangan
                        currentSim.getRuangan().removeBarang(barangEdit);
                        System.out.println("... Pemindahan barang ...");
                        currentSim.getRuangan().tambahBarang(barangEdit);
                        
                        // Menampilkan ruangan setelah barang dipindah
                        System.out.println("### Tampilan Ruangan ###");
                        currentSim.getRuangan().tampilkanRuangan();
                        
                        // Menampilkan barang yang ada di ruangan
                        currentSim.getRuangan().printBarangRuangan();                        
                    }
                }
                nextLine();
            }
            else if (nomor.equals(7)) {
                System.out.println("\n=== ADD SIM ===");
                // Menerima input nama Sim yang ingin ditambah
                int i = 1;   
                String trash = input.nextLine();
                System.out.println("Masukkan nama sim yang ingin ditambah !");           
                String nama1 = input.nextLine();

                Pekerjaan pekerjaan1 = new Pekerjaan();
                pekerjaan1.getRandomPekerjaan();

                // Menambahkan Sim baru ke simList
                simList.add(new Sim(nama1, pekerjaan1, 100, 80, 80, "idle", 80, false));
                // Menambah Rumah baru untuk Sim baru
                System.out.println("Masukkan nama rumah: ");
                String namaRumah1 = input.nextLine();
                // world.tambahRumah(nama, null);
                System.out.println("Masukkan posisi x rumah: ");
                int x1 = input.nextInt();
                System.out.println("Masukkan posisi y rumah: ");
                int y1 = input.nextInt();
                Rumah rumah1 = new Rumah(namaRumah1, x1, y1);
                while (x1 > 64) {
                    System.out.println("Posisi x tidak valid");
                    System.out.println("Masukkan posisi x rumah: ");
                    x = input.nextInt();
                }
                if (x1 <= 64){
                    if (world.cekRumah(rumah1) == false){
                        System.out.println("Masukkan posisi x rumah: ");
                        y = input.nextInt();
                    }
                }
                while (y1 > 64) {
                    System.out.println("Posisi y tidak valid");
                    System.out.println("Masukkan posisi y rumah: ");
                    y = input.nextInt();
                }
                if (y1 <= 64){
                    if (world.cekRumah(rumah1) == false){
                        System.out.println("Masukkan posisi y rumah: ");
                        y = input.nextInt();
                    }
                }
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
                System.out.println("\n=== CHANGE SIM ===");
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
                                    masakan.useMakanan("Nasi Kari");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Nasi Ayam")) {
                                    currentSim.doMakan("Nasi Ayam");
                                    masakan.cekMasakan("Nasi Ayam");
                                    masakan.useMakanan("Nasi Ayam");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Susu Kacang")) {
                                    currentSim.doMakan("Susu Kacang");
                                    masakan.cekMasakan("Susu Kacang");
                                    masakan.useMakanan("Susu Kacang");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Tumis Sayur")) {
                                    masakan.cekMasakan("Tumis Sayur");
                                    currentSim.doMakan("Tumis Sayur");
                                    masakan.useMakanan("Tumis Sayur");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Bistik")) {
                                    masakan.cekMasakan("Bistik");
                                    currentSim.doMakan("Bistik");
                                    masakan.useMakanan("Bistik");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Nasi")) {
                                    bahanMakanan.cekBahan("Nasi");
                                    currentSim.doMakan("Nasi");
                                    bahanMakanan.hapusBahanMakanan("Nasi");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Kentang")) {
                                    bahanMakanan.cekBahan("Kentang");
                                    currentSim.doMakan("Kentang");
                                    bahanMakanan.hapusBahanMakanan("Kentang");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Ayam")) {
                                    bahanMakanan.cekBahan("Ayam");
                                    currentSim.doMakan("Ayam");
                                    bahanMakanan.hapusBahanMakanan("Ayam");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Sapi")) {
                                    bahanMakanan.cekBahan("Sapi");
                                    currentSim.doMakan("Sapi");
                                    bahanMakanan.hapusBahanMakanan("Sapi");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Kacang")) {
                                    bahanMakanan.cekBahan("Kacang");
                                    currentSim.doMakan("Kacang");
                                    bahanMakanan.hapusBahanMakanan("Kacang");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Susu")) {
                                    bahanMakanan.cekBahan("Susu");
                                    currentSim.doMakan("Susu");
                                    bahanMakanan.hapusBahanMakanan("Susu");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Wortel")) {
                                    bahanMakanan.cekBahan("Wortel");
                                    currentSim.doMakan("Wortel");
                                    bahanMakanan.hapusBahanMakanan("Wortel");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Bayam")) {
                                    bahanMakanan.cekBahan("Bayam");
                                    currentSim.doMakan("Bayam");
                                    bahanMakanan.hapusBahanMakanan("Bayam");
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
                    if (currentSim.getJumlahDoKerja() > 3){
                        System.out.println("Apakah anda ingin mengganti pekerjaan? (y/n)");
                        String pilihkerja = input.next();
                        if(pilihkerja.equals("y")){
                            pekerjaan.printDaftarPekerjaan();
                            System.out.println("Masukkan nama pekerjaan yang diinginkan : ");
                            Scanner namaKerja = new Scanner(System.in);
                            String pekerjaanBaru = namaKerja.nextLine();
                            pekerjaan.getPekerjaan();
                            pekerjaan.setGantiPekerjaan(pekerjaanBaru);
                            pekerjaan.printPekerjaan();
                            pekerjaan.gajibarupertama();
                            pekerjaan.printGajiPertama();
                            currentSim.setJumlahDoKerja(0);
                            currentSim.setWaktuCuti(11);
                            currentSim.doCuti();
                            currentSim.doPertamaKerja(currentSim.getKekenyangan(), currentSim.getMood());
                            System.out.println("Gaji selanjutnya akan kembali " + pekerjaan.getGaji());
                        } else {
                            System.out.println("Anda sedang bekerja");
                            currentSim.doKerja(currentSim.getKekenyangan(), currentSim.getMood());
                            currentSim.setJumlahDoKerja(currentSim.getJumlahDoKerja() + 1);
                            currentSim.printjumlahdoKerja();
                        } 
                        } else {
                        System.out.println("Anda sedang bekerja");
                        pekerjaan.resetGajiPertama();
                        currentSim.doKerja(currentSim.getKekenyangan(), currentSim.getMood());
                        currentSim.setJumlahDoKerja(currentSim.getJumlahDoKerja());
                        currentSim.printjumlahdoKerja();
                        nextLine();
                    }
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
                                if(sim.getUang() >= bahanMakanan.hargas[1]) {
                                    currentSim.doBeliMakanan("Kentang");
                                    bahanMakanan.tambahBahanMakanan("Kentang");
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
                        else if (pilihan3.equals(3)) {
                            System.out.println("Apakah anda ingin membeli ayam? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                if(sim.getUang() >= bahanMakanan.hargas[2]) {
                                    currentSim.doBeliMakanan("Ayam");
                                    bahanMakanan.tambahBahanMakanan("Ayam");
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
                        else if (pilihan3.equals(4)) {
                            System.out.println("Apakah anda ingin membeli sapi? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                if(sim.getUang() >= bahanMakanan.hargas[3]) {
                                    currentSim.doBeliMakanan("Sapi");
                                    bahanMakanan.tambahBahanMakanan("Sapi");
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
                        else if (pilihan3.equals(5)) {
                            System.out.println("Apakah anda ingin membeli wortel? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                if(sim.getUang() >= bahanMakanan.hargas[4]) {
                                    currentSim.doBeliMakanan("Wortel");
                                    bahanMakanan.tambahBahanMakanan("Wortel");
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
                        else if (pilihan3.equals(6)) {
                            System.out.println("Apakah anda ingin membeli bayam? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                if(sim.getUang() >= bahanMakanan.hargas[5]) {
                                    currentSim.doBeliMakanan("Bayam");
                                    bahanMakanan.tambahBahanMakanan("Bayam");
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
                        else if (pilihan3.equals(7)) {
                            System.out.println("Apakah anda ingin membeli kacang? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                if(sim.getUang() >= bahanMakanan.hargas[6]) {
                                    currentSim.doBeliMakanan("Kacang");
                                    bahanMakanan.tambahBahanMakanan("Kacang");
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
                        else if (pilihan3.equals(8)) {
                            System.out.println("Apakah anda ingin membeli susu? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                if(sim.getUang() >= bahanMakanan.hargas[7]) {
                                    currentSim.doBeliMakanan("Susu");
                                    bahanMakanan.tambahBahanMakanan("Susu");
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
                        else {
                            System.out.println("Input tidak valid");
                            nextLine();
                        }
                    }
                    else if (pilihan2.equals(2)) {
                        System.out.println("Apakah anda ingin membeli toilet?(y/n)");
                        String jawaban2 = input.next();
                        if (jawaban2.equals("y")) {
                            if (sim.getUang() >= barang.hargas[3]) {
                                currentSim.beliBarang("Toilet");
                                barang.tambahBarang("Toilet");
                                nextLine();
                            }
                            else {
                                System.out.println("Uang anda tidak cukup");
                                nextLine();
                            }
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
                            if (sim.getUang() >= barang.hargas[7]) {
                                currentSim.beliBarang("Jam");
                                barang.tambahBarang("Jam");
                                nextLine();
                            }
                            else {
                                System.out.println("Uang anda tidak cukup");
                                nextLine();
                            }
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
                            if (sim.getUang() >= barang.hargas[8]) {
                                currentSim.beliBarang("Treadmill");
                                barang.tambahBarang("Treadmill");
                                nextLine();
                            }
                            else {
                                System.out.println("Uang anda tidak cukup");
                                nextLine();
                            }
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
                            if (sim.getUang() >= barang.hargas[9]) {
                                currentSim.beliBarang("Gitar");
                                barang.tambahBarang("Gitar");
                                nextLine();
                            }
                            else {
                                System.out.println("Uang anda tidak cukup");
                                nextLine();
                            }
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
                            if (sim.getUang() >= barang.hargas[10]) {
                                currentSim.beliBarang("Sapu");
                                barang.tambahBarang("Sapu");
                                nextLine();
                            }
                            else {
                                System.out.println("Uang anda tidak cukup");
                                nextLine();
                            }
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
                            if (sim.getUang() >= barang.hargas[12]) {
                                currentSim.beliBarang("Sajadah");
                                barang.tambahBarang("Sajadah");
                                nextLine();
                            }
                            else {
                                System.out.println("Uang anda tidak cukup");
                                nextLine();
                            }
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
                            if (sim.getUang() >= barang.hargas[13]) {
                                currentSim.beliBarang("Buku");
                                barang.tambahBarang("Buku");
                                nextLine();
                            }
                            else {
                                System.out.println("Uang anda tidak cukup");
                                nextLine();
                            }
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
                            if (sim.getUang() >= barang.hargas[14]) {
                                currentSim.beliBarang("Baju");
                                barang.tambahBarang("Baju");
                                nextLine();
                            }
                            else {
                                System.out.println("Uang anda tidak cukup");
                                nextLine();
                            }
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
                            if (sim.getUang() >= barang.hargas[0]) {
                                currentSim.beliBarang("Kasur Single");
                                barang.tambahBarang("Kasur Single");
                                nextLine();
                            }
                            else {
                                System.out.println("Uang anda tidak cukup");
                                nextLine();
                            }
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
                            if (sim.getUang() >= barang.hargas[1]) {
                                currentSim.beliBarang("Kasur Queen Size");
                                barang.tambahBarang("Kasur Queen Size");
                                nextLine();
                            }
                            else {
                                System.out.println("Uang anda tidak cukup");
                                nextLine();
                            }
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
                            if (sim.getUang() >= barang.hargas[2]) {
                                currentSim.beliBarang("Kasur King Size");
                                barang.tambahBarang("Kasur King Size");
                                nextLine();
                            }
                            else {
                                System.out.println("Uang anda tidak cukup");
                                nextLine();
                            }
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
                            if (sim.getUang() >= barang.hargas[4]) {
                                currentSim.beliBarang("Kompor Gas");
                                barang.tambahBarang("Kompor Gas");
                                nextLine();
                            }
                            else {
                                System.out.println("Uang anda tidak cukup");
                                nextLine();
                            }
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
                            if (sim.getUang() >= barang.hargas[5]) {
                                currentSim.beliBarang("Kompor Listrik");
                                barang.tambahBarang("Kompor Listrik");
                                nextLine();
                            }
                            else {
                                System.out.println("Uang anda tidak cukup");
                                nextLine();
                            }
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
                            if (sim.getUang() >= barang.hargas[6]) {
                                currentSim.beliBarang("Meja dan Kursi");
                                barang.tambahBarang("Meja dan Kursi");
                                nextLine();
                            }
                            else {
                                System.out.println("Uang anda tidak cukup");
                                nextLine();
                            }
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
                System.out.println("============================================= HELP ============================================="); //arahan permainan
                System.out.println("\nSimplicity adalah permainan yang menggambarkan kehidupan sehari-hari.");
                System.out.println("Permainan ini terdiri dari Sim yang memiliki Rumah. Setiap Rumah memiliki maksimal 5 ruangan.");
                System.out.println("Setiap ruangan bisa diisi oleh beberapa objek yang bisa dibeli atau sudah dimiliki pada awal permainan");
                System.out.println("Sim juga bisa makan, berkunjung ke rumah Sim lain, dan aksi lainnya yang cukup bervariatif.");
                System.out.println("\n**************************************** CARA BERMAIN ****************************************");
                System.out.println("1. Pemain akan diminta untuk memasukkan nama Sim, Rumah, beserta koordinat Rumah pada awal keberjalanan game");
                System.out.println("2. Setiap Sim akan memiliki pekerjaan yang akan dipilih secara acak oleh program");
                System.out.println("3. Setiap Sim memiliki tingkat kesejahteraan (mood, kekenyangan, dan kesehatan) yang diset 80 pada awal permainan");
                System.out.println("4. Setiap Sim memiliki uang sejumlah 100 pada awal permainan");
                System.out.println("5. Akan tersedia beberapa menu di dalam game yang akan langsung ditampilkan di awal keberjalanan game");
                System.out.println("6. Seiring berjalannya aktivitas dan kegiatan lainnya, memungkinkan Sim untuk meninggal dunia dan game akan berakhir");
                System.out.println("7. Waktu total dalam sehari yaitu 12 menit kehidupan nyata dan waktu akan berkurang untuk beberapa aksi ketika dilakukan");
                System.out.println("\n======================================= SELAMAT BERMAIN =======================================");
                nextLine();
            } 
            else if (nomor.equals(13)) {
                System.out.println("Apakah Anda yakin ingin keluar? (YES/NO)");
                String jawaban = input.next();
                if (jawaban.equals("YES")) {
                    System.out.println("Terima kasih telah bermain");
                    break;
                }
                else if (jawaban.equals("NO")) {
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
