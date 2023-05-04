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
        ArrayList<Sim> simList = new ArrayList<Sim>();
        Scanner input = new Scanner(System.in);
        // Membuat Sim di awal game
        System.out.println("Masukkan nama sim: ");
        String nama = input.nextLine();
        Sim sim = new Sim(nama, null, 100, 80, 80, "idle", 80, true);
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
        Rumah rumah = new Rumah(x, y);
        world.tambahRumah(namaRumah, rumah);
        sim.setRuangan((rumah.getListRuanganRumah().get(0)));
        sim.setRumah(rumah);
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
                System.out.println("Pekerjaan anda: " + currentSim.getPekerjaan());
                System.out.println("Status anda: " + currentSim.getAksi());
                System.out.println("Uang anda: " + currentSim.getUang());
                nextLine();
            }
            else if (nomor.equals(2)) {
                world.printWorld();
                world.printRumah();
                System.out.println("Saat ini "+ currentSim.getNama() + " berada dalam " + world.getDaftarRumah() + " pada ruangan " + sim.getRuangan().getNamaRuangan());
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
                                sim.doTidur(sim.getKesehatan(), sim.getMood());
                                System.out.println("Anda sudah selesai tidur");
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
                                sim.doTidur(sim.getKesehatan(), sim.getMood());
                                System.out.println("Anda sudah selesai tidur");
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
                                sim.doTidur(sim.getKesehatan(), sim.getMood());
                                System.out.println("Anda sudah selesai tidur");
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
                                sim.doBuangAir(sim.getKesehatan(), sim.getMood());
                                System.out.println("Anda sudah selesai buang air");
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
                                            sim.doMasakNasiAyam(sim.getMood());
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
                                            sim.doMasakNasiKari(sim.getMood());
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
                                            sim.doMasakSususKacang(sim.getMood());
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
                                            sim.doMasakTumisSayur(sim.getMood());
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
                                            sim.doMasakBistik(sim.getMood());
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
                                            sim.doMasakNasiAyam(sim.getMood());
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
                                            sim.doMasakNasiKari(sim.getMood());
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
                                            sim.doMasakSususKacang(sim.getMood());
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
                                            sim.doMasakTumisSayur(sim.getMood());
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
                                            sim.doMasakBistik(sim.getMood());
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
                                    sim.doMakan("Nasi Kari");
                                    System.out.println("Anda sudah selesai makan");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Nasi Ayam")) {
                                    sim.doMakan("Nasi Ayam");
                                    masakan.cekMasakan("Nasi Ayam");
                                    System.out.println("Anda sudah selesai makan");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Susu Kacang")) {
                                    sim.doMakan("Susu Kacang");
                                    masakan.cekMasakan("Susu Kacang");
                                    System.out.println("Anda sudah selesai makan");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Tumis Sayur")) {
                                    masakan.cekMasakan("Tumis Sayur");
                                    sim.doMakan("Tumis Sayur");
                                    System.out.println("Anda sudah selesai makan");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Bistik")) {
                                    masakan.cekMasakan("Bistik");
                                    sim.doMakan("Bistik");
                                    System.out.println("Anda sudah selesai makan");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Nasi")) {
                                    bahanMakanan.cekBahan("Nasi");
                                    sim.doMakan("Nasi");
                                    System.out.println("Anda sudah selesai makan");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Kentang")) {
                                    bahanMakanan.cekBahan("Kentang");
                                    sim.doMakan("Kentang");
                                    System.out.println("Anda sudah selesai makan");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Ayam")) {
                                    bahanMakanan.cekBahan("Ayam");
                                    sim.doMakan("Ayam");
                                    System.out.println("Anda sudah selesai makan");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Sapi")) {
                                    bahanMakanan.cekBahan("Sapi");
                                    sim.doMakan("Sapi");
                                    System.out.println("Anda sudah selesai makan");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Kacang")) {
                                    bahanMakanan.cekBahan("Kacang");
                                    sim.doMakan("Kacang");
                                    System.out.println("Anda sudah selesai makan");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Susu")) {
                                    bahanMakanan.cekBahan("Susu");
                                    sim.doMakan("Susu");
                                    System.out.println("Anda sudah selesai makan");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Wortel")) {
                                    bahanMakanan.cekBahan("Wortel");
                                    sim.doMakan("Wortel");
                                    System.out.println("Anda sudah selesai makan");
                                    nextLine();
                                }
                                else if (jawaban2.equals("Bayam")) {
                                    bahanMakanan.cekBahan("Bayam");
                                    sim.doMakan("Bayam");
                                    System.out.println("Anda sudah selesai makan");
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
                                sim.doLihatWaktu();
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
                                sim.doOlahraga(sim.getKesehatan(), sim.getKekenyangan(), sim.getMood());
                                System.out.println("Anda sudah selesai berolahraga");
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
                                sim.doMainGitar(sim.getMood(), sim.getKekenyangan());
                                System.out.println("Anda sudah selesai bermain gitar");
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
                                sim.doMenyapu(sim.getMood(), sim.getKekenyangan());
                                System.out.println("Anda sudah selesai menyapu");
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
                                sim.doMenonton(sim.getMood(), sim.getKekenyangan());
                                System.out.println("Anda sudah selesai menonton");
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
                                sim.doIbadah(sim.getMood(), sim.getKesehatan());
                                System.out.println("Anda sudah selesai beribadah");
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
                                sim.doBaca(sim.getMood(), sim.getKekenyangan());
                                System.out.println("Anda sudah selesai membaca");
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
                                sim.doGantiBaju(sim.getMood());
                                System.out.println("Anda sudah selesai mengganti baju");
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
                    sim.doKerja(sim.getKekenyangan(), sim.getMood());
                    nextLine();
                }
                else if (pilihan.equals(2)) {
                    System.out.println("Anda sedang berkunjung ke rumah teman");
                    sim.doBerkunjung(sim.getMood(), sim.getKekenyangan());
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
                                System.out.println("Makanan anda sedang diantar, harap menunggu");
                                sim.doBeliMakanan("Nasi");
                                bahanMakanan.tambahBahanMakanan("Nasi");
                                System.out.println("Makanan berhasil dibeli dan dimasukkan ke dalam inventory");
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
                        else if (pilihan3.equals(2)) {
                            System.out.println("Apakah anda ingin membeli kentang? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                System.out.println("Makanan anda sedang diantar, harap menunggu");
                                sim.doBeliMakanan("Kentang");
                                bahanMakanan.tambahBahanMakanan("Kentang");
                                System.out.println("Makanan berhasil dibeli dan dimasukkan ke dalam inventory");
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
                                System.out.println("Makanan anda sedang diantar, harap menunggu");
                                sim.doBeliMakanan("Ayam");
                                bahanMakanan.tambahBahanMakanan("Ayam");
                                System.out.println("Makanan berhasil dibeli dan dimasukkan ke dalam inventory");
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
                                System.out.println("Makanan anda sedang diantar, harap menunggu");
                                sim.doBeliMakanan("Sapi");
                                bahanMakanan.tambahBahanMakanan("Sapi");
                                System.out.println("Makanan berhasil dibeli dan dimasukkan ke dalam inventory");
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
                                System.out.println("Makanan anda sedang diantar, harap menunggu");
                                sim.doBeliMakanan("Wortel");
                                bahanMakanan.tambahBahanMakanan("Wortel");
                                System.out.println("Makanan berhasil dibeli dan dimasukkan ke dalam inventory");
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
                                System.out.println("Makanan anda sedang diantar, harap menunggu");
                                sim.doBeliMakanan("Bayam");
                                bahanMakanan.tambahBahanMakanan("Bayam");
                                System.out.println("Makanan berhasil dibeli dan dimasukkan ke dalam inventory");
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
                                System.out.println("Makanan anda sedang diantar, harap menunggu");
                                sim.doBeliMakanan("Kacang");
                                bahanMakanan.tambahBahanMakanan("Kacang");
                                System.out.println("Makanan berhasil dibeli dan dimasukkan ke dalam inventory");
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
                                System.out.println("Makanan anda sedang diantar, harap menunggu");
                                sim.doBeliMakanan("Susu");
                                bahanMakanan.tambahBahanMakanan("Susu");
                                System.out.println("Makanan berhasil dibeli dan dimasukkan ke dalam inventory");
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
                            System.out.println("Barang anda sedang diantar, harap menunggu");
                            sim.beliBarang("Toilet");
                            barang.tambahBarang("Toilet");
                            System.out.println("Barang berhasil dibeli dan dimasukkan ke dalam inventory");
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
                            System.out.println("Barang anda sedang diantar, harap menunggu");
                            sim.beliBarang("Jam");
                            barang.tambahBarang("Jam");
                            System.out.println("Barang berhasil dibeli dan dimasukkan ke dalam inventory");
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
                            System.out.println("Barang anda sedang diantar, harap menunggu");
                            sim.beliBarang("Treadmill");
                            barang.tambahBarang("Treadmill");
                            System.out.println("Barang berhasil dibeli dan dimasukkan ke dalam inventory");
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
                            System.out.println("Barang anda sedang diantar, harap menunggu");
                            sim.beliBarang("Gitar");
                            barang.tambahBarang("Gitar");
                            System.out.println("Barang berhasil dibeli dan dimasukkan ke dalam inventory");
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
                            System.out.println("Barang anda sedang diantar, harap menunggu");
                            sim.beliBarang("Sapu");
                            barang.tambahBarang("Sapu");
                            System.out.println("Barang berhasil dibeli dan dimasukkan ke dalam inventory");
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
                            System.out.println("Barang anda sedang diantar, harap menunggu");
                            sim.beliBarang("Tv");
                            barang.tambahBarang("Tv");
                            System.out.println("Barang berhasil dibeli dan dimasukkan ke dalam inventory");
                            nextLine();
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
                            System.out.println("Barang anda sedang diantar, harap menunggu");
                            sim.beliBarang("Sajadah");
                            barang.tambahBarang("Sajadah");
                            System.out.println("Barang berhasil dibeli dan dimasukkan ke dalam inventory");
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
                            System.out.println("Barang anda sedang diantar, harap menunggu");
                            sim.beliBarang("Buku");
                            barang.tambahBarang("Buku");
                            System.out.println("Barang berhasil dibeli dan dimasukkan ke dalam inventory");
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
                            System.out.println("Barang anda sedang diantar, harap menunggu");
                            sim.beliBarang("Baju");
                            barang.tambahBarang("Baju");
                            System.out.println("Barang berhasil dibeli dan dimasukkan ke dalam inventory");
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
                            System.out.println("Barang anda sedang diantar, harap menunggu");
                            sim.beliBarang("Kasur Single");
                            barang.tambahBarang("Kasur Single");
                            System.out.println("Barang berhasil dibeli dan dimasukkan ke dalam inventory");
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
                            System.out.println("Barang anda sedang diantar, harap menunggu");
                            sim.beliBarang("Kasur Queen Size");
                            barang.tambahBarang("Kasur Queen Size");
                            System.out.println("Barang berhasil dibeli dan dimasukkan ke dalam inventory");
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
                            System.out.println("Barang anda sedang diantar, harap menunggu");
                            sim.beliBarang("Kasur King Size");
                            barang.tambahBarang("Kasur King Size");
                            System.out.println("Barang berhasil dibeli dan dimasukkan ke dalam inventory");
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
                            System.out.println("Barang anda sedang diantar, harap menunggu");
                            sim.beliBarang("Kompor Gas");
                            barang.tambahBarang("Kompor Gas");
                            System.out.println("Barang berhasil dibeli dan dimasukkan ke dalam inventory");
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
                            System.out.println("Barang anda sedang diantar, harap menunggu");
                            sim.beliBarang("Kompor Listrik");
                            barang.tambahBarang("Kompor Listrik");
                            System.out.println("Barang berhasil dibeli dan dimasukkan ke dalam inventory");
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
                            System.out.println("Barang anda sedang diantar, harap menunggu");
                            sim.beliBarang("Meja dan Kursi");
                            barang.tambahBarang("Meja dan Kursi");
                            System.out.println("Barang berhasil dibeli dan dimasukkan ke dalam inventory");
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
