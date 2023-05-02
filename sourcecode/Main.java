import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Waktu waktu = new Waktu();
        // waktu.startGame();
        World world = new World(64, 64);
        Sim sim = new Sim(null, null, 100, 80, 80, "idle", 80);
        System.out.println("Masukkan nama sim: ");
        Scanner input = new Scanner(System.in);
        Waktu waktu = new Waktu();
        String jalan = input.next();
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
        while (y > 64) {
            System.out.println("Posisi y tidak valid");
            System.out.println("Masukkan posisi y rumah: ");
            y = input.nextInt();
        }
        Rumah rumah = new Rumah(x, y);
        world.tambahRumah(nama, rumah);
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
                            sim.doTidur(sim.getKesehatan(), sim.getMood());
                            nextLine();
                        }
                        else if (nomor1.equals("Kasur Queen Size")) {
                            System.out.println("Anda sudah sampai " + barang.getNames(1));
                            System.out.println("Apakah anda ingin tidur? (y/n)");
                            sim.doTidur(sim.getKesehatan(), sim.getMood());
                            nextLine();
                        }
                        else if (nomor1.equals("Kasur King Size")) {
                            System.out.println("Anda sudah sampai " + barang.getNames(2));
                            System.out.println("Apakah anda ingin tidur? (y/n)");
                            sim.doTidur(sim.getKesehatan(), sim.getMood());
                            nextLine();
                        }
                        else if (nomor1.equals("Toilet")) {
                            System.out.println("Anda sudah sampai " + barang.getNames(3));
                            System.out.println("Apakah anda ingin buang air? (y/n)");
                            sim.doBuangAir(sim.getKesehatan(), sim.getMood());
                            nextLine();
                        }
                        else if (nomor1.equals("Kompor Gas")) {
                            System.out.println("Anda sudah sampai " + barang.getNames(4));
                            System.out.println("Apakah anda ingin memasak? (y/n)");
                            sim.doMasak(sim.getMood());
                            nextLine();
                        }
                        else if (nomor1.equals("Kompor Listrik")) {
                            System.out.println("Anda sudah sampai " + barang.getNames(5));
                            System.out.println("Apakah anda ingin memasak? (y/n)");
                            sim.doMasak(sim.getMood());
                            nextLine();
                        }
                        else if (nomor1.equals("Meja dan Kursi")) {
                            System.out.println("Anda sudah sampai " + barang.getNames(6));
                            System.out.println("Apakah anda ingin makan? (y/n)");
                            sim.doMakan(sim.getKekenyangan());
                            nextLine();
                        }
                        else if (nomor1.equals("Jam")) {
                            System.out.println("Andfa sudah sampai " + barang.getNames(7));
                            System.out.println("Apakah anda ingin melihat waktu? (y/n)");
                            waktu.printWaktu();
                            nextLine();
                        }
                        else if (nomor1.equals("Treadmill")) {
                            System.out.println("Anda sudah sampai " + barang.getNames(8));
                            nextLine();
                        }
                        else if (nomor1.equals("Gitar")) {
                            System.out.println("Anda sudah sampai " + barang.getNames(9));
                            nextLine();
                        }
                        else if (nomor1.equals("Sapu")) {
                            System.out.println("Anda sudah sampai " + barang.getNames(10));
                            nextLine();
                        }
                        else if (nomor1.equals("Tv")) {
                            System.out.println("Anda sudah sampai " + barang.getNames(11));
                            nextLine();
                        }
                        else if (nomor1.equals("Sajadah")) {
                            System.out.println("Anda sudah sampai " + barang.getNames(12));
                        }
                        else if (nomor1.equals("Buku")) {
                            System.out.println("Anda sudah sampai " + barang.getNames(13));
                        }
                        else if (nomor1.equals("Baju")) {
                            System.out.println("Anda sudah sampai " + barang.getNames(14));
                        }
                    }
                    else if (jawaban.equals("n")) {
                        System.out.println("Anda tidak sudah sampai objek tersebut");
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
                sim.doMenyapu(sim.getKesehatan(), sim.getMood());
                waktu.printWaktu();
                // // waktu.checkTime();
                // waktu.checkTime();
                // sim.doTidur(sim.getMood(), sim.getKesehatan());
                // waktu.checkTime();
            }
            else if (nomor.equals(12)) {
                System.out.println(""); //arahan permainan
                nextLine();
            } 
            else if (nomor.equals(13)) {
                System.out.println("Apakah Anda yakin ingin keluar? (y/n)");
                if (input.next().equals("y")) {
                    System.out.println("Terima kasih telah bermain");
                    break;
                }
                else if (input.nextLine().equals("n")) {
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
    public static void nextLine() {
        System.out.println("Press enter to continue...");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }
}
