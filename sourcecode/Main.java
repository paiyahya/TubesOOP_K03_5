import java.util.Scanner;

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
        Sim sim = new Sim(null, null, 100, 80, 80, "idle", 80);
        System.out.println("Masukkan nama sim: ");
        Scanner input = new Scanner(System.in);
        Waktu waktu = new Waktu();
        String nama = input.nextLine();
        sim.setNama(nama);
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
        world.tambahRumah(nama, rumah);
        sim.setRuangan((rumah.getListRuanganRumah().get(0)));
        Barang barang = new Barang(0);
        BahanMakanan bahanMakanan = new BahanMakanan(0);
        nextLine();

        while(!sim.isSimDead()) { 
            System.out.println("Silahkan pilih aksi yang ingin dijalankan: ");
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

            Integer nomor = input.nextInt();
            if (nomor.equals(1)) {
                System.out.println("Nama SIM: " + sim.getNama());
                System.out.println("Kekenyangan anda: " + sim.getKekenyangan());
                System.out.println("Kesehatan anda: " + sim.getKesehatan());
                System.out.println("Mood anda: " + sim.getMood());
                System.out.println("Pekerjaan anda: " + sim.getPekerjaan());
                System.out.println("Status anda: " + sim.getAksi());
                nextLine();
            }
            else if (nomor.equals(2)) {
                world.printWorld();
                world.printRumah();
                System.out.println("Saat ini "+ sim.getNama() + " berada dalam " + namaRumah + " Pada koordinat " + rumah.getX() + "," + rumah.getY());
                nextLine();
                // System.out.println("Saat ini " + sim.getNama() + " berada di ruangan " + sim.getRuangan().getNamaRuangan());
            }
            else if (nomor.equals(3)) {
                System.out.println("Inventory anda: ");
                bahanMakanan.tambahBahanMakanan("Wortel");
                bahanMakanan.tambahBahanMakanan("Wortel");
                bahanMakanan.tambahBahanMakanan("Wortel");
                bahanMakanan.tambahBahanMakanan("Bayam");
                bahanMakanan.tambahBahanMakanan("Kacang");
                barang.tambahBarang("Toilet");
                barang.tambahBarang("Toilet");
                barang.tambahBarang("Toilet");
                bahanMakanan.printBahanMakanan();
                barang.printBarangInventory();
                nextLine();
            }
            else if (nomor.equals(4)) {
                nextLine();
            }
            else if (nomor.equals(5)) {
                nextLine();
            }
            else if (nomor.equals(6)) {
                nextLine();
            }
            else if (nomor.equals(7)) {
                nextLine();
            }
            else if (nomor.equals(8)) {
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
                            System.out.println("Anda sudah sampai " + barang.getNames(0));
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
                            System.out.println("Anda sudah sampai " + barang.getNames(1));
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
                            System.out.println("Anda sudah sampai " + barang.getNames(2));
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
                            System.out.println("Anda sudah sampai " + barang.getNames(3));
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
                            System.out.println("Anda sudah sampai " + barang.getNames(4));
                            System.out.println("Apakah anda ingin memasak? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                sim.doMasak(sim.getMood());
                                System.out.println("Anda sudah selesai memasak");
                                nextLine();
                            }
                            else {
                                nextLine();
                            }
                        }
                        else if (nomor1.equals("Kompor Listrik")) {
                            System.out.println("Anda sudah sampai " + barang.getNames(5));
                            System.out.println("Apakah anda ingin memasak? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                sim.doMasak(sim.getMood());
                                System.out.println("Anda sudah selesai memasak");
                                nextLine();
                            }
                            else {
                                nextLine();
                            }
                        }
                        else if (nomor1.equals("Meja dan Kursi")) {
                            System.out.println("Anda sudah sampai " + barang.getNames(6));
                            System.out.println("Apakah anda ingin makan? (y/n)");
                            String jawaban1 = input.next();
                            if (jawaban1.equals("y")) {
                                sim.doMakan(sim.getKekenyangan());
                                System.out.println("Anda sudah selesai makan");
                                nextLine();
                            }
                            else {
                                nextLine();
                            }
                        }
                        else if (nomor1.equals("Jam")) {
                            System.out.println("Andfa sudah sampai " + barang.getNames(7));
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
                            System.out.println("Anda sudah sampai " + barang.getNames(8));
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
                            System.out.println("Anda sudah sampai " + barang.getNames(9));
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
                            System.out.println("Anda sudah sampai " + barang.getNames(10));
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
                            System.out.println("Anda sudah sampai " + barang.getNames(11));
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
                            System.out.println("Anda sudah sampai " + barang.getNames(12));
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
                            System.out.println("Anda sudah sampai rak" + barang.getNames(13));
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
                            System.out.println("Anda sudah sampai " + barang.getNames(14));
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
                                sim.doBeliMakanan(sim.getUang());
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
                                sim.doBeliMakanan(sim.getUang());
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
                                sim.doBeliMakanan(sim.getUang());
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
                                sim.doBeliMakanan(sim.getUang());
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
                                sim.doBeliMakanan(sim.getUang());
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
                                sim.doBeliMakanan(sim.getUang());
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
                                sim.doBeliMakanan(sim.getUang());
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
                                sim.doBeliMakanan(sim.getUang());
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
                            sim.beliBarang(sim.getUang());
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
                            sim.beliBarang(sim.getUang());
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
                            sim.beliBarang(sim.getUang());
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
                            sim.beliBarang(sim.getUang());
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
                            sim.beliBarang(sim.getUang());
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
                            sim.beliBarang(sim.getUang());
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
                            sim.beliBarang(sim.getUang());
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
                            sim.beliBarang(sim.getUang());
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
                            sim.beliBarang(sim.getUang());
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
                            sim.beliBarang(sim.getUang());
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
                            sim.beliBarang(sim.getUang());
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
                            sim.beliBarang(sim.getUang());
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
                            sim.beliBarang(sim.getUang());
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
                            sim.beliBarang(sim.getUang());
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
                            sim.beliBarang(sim.getUang());
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